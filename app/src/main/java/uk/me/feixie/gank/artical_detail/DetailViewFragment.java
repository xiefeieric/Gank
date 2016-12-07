package uk.me.feixie.gank.artical_detail;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import uk.me.feixie.gank.R;
import uk.me.feixie.gank.today.TodayAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailViewFragment extends Fragment implements DetailViewContract.View {

    @BindView(R.id.wvArticleDetail)
    WebView mWvArticleDetail;
    @BindView(R.id.pbLoading)
    ProgressBar mPbLoading;
    private DetailViewPresenter mPresenter;
    private String mUrl;
    private Unbinder mBind;


    public DetailViewFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }

    public static DetailViewFragment newInstance() {
        return new DetailViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_view, container, false);
        mBind = ButterKnife.bind(this, view);
        mUrl = getActivity().getIntent().getStringExtra(TodayAdapter.ARTICAL_URL);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        showArtical(mUrl);
    }

    @Override
    public void onStop() {
        super.onStop();
        mWvArticleDetail.destroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBind.unbind();
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (active) {
            mPbLoading.setVisibility(View.VISIBLE);
        } else {
            mPbLoading.setVisibility(View.GONE);
        }
    }

    @Override
    public void showArtical(String url) {
        setLoadingIndicator(true);
        WebChromeClient client = new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                ActionBar supportActionBar = ((DetailViewActivity) (getActivity())).getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.setTitle(title);
                }
                setLoadingIndicator(false);
            }
        };
        mWvArticleDetail.setWebChromeClient(client);
        WebViewClient viewClient = new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.loadUrl(request.getUrl().toString());
                }
                return true;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        };
        mWvArticleDetail.setWebViewClient(viewClient);
        mWvArticleDetail.getSettings().setJavaScriptEnabled(true);
        mWvArticleDetail.loadUrl(url);
    }

    @Override
    public void setPresenter(DetailViewPresenter presenter) {
        mPresenter = presenter;
    }
}
