package joke.ike.com.myjokeshand.ui.fragment.homefragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.orhanobut.logger.Logger;

import java.util.List;

import butterknife.Bind;
import joke.ike.com.myjokeshand.Adapter.NewTextJokeAdapter;
import joke.ike.com.myjokeshand.R;
import joke.ike.com.myjokeshand.model.RequestParam;
import joke.ike.com.myjokeshand.model.dataModel.NewTextJokeModel;
import joke.ike.com.myjokeshand.mvp.presenter.NewTextJokeFragmentPresenter;
import joke.ike.com.myjokeshand.mvp.view.NewTextJokeFragmentView;
import joke.ike.com.myjokeshand.ui.fragment.BaseFragment;
import joke.ike.com.myjokeshand.ui.fragment.HomeFragment;
import joke.ike.com.myjokeshand.utils.ConstantUtils;
import joke.ike.com.myjokeshand.utils.recycleViewUtils.LoadMoreWrapper;

/**
 * 作者：ike
 * 时间：2017/1/16 10:15
 * 功能描述：推荐段子界面
 **/
public class NewTextJokeFragment extends BaseFragment<NewTextJokeFragmentPresenter,NewTextJokeFragmentView> implements NewTextJokeFragmentView {
    private String Tag="NewTextJokeFragment";
    @Bind(R.id.rl)
    RecyclerView rl;
    private LoadMoreWrapper loadMoreAdapter;
    private List<NewTextJokeModel> mModels;
    public static int current_page=1;//当前页的下标


    @Override
    public View getViewLayout() {
        title_container.setVisibility(View.GONE);
        return View.inflate(activity, R.layout.common_lsit_view, null);
    }
    @Override
    public void initlistener() {

    }

    @Override
    public void initData() {
        showLoadingView();
        presenter=new NewTextJokeFragmentPresenter();
        presenter.attachView(this);
        RequestParam param = getRequestParam();
        HomeFragment.reFreshLayout.setContentView(rl);
        presenter.getTextJokeData(param,activity);
    }

    @NonNull
    private RequestParam getRequestParam() {
        RequestParam param=new RequestParam();
        param.put("key", ConstantUtils.KEY);
        param.put("pagesize",ConstantUtils.pageSize);
        param.put("page",current_page);
        param.put("type","");
        return param;
    }

    public View getContentView(){
        return rl;
    }

    @Override
    public void notifyDataChanged(List<NewTextJokeModel> models) {
        if (isRefresh){
            isRefresh=false;
            mModels.addAll(0,models);
            current_page++;
            loadMoreAdapter.notifyDataSetChanged();
            HomeFragment.reFreshLayout.refreshComplete();
            return;
        }
        if (isLoadMore){
            isLoadMore=false;
            loadMoreAdapter.isLoading=false;
            mModels.addAll(models);
            loadMoreAdapter.notifyDataSetChanged();
            return;
        }

        if (isFirst){
            mModels=models;
            isFirst=false;
            LinearLayoutManager manager = new LinearLayoutManager(activity);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            rl.setLayoutManager(manager);
            View footView = View.inflate(activity, R.layout.foot_view, null);
            loadMoreAdapter = new LoadMoreWrapper(new NewTextJokeAdapter(mModels));
            loadMoreAdapter.setFootView(footView);
            rl.setAdapter(loadMoreAdapter);
            loadMoreAdapter.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
                @Override
                public void loadMore() {
                    isLoadMore=true;
                    current_page=current_page+1;
                    loadMoreAdapter.isLoading=true;
                    presenter.getTextJokeData(getRequestParam(),activity);
                }
            });
        }
        HomeFragment.reFreshLayout.refreshComplete();
    }
    public void onRefresh(){
        if (!isRefresh){
            isRefresh=true;
            RequestParam param=new RequestParam();
            param.put("key", ConstantUtils.KEY);
            param.put("pagesize",ConstantUtils.pageSize);
            param.put("page",1);
            param.put("type","");
            presenter.getTextJokeData(getRequestParam(),activity);
        }

    }

}
