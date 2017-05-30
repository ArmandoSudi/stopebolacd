package com.rainbow.stopebola;

import android.os.AsyncTask;
import android.util.Log;

import com.goebl.david.Webb;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sugar on 5/28/2017.
 */

public class ArticleAsyncTask extends AsyncTask<List<Post>, Integer, JSONArray> {
    private String LOG_TAG = ArticleAsyncTask.class.getSimpleName();
    private List<Post> mPostList = new ArrayList<Post>();
    private ArticleAdapter mArticleAdpapter;

    public ArticleAsyncTask(List<Post> postList, ArticleAdapter adapter) {
        super();

        this.mPostList = postList;
        this.mArticleAdpapter = adapter;
    }

    @Override
    protected void onPostExecute(JSONArray posts) {
        super.onPostExecute(posts);

        int postCount = posts.length();

        try {

            for( int i=0; i < postCount; i++) {
                JSONObject postJSON = posts.getJSONObject(i);

                Post post = new Post(postJSON.getInt("id"),
                        postJSON.getString("status"),
                        postJSON.getString("title"),
                        postJSON.getString("date"),
                        postJSON.getString("thumbnail"));

                mPostList.add(post);

                Log.e(LOG_TAG, postJSON.getString("title"));
            }

        } catch( JSONException e) {
            e.printStackTrace();
        }

        mArticleAdpapter.addArticles(mPostList);
        mArticleAdpapter.notifyDataSetChanged();

    }

    @Override
    protected JSONArray doInBackground(List<Post>... postList) {
        // create the client (one-time, can be used from different threads)
        Webb webb = Webb.create();
        JSONObject result = webb.get("http://stopebola.org/?json=get_recent_posts").asJsonObject().getBody();
        JSONArray articles = null;

        try {
            articles = result.getJSONArray("posts");
        } catch( JSONException e) {
            e.printStackTrace();
        }

        return articles;
    }

    private String getMediumImage(JSONObject post) {
        JSONObject thumbnail;
        JSONObject full_image = null;
        String url = null;
        try {
            thumbnail = post.getJSONObject("thumbnail_images");
            full_image = thumbnail.getJSONObject("full");
            url = full_image.getString("url");
        } catch(JSONException e) {
            e.printStackTrace();
        }

        return url;

    }

}