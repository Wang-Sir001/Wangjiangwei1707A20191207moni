package com.bawei.wangjiangwei.com.utils;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.wangjiangwei.com.api.Api;
import com.bawei.wangjiangwei.com.app.App;

import java.util.Map;

public class VolleyUtils {
    private RequestQueue requestQueue;

    private static VolleyUtils volleyUtils;

    private VolleyUtils() {

        requestQueue = Volley.newRequestQueue(App.getContext());

    }

    public static VolleyUtils getInstance() {
        if (volleyUtils == null){
            synchronized (volleyUtils){
                if (volleyUtils == null){
                    volleyUtils = new VolleyUtils();
                }
            }
        }
        return volleyUtils;
    }

    public void doGet(String url, final VolleyCallback volleyCallback){
        StringRequest stringRequest = new StringRequest(StringRequest.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (volleyCallback != null){
                    volleyCallback.success(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (volleyCallback != null){
                    volleyCallback.failure(error);
                }
            }
        });
        requestQueue.add(stringRequest);
    }

    public void getPost(final Map<String,String> params, String url, final VolleyCallback volleyCallback){
        StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (volleyCallback != null){
                    volleyCallback.success(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (volleyCallback != null){
                    volleyCallback.failure(error);
                }
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    public interface VolleyCallback{
        void success(String response);

        void failure(Throwable throwable);
    }
}
