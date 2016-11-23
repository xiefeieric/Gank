package uk.me.feixie.gank.today;

import android.support.annotation.NonNull;

import java.util.List;

import io.realm.Realm;
import uk.me.feixie.gank.data.local.ModelArticleRealm;
import uk.me.feixie.gank.framework.BasePresenter;
import uk.me.feixie.gank.framework.BaseView;

/**
 * Created by Fei on 16/11/2016.
 */

public interface TodayContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showArticles(List<ModelArticleRealm> articles);

        void showArticleDetailUi(@NonNull String articleId);

        void showNoArticles();

        boolean isActive();

    }

    interface Presenter extends BasePresenter {

        void initArticalsLocal(Realm realm);

        void loadArticles(Realm realm);

        void loadArticalDetails(@NonNull ModelArticleRealm article);

        void result(int requestCode, int resultCode);
    }
}
