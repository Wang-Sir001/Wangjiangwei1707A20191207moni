package com.bawei.wangjiangwei.com.model;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.wangjiangwei.com.api.Api;
import com.bawei.wangjiangwei.com.app.App;
import com.bawei.wangjiangwei.com.contract.IHomeContract;
import com.bawei.wangjiangwei.com.model.entity.HomeEntity;
import com.google.gson.Gson;

public class HomeModel implements IHomeContract.IModel {
    @Override
    public void getHome(final ModelCallback modelCallback) {
        RequestQueue requestQueue = Volley.newRequestQueue(App.getContext());

        StringRequest stringRequest = new StringRequest(Api.HOME_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                HomeEntity homeEntity = new Gson().fromJson(response, HomeEntity.class);
                modelCallback.success(homeEntity);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }
}
