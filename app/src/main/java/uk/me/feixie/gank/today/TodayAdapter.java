package uk.me.feixie.gank.today;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter;

import java.util.List;

import uk.me.feixie.gank.R;
import uk.me.feixie.gank.artical_detail.DetailViewActivity;
import uk.me.feixie.gank.data.local.ModelArticleRealm;

/**
 * Created by Fei on 22/11/2016.
 */

public class TodayAdapter extends UltimateViewAdapter {

    public static final String ARTICAL_URL = "artical_url";
    private List<ModelArticleRealm> mArticles;
    private SparseArray<String> mHeadCharTable;
    private Context mContext;

    public TodayAdapter(Context context, List<ModelArticleRealm> articles) {
        mArticles = articles;
        mHeadCharTable = new SparseArray<>();
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder newFooterHolder(View view) {
        return null;
    }

    @Override
    public RecyclerView.ViewHolder newHeaderHolder(View view) {
        return null;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = View.inflate(parent.getContext(), R.layout.view_today_rv_item, null);
        return new TodayViewHolder(view);
    }

    @Override
    public int getAdapterItemCount() {
        return mArticles.size();
    }

    @Override
    public long generateHeaderId(int position) {
        ModelArticleRealm article = mArticles.get(position);
        if (article.type.equalsIgnoreCase("Android")) {
            mHeadCharTable.put(position, "Android");
            return 0;
        }
        if (article.type.equalsIgnoreCase("iOS")) {
            mHeadCharTable.put(position, "iOS");
            return 1;
        }
        if (article.type.equalsIgnoreCase("休息视频")) {
            mHeadCharTable.put(position, "休息视频");
            return 2;
        }
        if (article.type.equalsIgnoreCase("福利")) {
            mHeadCharTable.put(position, "福利");
            return 3;
        }
        if (article.type.equalsIgnoreCase("拓展资源")) {
            mHeadCharTable.put(position, "拓展资源");
            return 4;
        }
        return -1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TodayViewHolder) holder).mTvArticleTitle.setText(mArticles.get(position).desc);
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = View.inflate(parent.getContext(), R.layout.view_today_stick_head_item, null);
        return new HeadViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((HeadViewHolder) holder).mTvTodayStickyHead.setText(mHeadCharTable.get(position));
    }

    public void setArticles(List<ModelArticleRealm> articles) {
        mArticles = articles;
    }

    public void updateData(List<ModelArticleRealm> mArticles) {
        setArticles(mArticles);
        notifyDataSetChanged();
    }

    public class TodayViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mTvArticleTitle;
        public CardView mCvArticle;

        public TodayViewHolder(View itemView) {
            super(itemView);
            mTvArticleTitle = (TextView) itemView.findViewById(R.id.tvArticleTitle);
            mCvArticle = (CardView) itemView.findViewById(R.id.cvArticle);

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 5, 0, 5);
            mCvArticle.setLayoutParams(params);
            mCvArticle.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            Timber.d("click %d", getAdapterPosition());
            Intent i = new Intent(mContext, DetailViewActivity.class);
            i.putExtra(ARTICAL_URL, mArticles.get(getAdapterPosition()).url);
            mContext.startActivity(i);
        }
    }

    public class HeadViewHolder extends RecyclerView.ViewHolder {

        public TextView mTvTodayStickyHead;

        public HeadViewHolder(View itemView) {
            super(itemView);
            mTvTodayStickyHead = (TextView) itemView.findViewById(R.id.tvTodayStickyHead);
        }
    }
}
