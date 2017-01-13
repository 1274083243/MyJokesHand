package joke.ike.com.myjokeshand.utils;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
作者：ike
时间：2017/1/12 16:33
功能描述：retrofit辅助工具类，用于初始化Retrofit相关数据
**/

public class RetrofitUtils {
    public static volatile RetrofitUtils instance;
    private OkHttpClient client;
    //基础配置信息
     /*超时时间-默认6秒*/
    private int defaultTime = 10;
    private RetrofitUtils(){
        initRetrofit();
    }
    /**
     * 构造单例
     * @return
     */
    public static RetrofitUtils getInstance(){
        if (instance==null){
            synchronized (RetrofitUtils.class){
                if (instance==null){
                    instance=new RetrofitUtils();
                }
            }
        }
        return instance;
    }
    /**
     * 初始化Retrofit
     */
    private void initRetrofit(){
        client=new OkHttpClient.Builder()
                .writeTimeout(defaultTime, TimeUnit.SECONDS)
                .readTimeout(defaultTime,TimeUnit.SECONDS)
                .connectTimeout(defaultTime,TimeUnit.SECONDS)
                .build();

    }
    /**
     * 创建api接口
     *
     * @param serviceClass
     * @param <S>
     * @return
     */
    public <S> S createService(Class<S> serviceClass) {
//        String baseUrl = "";
//        try {
//            Field field1 = serviceClass.getField("BASE_URL");
//            baseUrl = (String) field1.get(serviceClass);
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.getMessage();
//            e.printStackTrace();
//        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantUtils.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }

}
