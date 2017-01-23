package joke.ike.com.myjokeshand.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.SparseArrayCompat;

import joke.ike.com.myjokeshand.ui.fragment.homefragment.NewImageJokeFragment;
import joke.ike.com.myjokeshand.ui.fragment.homefragment.NewTextJokeFragment;

/**
作者：ike
时间：2017/1/16 10:08
功能描述：首页两个页面的数据设配器
**/

public class HomeFragPagerAdapter extends FragmentPagerAdapter{
    private SparseArrayCompat<Fragment> fragments=new SparseArrayCompat<>();
    public HomeFragPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        return getFragment(position);
    }

    @Override
    public int getCount() {
        return 2;
    }
    public Fragment getFragment(int position){
        Fragment fragment=null;
        fragment= fragments.get(position);
        if (fragment!=null){
            return fragment;
        }
        switch (position){
            case 0:
                fragment=new NewTextJokeFragment();
                break;
            case 1:
                fragment=new NewImageJokeFragment();
                break;
        }
        fragments.put(position,fragment);
        return fragment;
    }

}
