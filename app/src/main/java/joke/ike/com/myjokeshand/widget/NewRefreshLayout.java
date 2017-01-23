package joke.ike.com.myjokeshand.widget;

import android.content.Context;
import android.nfc.Tag;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import joke.ike.com.myjokeshand.headView.NormalHeadView;
/**
作者：ike
时间：2017/1/17 13:56
功能描述：下拉刷新控件
**/

public class NewRefreshLayout extends PtrFrameLayout  {
    private String Tag="NewRefreshLayout";
    NormalHeadView mHeaderView;
    private OnRefreshListener listener;
    private View contentView;
    private PtrHandler ptrHandler=new PtrHandler() {
        @Override
        public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {

            return !canChildBeDragDown(contentView);
        }

        @Override
        public void onRefreshBegin(PtrFrameLayout frame) {
            if (listener!=null){
                listener.onRefresh();
            }
        }
    };
    public NewRefreshLayout(Context context) {
        super(context);
        initView();

    }

    public NewRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public NewRefreshLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    /**
     * 初始化view
     */
    private void initView() {
        mHeaderView = new NormalHeadView(getContext());
        setResistance(2.6f);
        setHeaderView(mHeaderView);
        addPtrUIHandler(mHeaderView);
        setPtrHandler(ptrHandler);
    }


    /**
     * 判断子控件能否向下拉,主要代码来自{@link SwipeRefreshLayout#canChildScrollUp()}
     *
     * @return 能则返回true
     */
    private boolean canChildBeDragDown(View contentView)
    {
        //如果用户自己实现判断逻辑，则以用户的逻辑为准
        if (contentView == null) {

            return false;
        }
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            if (contentView instanceof AbsListView)
            {
                final AbsListView absListView = (AbsListView) contentView;
                return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
            } else
            {
                return ViewCompat.canScrollVertically(contentView, -1) || contentView.getScrollY() > 0;
            }
        } else
        {
            return contentView.canScrollVertically(-1);
        }
    }

    public interface  OnRefreshListener{
        void onRefresh();
    }
    public void setOnRefreshListener(OnRefreshListener listener){
        this.listener=listener;
    }
    public void setContentView(View view){
        this.contentView=view;
    }
    private boolean disallowInterceptTouchEvent = false;
    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        disallowInterceptTouchEvent = disallowIntercept;
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }
    private float startX;
    private float startY;
    private float endX;
    private float endY;
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                startX=ev.getX();
                startY=ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                endX=ev.getX();
                endY=ev.getY();
                if (Math.abs(endX-startX)>Math.abs(endY-startY)){
                    if (disallowInterceptTouchEvent) {
                        return dispatchTouchEventSupper(ev);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }
}
