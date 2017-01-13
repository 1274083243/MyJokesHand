package joke.ike.com.myjokeshand.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import joke.ike.com.myjokeshand.Adapter.MainAdapter;
import joke.ike.com.myjokeshand.R;
import joke.ike.com.myjokeshand.ui.fragment.BaseFragment;
import joke.ike.com.myjokeshand.ui.fragment.FunnyPicFragment;
import joke.ike.com.myjokeshand.ui.fragment.HomeFragment;
import joke.ike.com.myjokeshand.ui.fragment.JokesFragment;
import joke.ike.com.myjokeshand.ui.fragment.MyCircleFragment;
import joke.ike.com.myjokeshand.ui.fragment.PersonnalFragment;
import joke.ike.com.myjokeshand.widget.homewidget.AppBottomLayout;
import joke.ike.com.myjokeshand.widget.homewidget.NoScrollViewPager;

public class MainActivity extends FragmentActivity {
    @Bind(R.id.main_vp)
    NoScrollViewPager mainVp;
    @Bind(R.id.bottom_bar)
    AppBottomLayout bottomBar;
    private String Tag = "MainActivity";
    private List<BaseFragment> baseFragmentList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bottomBar.setViewpager(mainVp);
        initData();
    }

    private void initData() {
        baseFragmentList.add(new HomeFragment());
        baseFragmentList.add(new JokesFragment());
        baseFragmentList.add(new FunnyPicFragment());
        baseFragmentList.add(new MyCircleFragment());
        baseFragmentList.add(new PersonnalFragment());
        mainVp.setAdapter(new MainAdapter(getSupportFragmentManager(),baseFragmentList));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
