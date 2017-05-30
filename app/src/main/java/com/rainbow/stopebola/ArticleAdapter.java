package com.rainbow.stopebola;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by sugar on 5/27/2017.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    List<Post> mPostList;
    private Activity mActivity;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView title;
        public TextView date;

        public ViewHolder(View view){
            super(view);
            image = (ImageView) view.findViewById(R.id.image);
            title = (TextView) view.findViewById(R.id.title);
            date = (TextView) view.findViewById(R.id.date);
        }
    }

    public ArticleAdapter(List<Post> postList, Activity activity ){
        this.mPostList = postList;
        this.mActivity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View postView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_item, parent, false);

        return new ViewHolder(postView);
    }

    public void addArticles(List<Post> articles) {
        mPostList.addAll(articles);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Post post = mPostList.get(position);
        holder.title.setText(post.getTitle());
        holder.date.setText(post.getDate());
        Picasso.with(mActivity).load(post.getThumbnail()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }
}
