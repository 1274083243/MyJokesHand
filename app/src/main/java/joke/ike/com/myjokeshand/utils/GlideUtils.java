package joke.ike.com.myjokeshand.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import joke.ike.com.myjokeshand.JokeApplication;
import joke.ike.com.myjokeshand.R;

/**
作者：ike
时间：2017/1/23 10:39
功能描述：GlideUtilst图片加载工具类
**/

public class GlideUtils {
    public static void loadPic(String url, ImageView img){
        Glide.with(img.getContext())
                .load(url)
                .placeholder(R.mipmap.error_place)
                .into(img);
    }
}
