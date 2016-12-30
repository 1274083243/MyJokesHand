package joke.ike.com.myjokeshand.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

import joke.ike.com.myjokeshand.ui.fragment.BaseFragment;

/**
 * Created by ike on 2016/12/29.
 * app五个tab栏的数据适配器
 */

public class MainAdapter extends FragmentPagerAdapter {

    List<BaseFragment> baseFragmentList;

    public MainAdapter(FragmentManager fm,List<BaseFragment> baseFragmentList) {
        super(fm);
        this.baseFragmentList=baseFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        if (baseFragmentList!=null&&baseFragmentList.size()>0){
            return baseFragmentList.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        if (baseFragmentList!=null&&baseFragmentList.size()>0){
            return baseFragmentList.size();
        }
        return 0;
    }
}
