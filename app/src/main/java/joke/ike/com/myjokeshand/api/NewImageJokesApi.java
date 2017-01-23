package joke.ike.com.myjokeshand.api;

import joke.ike.com.myjokeshand.api.apiService.NewJokeImageService;
import joke.ike.com.myjokeshand.model.RequestParam;
import joke.ike.com.myjokeshand.utils.httpUtils.BaseApi;
import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by Administrator on 2017/1/23.
 */

public class NewImageJokesApi extends BaseApi {

    public NewImageJokesApi(RequestParam requestParam) {
        super(requestParam);
    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        NewJokeImageService newJokeImageService = retrofit.create(NewJokeImageService.class);

        return newJokeImageService.getImageJoke(requestParam);
    }
}
