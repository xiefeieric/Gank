package uk.me.feixie.gank.today;

import android.support.annotation.NonNull;

import rx.subscriptions.CompositeSubscription;
import uk.me.feixie.gank.data.ModelArticle;

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

    }

    @Override
    public void loadArticalDetails(@NonNull ModelArticle article) {

    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
