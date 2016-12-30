package joke.ike.com.myjokeshand.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.Bind;
import joke.ike.com.myjokeshand.R;

/**
 * Created by ike on 2016/12/29.
 * app下方的导航栏控件
 */

public class AppBottomLayout extends LinearLayout implements View.OnClickListener {
    private AppBottomLayoutItem home;
    private AppBottomLayoutItem jokes;
    private AppBottomLayoutItem funnyPic;
    private AppBottomLayoutItem myCircle;
    private AppBottomLayoutItem personal;
    private View rootView;
    private ViewPager mViewPager;
    public AppBottomLayout(Context context) {
        this(context, null);
    }

    public AppBottomLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AppBottomLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        rootView = View.inflate(context, R.layout.bottom_layout, this);
        home= (AppBottomLayoutItem) rootView.findViewById(R.id.home);
        jokes= (AppBottomLayoutItem) rootView.findViewById(R.id.jokes);
        funnyPic= (AppBottomLayoutItem) rootView.findViewById(R.id.funny_pic);
        myCircle= (AppBottomLayoutItem) rootView.findViewById(R.id.my_circle);
        personal= (AppBottomLayoutItem) rootView.findViewById(R.id.personal);

        home.setText("首页");
        home.checked(0);
        jokes.setText("段子");
        jokes.unChecked(1);
        funnyPic.setText("趣图");
        funnyPic.unChecked(2);
        myCircle.setText("圈子");
        myCircle.unChecked(3);
        personal.setText("个人");
        personal.unChecked(4);

        jokes.setOnClickListener(this);
        funnyPic.setOnClickListener(this);
        home.setOnClickListener(this);
        myCircle.setOnClickListener(this);
        personal.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home:
                mViewPager.setCurrentItem(0,false);
                home.checked(0);
                jokes.unChecked(1);
                funnyPic.unChecked(2);
                myCircle.unChecked(3);
                personal.unChecked(4);
                break;
            case R.id.jokes:
                mViewPager.setCurrentItem(1,false);
                home.unChecked(0);
                jokes.checked(1);
                funnyPic.unChecked(2);
                myCircle.unChecked(3);
                personal.unChecked(4);
                break;
            case R.id.funny_pic:
                mViewPager.setCurrentItem(2,false);
                home.unChecked(0);
                jokes.unChecked(1);
                funnyPic.checked(2);
                myCircle.unChecked(3);
                personal.unChecked(4);
                break;
            case R.id.my_circle:
                mViewPager.setCurrentItem(3,false);
                home.unChecked(0);
                jokes.unChecked(1);
                funnyPic.unChecked(2);
                myCircle.checked(3);
                personal.unChecked(4);
                break;
            case R.id.personal:
                mViewPager.setCurrentItem(4,false);
                home.unChecked(0);
                jokes.unChecked(1);
                funnyPic.unChecked(2);
                myCircle.unChecked(3);
                personal.checked(4);
                break;

        }
    }

    /**
     * 设置与之关联的viewPager
     * @param vp
     */
    public void setViewpager(ViewPager vp){
        this.mViewPager=vp;

    }


}
