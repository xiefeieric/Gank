package uk.me.feixie.gank.today;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import uk.me.feixie.gank.R;
import uk.me.feixie.gank.data.ModelArticle;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodayFragment extends Fragment implements TodayContract.View {


    private TodayContract.Presenter mPresenter;

    public TodayFragment() {
        // Required empty public constructor
    }

    public static TodayFragment newInstance() {
        return new TodayFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_today, container, false);
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showArticles(List<ModelArticle> articles) {

    }

    @Override
    public void showArticleDetailUi(@NonNull String articleId) {

    }

    @Override
    public void showNoArticles() {

    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void setPresenter(@NonNull TodayContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
