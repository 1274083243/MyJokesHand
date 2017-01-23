package joke.ike.com.myjokeshand.api;

import com.orhanobut.logger.Logger;

import joke.ike.com.myjokeshand.api.apiService.NewJokeService;
import joke.ike.com.myjokeshand.model.RequestParam;
import joke.ike.com.myjokeshand.utils.httpUtils.BaseApi;
import retrofit2.Retrofit;
import rx.Observable;

/**
作者：ike
时间：2017/1/12 17:32
功能描述：段子接口的Api
**/

public class NewJokesApi extends BaseApi{


    public NewJokesApi(RequestParam requestParam) {
        super(requestParam);
    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        NewJokeService newJokeService = retrofit.create(NewJokeService.class);
        Observable<String> observable = newJokeService.getTextJoke(requestParam);
        return observable;
    }
}
