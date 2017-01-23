package joke.ike.com.myjokeshand.utils.httpUtils;

import joke.ike.com.myjokeshand.model.RequestParam;
import retrofit2.Retrofit;
import rx.Observable;

/**
作者：ike
时间：2017/1/12 17:29
功能描述：所有Api接口的基类
**/

public abstract class BaseApi {
    /**
     * 网络总路径
     */
    public String base_url="";
    /**
     * 是否进度条弹窗显示
     */
    public boolean isProgressDialogShow;
    /**
     * 进度框是否能被取消
     */
    public boolean dialogCanBeCancle;

    /**
     * 获取Rx观察者对象
     * @param retrofit
     * @return
     */
    public abstract Observable getObservable(Retrofit retrofit);
    protected RequestParam requestParam;

    public BaseApi(RequestParam requestParam) {
        this.requestParam = requestParam;
    }
}
