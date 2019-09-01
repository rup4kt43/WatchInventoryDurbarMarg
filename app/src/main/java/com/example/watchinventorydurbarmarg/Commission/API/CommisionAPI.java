package com.example.watchinventorydurbarmarg.Commission.API;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.watchinventorydurbarmarg.Commission.POJO.LoadResponse;
import com.example.watchinventorydurbarmarg.Utilities.GlobalContext;
import com.google.gson.Gson;

public class CommisionAPI {
    public void loadDetails(String barcode) {

        String url = "http://192.168.125.188:45455/api/loadDetails?bcode=" + barcode;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                LoadResponse loadResponse = new Gson().fromJson(response, LoadResponse.class);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            //throw error here
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(GlobalContext.getAppContext());
        requestQueue.add(stringRequest);
    }
}
