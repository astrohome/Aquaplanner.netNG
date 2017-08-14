package com.galaxysoft.aquaplannernetng.net.requests.base;

import com.android.volley.RequestQueue;
import com.android.volley.Response;

/**
 * Created by astrohome on 7/29/17.
 */

public abstract class BaseImpl<T> implements Base<T> {
    protected RequestQueue queue;
    private final Response.Listener<T> mListener;

    public BaseImpl(RequestQueue queue, Response.Listener<T> listener) {
        this.queue = queue;
        this.mListener = listener;
    }
}
