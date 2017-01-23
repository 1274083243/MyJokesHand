package joke.ike.com.myjokeshand.utils.httpUtils;

/**
作者：ike
时间：2017/1/18 15:22
功能描述：网络返回结果监听
**/

public interface HttpResultListener {
    /**
     * 成功
     * @param info
     */
     void onSuccess(String info);

    /**
     * 失败
     * @param info
     */
     void onFail(String info);
}
