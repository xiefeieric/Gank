package uk.me.feixie.gank.artical_detail;

import uk.me.feixie.gank.framework.BasePresenter;
import uk.me.feixie.gank.framework.BaseView;

/**
 * Created by Fei on 07/12/2016.
 */

public interface DetailViewContract {

    interface View extends BaseView<DetailViewPresenter> {

        void setLoadingIndicator(boolean active);

        void showArtical(String url);
    }

    interface Presenter extends BasePresenter {

        void dealArtical(String url);
    }

}
