package joke.ike.com.myjokeshand.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import joke.ike.com.myjokeshand.Adapter.HomeFragPagerAdapter;
import joke.ike.com.myjokeshand.R;
import joke.ike.com.myjokeshand.ui.fragment.homefragment.NewImageJokeFragment;
import joke.ike.com.myjokeshand.ui.fragment.homefragment.NewTextJokeFragment;
import joke.ike.com.myjokeshand.widget.NewRefreshLayout;
import joke.ike.com.myjokeshand.widget.homewidget.NoScrollViewPager;
import joke.ike.com.myjokeshand.widget.homewidget.WantScrollViewPager;

/**
 * Created by ike on 2016/12/29.
 * 首页
 */

public class HomeFragment extends BaseFragment {

   public static NewRefreshLayout reFreshLayout;
    private String Tag = "HomeFragment";
    @Bind(R.id.home_vp)
    WantScrollViewPager homeVp;
    private HomeFragPagerAdapter adapter;
    @Override
    public View getViewLayout() {

        tv_title.setText("首页");
        View view=View.inflate(getActivity(), R.layout.frag_home, null);
        reFreshLayout= (NewRefreshLayout) view.findViewById(R.id.reFresh_layout);
        return view;
    }

    @Override
    public void initData() {

        adapter=new HomeFragPagerAdapter(activity.getSupportFragmentManager());
        homeVp.setNestParent(reFreshLayout);
        homeVp.setAdapter(adapter);
    }

    @Override
    public void initlistener() {
        reFreshLayout.setOnRefreshListener(new NewRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                switch (homeVp.getCurrentItem()){
                    case 0:
                        NewTextJokeFragment fragment = (NewTextJokeFragment) adapter.getFragment(0);
                        fragment.onRefresh();
                        break;
                    case 1:
                        NewImageJokeFragment fragment2 = (NewImageJokeFragment) adapter.getFragment(1);
                        fragment2.onRefresh();
                        break;
                }


            }
        });
        homeVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        NewTextJokeFragment fragment = (NewTextJokeFragment) adapter.getFragment(0);
                        reFreshLayout.setContentView(fragment.getContentView());
                        break;
                    case 1:
                        NewImageJokeFragment fragment2 = (NewImageJokeFragment) adapter.getFragment(1);
                        reFreshLayout.setContentView(fragment2.getContentView());
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
