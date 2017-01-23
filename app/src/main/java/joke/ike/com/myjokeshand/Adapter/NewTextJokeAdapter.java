package joke.ike.com.myjokeshand.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import joke.ike.com.myjokeshand.R;
import joke.ike.com.myjokeshand.model.dataModel.NewTextJokeModel;
import joke.ike.com.myjokeshand.utils.recycleViewUtils.ViewHolder;

/**
作者：ike
时间：2017/1/22 14:31
功能描述：最热笑话数据适配器
**/

public class NewTextJokeAdapter extends RecyclerView.Adapter{
    private List<NewTextJokeModel> models;

    public NewTextJokeAdapter(List<NewTextJokeModel> models) {
        this.models = models;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=View.inflate(parent.getContext(), R.layout.new_text_joke_item,null);
        ViewHolder holder=new ViewHolder(parent.getContext(),itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder mHolder= (ViewHolder) holder;
        NewTextJokeModel model=models.get(position);
        ((TextView)mHolder.getView(R.id.tv_content)).setText(model.getContent());
        ((TextView)mHolder.getView(R.id.tv_time)).setText(model.getUnixtime());

    }

    @Override
    public int getItemCount() {
        if (models!=null&&models.size()>0){
            return models.size();
        }
        return 0;
    }
}
