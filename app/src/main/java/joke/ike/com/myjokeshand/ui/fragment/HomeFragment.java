package joke.ike.com.myjokeshand.ui.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import joke.ike.com.myjokeshand.R;

/**
 * Created by ike on 2016/12/29.
 * 首页
 */

public class HomeFragment extends BaseFragment {

    @Bind(R.id.home_vp)
    ViewPager homeVp;
    @Override
    public View getViewLayout() {
        tv_title.setText("首页");
        return View.inflate(getActivity(), R.layout.frag_home, null);
    }

}
