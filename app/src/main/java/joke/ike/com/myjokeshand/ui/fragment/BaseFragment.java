package joke.ike.com.myjokeshand.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import joke.ike.com.myjokeshand.R;
import joke.ike.com.myjokeshand.ui.base.baseMvp.BasePresenter;
import joke.ike.com.myjokeshand.ui.base.baseMvp.BaseView;
import joke.ike.com.myjokeshand.widget.homewidget.ErrorOrEmptyOrLoadingLayout;

/**
 * Created by ike on 2016/12/29.
 */

public abstract class BaseFragment<P extends BasePresenter<V>,V extends BaseView> extends Fragment implements BaseView{
    protected View rootview;
    protected P presenter;//代理者
    protected FrameLayout mContainer;
    protected TextView tv_title;//标题
    private ErrorOrEmptyOrLoadingLayout err_layout;
    protected RxAppCompatActivity activity;
    protected RelativeLayout title_container;
    protected boolean isLoadMore;
    protected boolean isRefresh;
    protected boolean isFirst=true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        activity= (RxAppCompatActivity) getActivity();
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview=View.inflate(getActivity(), R.layout.frag_base,null);
        tv_title= (TextView) rootview.findViewById(R.id.tv_title);
        err_layout= (ErrorOrEmptyOrLoadingLayout) rootview.findViewById(R.id.err_layout);
        mContainer= (FrameLayout) rootview.findViewById(R.id.container);
        title_container= (RelativeLayout) rootview.findViewById(R.id.title_container);
        mContainer.addView(getViewLayout());
        ButterKnife.bind(this,rootview);
        return rootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        initData();
        initlistener();
        //presenter.attachView((V) this);
        super.onViewCreated(view, savedInstanceState);
    }

    /**
     * 初始化事件监听
     */
    public abstract void initlistener() ;

    /**
     * 初始化数据
     */
    public abstract void initData() ;


    @Override
    public void onDestroyView() {

        ButterKnife.unbind(this);
        //presenter.detachView();
        super.onDestroyView();
    }
    public abstract View getViewLayout();

    @Override
    public void showLoadingView() {
        err_layout.setVisibility(View.VISIBLE);
        mContainer.setVisibility(View.GONE);
        err_layout.showLoading();

    }

    @Override
    public void showErrorView() {
        err_layout.setVisibility(View.VISIBLE);
        mContainer.setVisibility(View.GONE);
        err_layout.showEmpty();
    }

    @Override
    public void showNetErrView() {
        err_layout.setVisibility(View.VISIBLE);
        mContainer.setVisibility(View.GONE);
        err_layout.showNetErr();
    }

    @Override
    public void showDataView() {
        mContainer.setVisibility(View.VISIBLE);
        err_layout.setVisibility(View.GONE);
    }
}
