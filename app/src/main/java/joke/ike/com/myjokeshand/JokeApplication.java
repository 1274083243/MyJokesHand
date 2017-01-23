package joke.ike.com.myjokeshand;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
作者：ike
时间：2017/1/20 10:13
功能描述：JokeApp的application应用类
**/

public class JokeApplication extends Application{
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }
}
