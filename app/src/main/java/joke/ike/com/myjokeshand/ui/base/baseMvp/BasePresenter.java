package joke.ike.com.myjokeshand.ui.base.baseMvp;

import com.orhanobut.logger.Logger;

/**
 * 所有代理者的基类
 * Created by ike on 2016/12/29.
 */

public class BasePresenter<V extends BaseView> implements Presenter<V>{
    protected V view;
    @Override
    public void attachView(V view) {
        this.view=  view;
    }

    @Override
    public void detachView() {
        view=null;
    }

}
