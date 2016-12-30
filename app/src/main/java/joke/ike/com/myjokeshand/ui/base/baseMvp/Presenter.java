package joke.ike.com.myjokeshand.ui.base.baseMvp;

/**
 * 所有代理类的基类
 * 实现view和presenter的绑定与解绑
 * Created by ike on 2016/12/29.
 */

public interface Presenter<V extends BaseView> {
    void attachView(V view);
    void detachView();
}
