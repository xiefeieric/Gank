package uk.me.feixie.gank.artical_detail;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.me.feixie.gank.R;
import uk.me.feixie.gank.Utils.Constants;

public class DetailViewActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        DetailViewFragment fragment = (DetailViewFragment) getSupportFragmentManager().findFragmentByTag(Constants.FRAGMENT_DETAIL_VIEW);
        if (fragment == null) {
            fragment = DetailViewFragment.newInstance();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.content_detail_view, fragment, Constants.FRAGMENT_DETAIL_VIEW).commit();
        DetailViewPresenter presenter = new DetailViewPresenter(fragment);
    }

}
