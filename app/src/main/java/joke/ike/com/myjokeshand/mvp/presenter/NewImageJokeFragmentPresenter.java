package joke.ike.com.myjokeshand.mvp.presenter;

import android.util.Log;

import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import joke.ike.com.myjokeshand.api.NewImageJokesApi;
import joke.ike.com.myjokeshand.model.RequestParam;
import joke.ike.com.myjokeshand.model.dataModel.NewImageJokeModel;
import joke.ike.com.myjokeshand.mvp.view.NewImageJokeFragmentView;
import joke.ike.com.myjokeshand.ui.base.baseMvp.BasePresenter;
import joke.ike.com.myjokeshand.utils.GsonUtils;
import joke.ike.com.myjokeshand.utils.RetrofitUtils;
import joke.ike.com.myjokeshand.utils.httpUtils.HttpResultListener;

/**
作者：ike
时间：2017/1/23 10:13
 功能描述：首页图片笑话代理类
**/

public class NewImageJokeFragmentPresenter extends BasePresenter<NewImageJokeFragmentView>{
    private String Tag=NewImageJokeFragmentPresenter.class.getSimpleName();

    /**
     * 获取图文笑话
     * @param param
     * @param activity
     */
    public void getImageJokeData(RequestParam param, RxAppCompatActivity activity) {
        final NewImageJokesApi api=new NewImageJokesApi(param);
        //开始网络数据请求
        RetrofitUtils.getInstance(new HttpResultListener() {
            @Override
            public void onSuccess(String info) {
                try {
                    Logger.json(info);
                    JSONObject jsonObject = new JSONObject(info);
                    List<NewImageJokeModel> newImageJokeModels = GsonUtils.jsonToArrayList(jsonObject.getString("result"),NewImageJokeModel.class);
                    if (!newImageJokeModels.isEmpty()){
                        view.notifyDataChanged(newImageJokeModels);
                        view.showDataView();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            @Override
            public void onFail(String info) {
                view.showErrorView();
                Log.e(Tag,"失败了:"+info);
            }
        }, activity).doHttpRequest(api);
        Logger.d("开始获取数据");
    }

}
