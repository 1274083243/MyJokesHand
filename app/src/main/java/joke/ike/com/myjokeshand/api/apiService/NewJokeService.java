package joke.ike.com.myjokeshand.api.apiService;

import joke.ike.com.myjokeshand.model.RequestParam;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
作者：ike
时间：2017/1/18 17:24
功能描述：首页笑话推荐api
**/

public interface NewJokeService {
    @GET("randJoke.php")
    Observable<String> getTextJoke(@QueryMap RequestParam param);
}
