package com.example.anhtt.leangson.volley;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by anhtt on 09/08/2015.
 */
public class VolleyHelper {
    private static VolleyHelper Instance;
    private Context mContext;
    private RequestQueue mRequestQueue;

    public VolleyHelper(Context context) {
        this.mContext = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized VolleyHelper getInstance(Context context) {
        if (Instance == null) {
            Instance = new VolleyHelper(context);
        }
        return Instance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request) {
        getRequestQueue().add(request);
    }
}
