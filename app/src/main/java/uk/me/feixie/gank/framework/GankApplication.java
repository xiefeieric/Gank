package uk.me.feixie.gank.framework;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;
import uk.me.feixie.gank.BuildConfig;

/**
 * Created by Fei on 15/11/2016.
 */

public class GankApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
