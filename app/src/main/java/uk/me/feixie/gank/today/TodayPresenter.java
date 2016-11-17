package uk.me.feixie.gank.today;

import android.support.annotation.NonNull;

import org.joda.time.DateTime;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;
import uk.me.feixie.gank.Utils.DateUtils;
import uk.me.feixie.gank.data.local.ModelArticleRealm;
import uk.me.feixie.gank.data.remote.GankApiService;
import uk.me.feixie.gank.data.remote.ModelToday;

/**
 * Created by Fei on 16/11/2016.
 */

public class TodayPresenter implements TodayContract.Presenter {

    private TodayContract.View mView;
    private CompositeSubscription mSubscription;

    public TodayPresenter(TodayContract.View view) {
        mView = view;
        mSubscription = new CompositeSubscription();
        mView.setPresenter(this);
    }

    @Override
    public void loadArticles() {
        String date = DateUtils.formatDate("yyyy/MM/dd", new DateTime());
        Timber.d(date);
        Subscription subscription = GankApiService.getApiInstance().getTodayArticals(date)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ModelToday>() {
                    @Override
                    public void onCompleted() {
                        Timber.d("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.d(e.toString());
                    }

                    @Override
                    public void onNext(ModelToday modelToday) {
                        Timber.d("android size: %d", modelToday.results.Android.size());
                    }
                });
        mSubscription.add(subscription);
    }

    @Override
    public void loadArticalDetails(@NonNull ModelArticleRealm article) {

    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        mSubscription.clear();
        mSubscription.unsubscribe();
    }
}
