package joke.ike.com.myjokeshand.ui.base.baseMvp;

/**
 * Created by ike on 2016/12/29.
 * 所有view的基类
 */

public interface BaseView {
    void showLoadingView();
    void showErrorView();
    void showNetErrView();
}
