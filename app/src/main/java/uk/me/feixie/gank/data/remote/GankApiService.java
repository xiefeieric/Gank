package uk.me.feixie.gank.data.remote;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import uk.me.feixie.gank.Utils.Constants;

/**
 * Created by Fei on 17/11/2016.
 */

public class GankApiService {

    private static ApiService mApiService;

    public static void resetApi() {
        mApiService = null;
    }

    public static ApiService getApiInstance() {

        if (mApiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            mApiService = retrofit.create(GankApiService.ApiService.class);
        }

        return mApiService;
    }

    public interface ApiService {

        @GET("day/{date}")
        Observable<ModelToday> getTodayArticals(@Path("date") String date);

    }
}
