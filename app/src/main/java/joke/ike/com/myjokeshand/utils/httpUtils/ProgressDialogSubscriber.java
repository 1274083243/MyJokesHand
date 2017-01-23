package joke.ike.com.myjokeshand.utils.httpUtils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import com.orhanobut.logger.Logger;

import java.lang.ref.SoftReference;

import joke.ike.com.myjokeshand.exception.ApiException;
import joke.ike.com.myjokeshand.exception.CodeException;
import joke.ike.com.myjokeshand.exception.HttpTimeException;
import rx.Subscriber;

/**
 * 作者：ike
 * 时间：2017/1/18 15:34
 * 功能描述：进度对话框观察者，
 *          用于每次网络请求时，进行网络请求进度的提示，网络访问完毕后自动关闭
 **/

public class ProgressDialogSubscriber<T> extends Subscriber<T> {
    private ProgressDialog pd;
    private BaseApi baseApi;
    private HttpResultListener listener;
    private SoftReference<Activity> context;

    public ProgressDialogSubscriber(BaseApi baseApi, SoftReference<Activity> context, HttpResultListener listener) {
        this.baseApi = baseApi;
        this.context = context;
        this.listener = listener;
        initDialog();
    }

    /**
     * 初始化dialog
     */
    public void initDialog(){
        Context activity=context.get();
        if (baseApi.isProgressDialogShow){
            if (pd==null&&activity!=null){
                pd=new ProgressDialog(activity);
                pd.setCancelable(baseApi.dialogCanBeCancle);
                if (baseApi.dialogCanBeCancle){
                    pd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            cancleUnSubscribed();
                        }
                    });
                }
            }
        }
    }
    @Override
    public void onStart() {
        Logger.d("onStart");
        showDialog();
        super.onStart();
    }

    @Override
    public void onCompleted() {
        Logger.d("onCompleted");
        dismissDialog();
    }

    @Override
    public void onError(Throwable e) {
        Logger.d("onError");
        if (listener!=null){
            listener.onFail(e.getMessage()+e);
        }
        dismissDialog();

    }

    @Override
    public void onNext(T o) {
        Logger.d("onNext:"+(String)o);
        if (listener!=null){
            Logger.d("执行了:");
            listener.onSuccess((String) o);
        }

    }
    public void showDialog(){
        if (pd!=null&&!pd.isShowing()){
            pd.show();
        }
    }
    public void dismissDialog(){
        if (pd!=null&&pd.isShowing()){
            pd.dismiss();
        }
    }

    /**
     *取消订阅：弹窗消失取消http网络请求
     */
    public void cancleUnSubscribed(){
        if (!this.isUnsubscribed()){
            this.unsubscribe();
        }
    }

    /**
     * 错误时执行的方法，进行错误统一判断
     */
    private  void doError(Throwable e){
        Activity context = this.context.get();
        if (context == null) return;
        if (listener == null) return;
        if (e instanceof ApiException) {
            listener.onFail(e.getMessage());
        } else if (e instanceof HttpTimeException) {
            HttpTimeException exception = (HttpTimeException) e;
            listener.onFail(exception.getMessage());
        } else {
            listener.onFail(e.getMessage());
        }
        /*可以在这里统一处理错误处理-可自由扩展*/
        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();

    }
}
