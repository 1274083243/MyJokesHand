package joke.ike.com.myjokeshand.utils;

import android.nfc.Tag;
import android.util.Log;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import joke.ike.com.myjokeshand.utils.httpUtils.BaseApi;
import joke.ike.com.myjokeshand.utils.httpUtils.HttpResultListener;
import joke.ike.com.myjokeshand.utils.httpUtils.ProgressDialogSubscriber;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
作者：ike
时间：2017/1/12 16:33
功能描述：retrofit辅助工具类，用于初始化Retrofit相关数据
**/

public class RetrofitUtils {
    private String Tag="RetrofitUtils";
    private HttpResultListener listener;
    private SoftReference<RxAppCompatActivity> activity;
    public static volatile RetrofitUtils instance;
    private OkHttpClient client;
    //基础配置信息
     /*超时时间-默认10秒*/
    private int defaultTime = 10;
    private RetrofitUtils(HttpResultListener listener,RxAppCompatActivity activity){
        initRetrofit();
        this.activity=new SoftReference<RxAppCompatActivity>(activity);
        this.listener=listener;
    }
    /**
     * 构造单例
     * @return
     */
    public static RetrofitUtils getInstance(HttpResultListener listener,RxAppCompatActivity activity){
//        if (instance==null){
//            synchronized (RetrofitUtils.class){
//                if (instance==null){
//
//                }
//            }
//        }
        instance=new RetrofitUtils(listener,activity);
        return instance;
    }
    /**
     * 初始化Retrofit
     */
    private void initRetrofit(){
        client=new OkHttpClient.Builder()
                .writeTimeout(defaultTime, TimeUnit.SECONDS)
                .readTimeout(defaultTime,TimeUnit.SECONDS)
                .connectTimeout(defaultTime,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    /**
     * 网络请求封装类
     * @param api
     */
    public void doHttpRequest(BaseApi api) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantUtils.RANDOM_BASE_URL)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ProgressDialogSubscriber subscriber=new ProgressDialogSubscriber(api,activity,listener);
        Observable observable=api.getObservable(retrofit)
                .compose(activity.get().bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
                 observable.subscribe(subscriber);
    }

}
