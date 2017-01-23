package joke.ike.com.myjokeshand.headView;

import android.content.Context;
import android.nfc.Tag;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;
import joke.ike.com.myjokeshand.R;
import joke.ike.com.myjokeshand.widget.HeaderController;
import joke.ike.com.myjokeshand.widget.PullToRefreshLayout;

/**
 * Created by ike on 2017/1/16.
 */

public class NormalHeadView  extends LinearLayout implements PtrUIHandler{
    private String Tag="NormalHeadView";
    private TextView tv_head;
    private ProgressBar progressBar;
    private int height;
    private boolean isRefreshing;
    /**
     * 重置
     * 准备刷新
     * 开始刷新
     * 结束刷新
     */
    public static final int STATE_RESET = -1;
    public static final int STATE_PREPARE = 0;
    public static final int STATE_BEGIN = 1;
    public static final int STATE_FINISH = 2;

    public static final int MARGIN_RIGHT = 100;
    public NormalHeadView(Context context) {
        this(context,null);
    }

    public NormalHeadView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NormalHeadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View headView=View.inflate(context, R.layout.headview,this);
        headView.measure(0,0);
        height=headView.getMeasuredHeight();
        tv_head= (TextView) headView.findViewById(R.id.tv_head);
        progressBar= (ProgressBar) headView.findViewById(R.id.progressBar);
    }

    @Override
    public void onUIReset(PtrFrameLayout frame) {
        tv_head.setText("松开刷新");
        isRefreshing=false;
    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {

    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {
        progressBar.setVisibility(VISIBLE);
        tv_head.setText("刷新中...");
        isRefreshing=true;

    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame) {
        tv_head.setText("松开刷新");
        isRefreshing=false;
    }

    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
        if (!isRefreshing&&isUnderTouch){
            if (ptrIndicator.getCurrentPercent()>1.2){
                tv_head.setText("松开刷新");
                progressBar.setVisibility(GONE);
            }else {
                tv_head.setText("下拉刷新");
                progressBar.setVisibility(GONE);
            }
        }

    }

}
