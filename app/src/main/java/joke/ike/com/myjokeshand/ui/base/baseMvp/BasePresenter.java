package joke.ike.com.myjokeshand.ui.base.baseMvp;

/**
 * 所有代理者的基类
 * Created by ike on 2016/12/29.
 */

public class BasePresenter<V extends BaseView> implements Presenter<BaseView>{
    protected V view;
    @Override
    public void attachView(BaseView view) {
        this.view= (V) view;
    }

    @Override
    public void detachView() {
        view=null;
    }

}
