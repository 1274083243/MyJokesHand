package joke.ike.com.myjokeshand.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import joke.ike.com.myjokeshand.R;
import joke.ike.com.myjokeshand.model.dataModel.NewImageJokeModel;
import joke.ike.com.myjokeshand.model.dataModel.NewTextJokeModel;
import joke.ike.com.myjokeshand.utils.GlideUtils;
import joke.ike.com.myjokeshand.utils.recycleViewUtils.ViewHolder;

/**
作者：ike
时间：2017/1/22 14:31
功能描述：最热图文笑话数据适配器
**/

public class NewImageJokeAdapter extends RecyclerView.Adapter{
    private List<NewImageJokeModel> models;

    public NewImageJokeAdapter(List<NewImageJokeModel> models) {
        this.models = models;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=View.inflate(parent.getContext(), R.layout.new_image_joke_item,null);
        ViewHolder holder=new ViewHolder(parent.getContext(),itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder mHolder= (ViewHolder) holder;
        NewImageJokeModel JokeModel =models.get(position);
        ((TextView)mHolder.getView(R.id.tv_title)).setText(JokeModel.getContent());
        ((TextView)mHolder.getView(R.id.tv_time)).setText(JokeModel.getUnixtime());
        GlideUtils.loadPic(JokeModel.getUrl(),(ImageView)(mHolder.getView(R.id.iv_joke)));

    }

    @Override
    public int getItemCount() {
        if (models!=null&&models.size()>0){
            return models.size();
        }
        return 0;
    }
}
