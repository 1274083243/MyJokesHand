package joke.ike.com.myjokeshand.mvp.presenter;

import android.util.Log;

import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import joke.ike.com.myjokeshand.api.NewJokesApi;
import joke.ike.com.myjokeshand.model.RequestParam;
import joke.ike.com.myjokeshand.model.dataModel.NewTextJokeModel;
import joke.ike.com.myjokeshand.mvp.view.NewTextJokeFragmentView;
import joke.ike.com.myjokeshand.ui.base.baseMvp.BasePresenter;
import joke.ike.com.myjokeshand.utils.GsonUtils;
import joke.ike.com.myjokeshand.utils.RetrofitUtils;
import joke.ike.com.myjokeshand.utils.httpUtils.HttpResultListener;

/**
作者：ike
时间：2017/1/22 11:48
功能描述：首页文本笑话代理类
**/

public class NewTextJokeFragmentPresenter extends BasePresenter<NewTextJokeFragmentView>{
    private String Tag=NewTextJokeFragmentPresenter.class.getSimpleName();
    /**
     * 获取文本笑话
     * @param param
     * @param activity
     *
     */
    public void getTextJokeData(RequestParam param, RxAppCompatActivity activity) {
       final NewJokesApi api=new NewJokesApi(param);
        //开始网络数据请求
        RetrofitUtils.getInstance(new HttpResultListener() {
            @Override
            public void onSuccess(String info) {
                try {
                    JSONObject jsonObject = new JSONObject(info);
                    List<NewTextJokeModel> newTextJokeModels = GsonUtils.jsonToArrayList(jsonObject.getString("result"),NewTextJokeModel.class);
                    if (!newTextJokeModels.isEmpty()){
                        view.notifyDataChanged(newTextJokeModels);
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

    }
}
