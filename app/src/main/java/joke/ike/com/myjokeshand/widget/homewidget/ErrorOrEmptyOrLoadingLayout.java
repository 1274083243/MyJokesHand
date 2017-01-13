package joke.ike.com.myjokeshand.widget.homewidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import joke.ike.com.myjokeshand.R;

/**
 * Created by ike on 2016/12/29.
 * 空布局或是加载中的提示布局
 */

public class ErrorOrEmptyOrLoadingLayout extends LinearLayout {
    private View rootView;
    private TextView tv_err_notice;
    private ImageView iv_err;
    private ProgressBar progressBar;
    public ErrorOrEmptyOrLoadingLayout(Context context) {
        this(context,null);
    }

    public ErrorOrEmptyOrLoadingLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ErrorOrEmptyOrLoadingLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        rootView=View.inflate(context, R.layout.err_loading_empty_view,this);
        tv_err_notice= (TextView) rootView.findViewById(R.id.tv_err_notice);
        iv_err= (ImageView) rootView.findViewById(R.id.iv_err);
        progressBar= (ProgressBar) rootView.findViewById(R.id.progressBar);
    }
    public void showLoading(){
        progressBar.setVisibility(VISIBLE);
        iv_err.setVisibility(GONE);
        tv_err_notice.setText("加载中...");
    }
    public void showNetErr(){
        progressBar.setVisibility(GONE);
        iv_err.setVisibility(VISIBLE);
        iv_err.setImageResource(R.mipmap.ic_error);
        tv_err_notice.setText("网络异常，重新加载");
    }
    public void showEmpty(){
        progressBar.setVisibility(GONE);
        iv_err.setVisibility(VISIBLE);
        iv_err.setImageResource(R.mipmap.error_place);
        tv_err_notice.setText("暂无数据");
    }
}
