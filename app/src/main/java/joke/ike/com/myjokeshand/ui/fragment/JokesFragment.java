package joke.ike.com.myjokeshand.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import joke.ike.com.myjokeshand.R;

/**
 * Created by ike on 2016/12/29.
 * 段子
 */

public class JokesFragment extends BaseFragment {
    @Override
    public View getViewLayout() {
        tv_title.setText("段子");
        return View.inflate(getContext(), R.layout.frag_jokes,null);
    }
}
