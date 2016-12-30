package joke.ike.com.myjokeshand.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import joke.ike.com.myjokeshand.R;
import joke.ike.com.myjokeshand.ui.base.baseMvp.BasePresenter;
import joke.ike.com.myjokeshand.ui.base.baseMvp.BaseView;
import joke.ike.com.myjokeshand.widget.ErrorOrEmptyOrLoadingLayout;

/**
 * Created by ike on 2016/12/29.
 */

public  class BaseFragment<P extends BasePresenter<V>,V extends BaseView> extends Fragment implements BaseView{
    protected View rootview;
    protected P presenter;//代理者
    private FrameLayout container;
    protected TextView tv_title;//标题
    private ErrorOrEmptyOrLoadingLayout err_layout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview=View.inflate(getActivity(), R.layout.frag_base,null);
        tv_title= (TextView) rootview.findViewById(R.id.tv_title);
        err_layout= (ErrorOrEmptyOrLoadingLayout) rootview.findViewById(R.id.err_layout);
        container= (ViewGroup) rootview.findViewById(R.id.container);
        container.addView(getViewLayout());
        ButterKnife.bind(this,rootview);
        return rootview;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
    public  View getViewLayout(){
        return null;
    };

    @Override
    public void showLoadingView() {
        container.setVisibility(View.GONE);
        err_layout.showLoading();

    }

    @Override
    public void showErrorView() {
        container.setVisibility(View.GONE);
        err_layout.showEmpty();
    }

    @Override
    public void showNetErrView() {
        container.setVisibility(View.GONE);
        err_layout.showNetErr();
    }

}
