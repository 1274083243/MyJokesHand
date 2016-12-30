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
 * 个人
 */

public class PersonnalFragment extends BaseFragment {
    @Override
    public View getViewLayout() {
        tv_title.setText("个人");
        return View.inflate(getContext(), R.layout.frag_persoal,null);
    }
}
