package joke.ike.com.myjokeshand.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import joke.ike.com.myjokeshand.utils.recycleViewUtils.ViewHolder;

/**
 * Created by Administrator on 2017/1/16.
 */

public class commonTestAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView view=new TextView(parent.getContext());
        ViewHolder holder = ViewHolder.createViewHolder(parent.getContext(), view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        ((TextView)holder1.itemView).setText("我是内容:"+position);

    }

    @Override
    public int getItemCount() {
        return 50;
    }
}
