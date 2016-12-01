package uk.me.feixie.gank.today;

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
import uk.me.feixie.gank.data.local.ModelArticleRealm;

/**
 * Created by Fei on 22/11/2016.
 */

public class TodayAdapter extends UltimateViewAdapter {

    private List<ModelArticleRealm> mArticles;
    private SparseArray<String> mHeadCharTable;

    public TodayAdapter(List<ModelArticleRealm> articles) {
        mArticles = articles;
        mHeadCharTable = new SparseArray<>();
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
//        if (position < getItemCount() && (customHeaderView != null ? position <= mArticles.size() : position < mArticles.size()) && (customHeaderView == null || position > 0)) {
            ((TodayViewHolder) holder).mTvArticleTitle.setText(mArticles.get(position).desc);
//        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = View.inflate(parent.getContext(), R.layout.view_today_stick_head_item, null);
        return new HeadViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((HeadViewHolder)holder).mTvTodayStickyHead.setText(mHeadCharTable.get(position));
    }

    public void setArticles(List<ModelArticleRealm> articles) {
        mArticles = articles;
    }

    public void updateData(List<ModelArticleRealm> mArticles) {
        setArticles(mArticles);
        notifyDataSetChanged();
    }

    public class TodayViewHolder extends RecyclerView.ViewHolder {

        public TextView mTvArticleTitle;
        public CardView mCvArticle;

        public TodayViewHolder(View itemView) {
            super(itemView);
            mTvArticleTitle = (TextView) itemView.findViewById(R.id.tvArticleTitle);
            mCvArticle = (CardView) itemView.findViewById(R.id.cvArticle);

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 5, 0, 5);
            mCvArticle.setLayoutParams(params);
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
