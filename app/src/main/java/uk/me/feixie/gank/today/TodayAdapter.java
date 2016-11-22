package uk.me.feixie.gank.today;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
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

    public TodayAdapter(List<ModelArticleRealm> articles) {
        mArticles = articles;
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
        return 0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TodayViewHolder)holder).mTvArticleTitle.setText(mArticles.get(position).desc);
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        return null;
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    public class TodayViewHolder extends RecyclerView.ViewHolder {

        public TextView mTvArticleTitle;

        public TodayViewHolder(View itemView) {
            super(itemView);
            mTvArticleTitle = (TextView) itemView.findViewById(R.id.tvArticleTitle);
        }
    }
}
