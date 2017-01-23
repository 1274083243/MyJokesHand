package joke.ike.com.myjokeshand.ui.fragment.homefragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.orhanobut.logger.Logger;

import java.util.List;

import butterknife.Bind;
import joke.ike.com.myjokeshand.Adapter.NewImageJokeAdapter;
import joke.ike.com.myjokeshand.Adapter.commonTestAdapter;
import joke.ike.com.myjokeshand.R;
import joke.ike.com.myjokeshand.model.RequestParam;
import joke.ike.com.myjokeshand.model.dataModel.NewImageJokeModel;
import joke.ike.com.myjokeshand.model.dataModel.NewTextJokeModel;
import joke.ike.com.myjokeshand.mvp.presenter.NewImageJokeFragmentPresenter;
import joke.ike.com.myjokeshand.mvp.view.NewImageJokeFragmentView;
import joke.ike.com.myjokeshand.mvp.view.NewTextJokeFragmentView;
import joke.ike.com.myjokeshand.ui.fragment.BaseFragment;
import joke.ike.com.myjokeshand.ui.fragment.HomeFragment;
import joke.ike.com.myjokeshand.utils.ConstantUtils;
import joke.ike.com.myjokeshand.utils.recycleViewUtils.LoadMoreWrapper;

/**
作者：ike
时间：2017/1/18 13:53
功能描述：推荐趣图界面
**/

public class NewImageJokeFragment extends BaseFragment<NewImageJokeFragmentPresenter,NewImageJokeFragmentView> implements NewImageJokeFragmentView{
    private String Tag="NewImageJokeFragment";
    @Bind(R.id.rl)
    RecyclerView rl;
    private LoadMoreWrapper loadMoreAdapter;
    private int currentPage=1;
    private List<NewImageJokeModel> mModels;
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
        presenter=new NewImageJokeFragmentPresenter();
        presenter.attachView(this);
        RequestParam param = getRequestParam(currentPage);
        presenter.getImageJokeData(param,activity);
    }

    @NonNull
    private RequestParam getRequestParam( int currentPage) {
        RequestParam param=new RequestParam();
        param.put("key", ConstantUtils.KEY);
        param.put("pagesize",10);
        param.put("page",currentPage);
        param.put("type","pic");
        return param;
    }

    public View getContentView(){
        return rl;
    }


    @Override
    public void notifyDataChanged(List<NewImageJokeModel> models) {
        if (isFirst){
            isFirst=false;
            mModels=models;
            LinearLayoutManager manager = new LinearLayoutManager(activity);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            rl.setLayoutManager(manager);
            View footView = View.inflate(activity, R.layout.foot_view, null);
            loadMoreAdapter = new LoadMoreWrapper(new NewImageJokeAdapter(mModels));
            loadMoreAdapter.setFootView(footView);
            rl.setAdapter(loadMoreAdapter);
            loadMoreAdapter.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
                @Override
                public void loadMore() {
                    isLoadMore=true;
                    loadMoreAdapter.isLoading=true;
                    currentPage=currentPage+1;
                    presenter.getImageJokeData(getRequestParam(currentPage),activity);
                }
            });
        }
        if (isLoadMore){
            isLoadMore=false;
            loadMoreAdapter.isLoading=false;
            mModels.addAll(models);
            loadMoreAdapter.notifyDataSetChanged();
            return;
        }
        if (isRefresh){
            isRefresh=false;
            mModels.addAll(0,models);
            loadMoreAdapter.notifyDataSetChanged();
            HomeFragment.reFreshLayout.refreshComplete();
            return;
        }


    }
    public void onRefresh(){
        if (!isRefresh){
            presenter.getImageJokeData(getRequestParam(1),activity);
            isRefresh=true;
        }

    }
}
