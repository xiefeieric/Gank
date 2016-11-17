package uk.me.feixie.gank.data.remote;

import android.database.Observable;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Fei on 17/11/2016.
 */

public interface GankApi {

    @GET("day/{date}")
    Observable<ModelToday> getTodayArticals(@Path("date") String date);
}
