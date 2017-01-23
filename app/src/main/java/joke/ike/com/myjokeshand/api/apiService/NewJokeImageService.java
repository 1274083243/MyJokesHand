package joke.ike.com.myjokeshand.api.apiService;

import joke.ike.com.myjokeshand.model.RequestParam;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
作者：ike
时间：2017/1/23 9:55
功能描述：推荐新的图文笑话
**/

public interface NewJokeImageService {
    @GET("randJoke.php")
    Observable<String> getImageJoke(@QueryMap RequestParam param);
}
