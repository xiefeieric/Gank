package uk.me.feixie.gank.today;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;
import com.marshalchen.ultimaterecyclerview.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.realm.Realm;
import timber.log.Timber;
import uk.me.feixie.gank.R;
import uk.me.feixie.gank.data.local.ModelArticleRealm;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodayFragment extends Fragment implements TodayContract.View {


    @BindView(R.id.rvToday)
    UltimateRecyclerView mRvToday;
    @BindView(R.id.pbTodayLoading)
    ProgressBar mPbTodayLoading;

    private TodayContract.Presenter mPresenter;
    private Realm mRealm;
    private Unbinder mBind;
    private TodayAdapter mAdapter;
    private ImageView mIvParallaxHeader;

    public TodayFragment() {
        // Required empty public constructor
    }

    public static TodayFragment newInstance() {
        return new TodayFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRealm = Realm.getDefaultInstance();
//        mPresenter.loadArticles(mRealm);
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
        int size = mRealm.where(ModelArticleRealm.class).findAll().size();
        Timber.d("data size: %d", size);
        View view = inflater.inflate(R.layout.fragment_today, container, false);
        mBind = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        mIvParallaxHeader = (ImageView) getActivity().findViewById(R.id.ivParallaxHeader);
        mRvToday.setHasFixedSize(false);
        mRvToday.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvToday.setEmptyView(R.layout.view_empty, 0);
        mPresenter.initArticalsLocal(mRealm);
        StickyRecyclerHeadersDecoration header = new StickyRecyclerHeadersDecoration(mAdapter);
        mRvToday.addItemDecoration(header);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBind.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (active) {
            mPbTodayLoading.setVisibility(View.VISIBLE);
        } else {
            mPbTodayLoading.setVisibility(View.GONE);
        }
    }

    @Override
    public void showArticles(List<ModelArticleRealm> articles) {
        if (mAdapter == null) {
            mAdapter = new TodayAdapter(articles);
            mRvToday.setAdapter(mAdapter);
        } else {
            mAdapter.updateData(articles);
        }
    }

    @Override
    public void showHeaderImage(String path) {
        Glide.with(this).load(path).into(mIvParallaxHeader);
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
