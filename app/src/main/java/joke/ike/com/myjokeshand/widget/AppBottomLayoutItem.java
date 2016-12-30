package joke.ike.com.myjokeshand.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import joke.ike.com.myjokeshand.R;

/**
 * Created by ike on 2016/12/29.
 *
 */

public class AppBottomLayoutItem extends LinearLayout{
    private TextView tv_item_name;
    private ImageView tv_item_icon;
    private View itemView;
    private Context context;
    public AppBottomLayoutItem(Context context) {
        this(context,null);
    }

    public AppBottomLayoutItem(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public AppBottomLayoutItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        itemView=View.inflate(context, R.layout.bottom_layout_item,this);
        tv_item_name= (TextView) itemView.findViewById(R.id.tv_item_name);
        tv_item_icon= (ImageView) itemView.findViewById(R.id.tv_item_icon);
    }

    /**
     * 设置tab文本
     * @param name
     */
    public void setText(String name){
        tv_item_name.setText(name);
    }
    /**
     * 当前item被选中
     */
    public void checked(int itemNum){
        tv_item_name.setTextColor(context.getResources().getColor(R.color.bottom_bar_red));
        switch (itemNum){
            case 0:
                tv_item_icon.setImageResource(R.mipmap.ic_home_select);
                break;
            case 1:
                tv_item_icon.setImageResource(R.mipmap.ic_textjoke_select);
                break;
            case 2:
                tv_item_icon.setImageResource(R.mipmap.ic_imagejoke_select);
                break;
            case 3:
                tv_item_icon.setImageResource(R.mipmap.ic_dt_select);
                break;
            case 4:
                tv_item_icon.setImageResource(R.mipmap.ic_my_select);
                break;
        }

    }

    /**
     * 当前item未被选中
     */
    public void unChecked(int itemNum){
        tv_item_name.setTextColor(context.getResources().getColor(R.color.gray_20));
        switch (itemNum){
            case 0:
                tv_item_icon.setImageResource(R.mipmap.ic_home_unselect);
                break;
            case 1:
                tv_item_icon.setImageResource(R.mipmap.ic_textjoke_unselect);
                break;
            case 2:
                tv_item_icon.setImageResource(R.mipmap.ic_imagejoke_unselect);
                break;
            case 3:
                tv_item_icon.setImageResource(R.mipmap.ic_dt_unselect);
                break;
            case 4:
                tv_item_icon.setImageResource(R.mipmap.ic_my_unselect);
                break;
        }
    }
}
