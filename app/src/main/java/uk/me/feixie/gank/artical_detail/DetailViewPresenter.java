package uk.me.feixie.gank.artical_detail;

/**
 * Created by Fei on 07/12/2016.
 */

public class DetailViewPresenter implements DetailViewContract.Presenter {

    private DetailViewContract.View mView;

    public DetailViewPresenter(DetailViewContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void dealArtical(String url) {

    }
}
