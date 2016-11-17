package uk.me.feixie.gank.today;

import android.support.annotation.NonNull;

import java.util.List;

import uk.me.feixie.gank.data.ModelArticle;
import uk.me.feixie.gank.framework.BasePresenter;
import uk.me.feixie.gank.framework.BaseView;

/**
 * Created by Fei on 16/11/2016.
 */

public interface TodayContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showArticles(List<ModelArticle> articles);

        void showArticleDetailUi(@NonNull String articleId);

        void showNoArticles();

        boolean isActive();

    }

    interface Presenter extends BasePresenter {

        void loadArticles();

        void loadArticalDetails(@NonNull ModelArticle article);

        void result(int requestCode, int resultCode);
    }
}
