package joke.ike.com.myjokeshand.widget.homewidget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by ike on 2016/12/29.
 * 不可滑动的viewpager
 */

public class NoScrollViewPager extends ViewPager{
    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    private float startX;
    private float startY;
    private float endX;
    private float endY;
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        switch (ev.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                startX=ev.getX();
//                startY=ev.getY();
//                break;
//            case MotionEvent.ACTION_MOVE:
//                endX=ev.getX();
//                endY=ev.getY();
//                if (Math.abs(endX-startX)>Math.abs(endY-startY)){
//                    return false;
//                }
//                break;
//            case MotionEvent.ACTION_UP:
//                break;
//        }
//        return super.dispatchTouchEvent(ev);
//    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}
