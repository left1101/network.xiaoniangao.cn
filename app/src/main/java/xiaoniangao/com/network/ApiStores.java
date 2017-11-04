package xiaoniangao.com.network;

import java.util.Map;

import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface ApiStores {

    String API_SERVER_URL = "https://api.xiaoniangao.cn";

    @POST("/album/featured")
    Observable<Result<Object>> getFeature(@QueryMap Map<String, String> map);

    @POST("/album/list")
    Observable<Result<Object>> getAlbumList(@QueryMap Map<String, Object> map);
}
