package uk.me.feixie.gank.today;

import android.support.annotation.NonNull;

import org.joda.time.DateTime;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
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
    public void initArticalsLocal(Realm realm) {
//        2016-11-23
        RealmResults<ModelArticleRealm> todayArticles = realm.where(ModelArticleRealm.class).beginsWith("publishedAt", DateUtils.formatDate("yyyy-MM-dd", new DateTime())).notEqualTo("type","福利").findAllSorted("type");
        if (todayArticles.size()==0) {
            loadArticles(realm);
        }
        ModelArticleRealm article = realm.where(ModelArticleRealm.class)
                .equalTo("type","福利").findAllSorted("publishedAt", Sort.DESCENDING)
                .first();
        mView.showHeaderImage(article.url);
//        Timber.d("all articles: %d", allArticles.size());
        mView.showArticles(todayArticles);
    }

    @Override
    public void loadArticles(final Realm realm) {
        mView.setLoadingIndicator(true);
        String date = DateUtils.formatDate("yyyy/MM/dd", new DateTime());
        Timber.d(date);
        Subscription subscription = GankApiService.getApiInstance().getTodayArticals(date)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ModelToday>() {
                    @Override
                    public void onCompleted() {
                        Timber.d("onCompleted");
                        RealmResults<ModelArticleRealm> allArticles = realm.where(ModelArticleRealm.class).beginsWith("publishedAt", DateUtils.formatDate("yyyy-MM-dd", new DateTime())).findAllSorted("type");
                        mView.showArticles(allArticles);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.d(e.toString());
                        mView.setLoadingIndicator(false);
                    }

                    @Override
                    public void onNext(ModelToday modelToday) {
                        Timber.d("android size: %d", modelToday.results.Android.size());
                        for (ModelToday.ResultsBean.AndroidBean androidBean : modelToday.results.Android) {
                            androidBean.toRealmItemAndroid(androidBean, realm);
                        }
                        for (ModelToday.ResultsBean.IOSBean iosBean : modelToday.results.iOS) {
                            iosBean.toRealmItemIos(iosBean, realm);
                        }
                        for (ModelToday.ResultsBean.休息视频Bean leisure : modelToday.results.休息视频) {
                            leisure.toRealmItemLeisure(leisure, realm);
                        }
                        for (ModelToday.ResultsBean.福利Bean gift : modelToday.results.福利) {
                            gift.toRealmItemGift(gift, realm);
                        }
                        if (modelToday.results.拓展资源!=null) {
                            for (ModelToday.ResultsBean.拓展资源Bean source : modelToday.results.拓展资源) {
                                source.toRealmItemSource(source, realm);
                            }
                        }
                        RealmResults<ModelArticleRealm> allArticles = realm.where(ModelArticleRealm.class)
                                .beginsWith("publishedAt", DateUtils.formatDate("yyyy-MM-dd", new DateTime()))
                                .notEqualTo("type","福利").findAllSorted("type");

                        mView.showArticles(allArticles);

                        ModelArticleRealm article = realm.where(ModelArticleRealm.class)
                                .equalTo("type","福利").findAllSorted("publishedAt", Sort.DESCENDING)
                                .first();

                        Timber.d("url: %s", article.url);

                        mView.showHeaderImage(article.url);

                        Timber.d("all articles: %d", allArticles.size());
                        mView.setLoadingIndicator(false);
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
        mView = null;
    }
}
