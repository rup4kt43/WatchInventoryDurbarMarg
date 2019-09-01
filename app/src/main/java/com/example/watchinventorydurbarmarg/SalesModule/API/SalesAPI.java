 package com.example.watchinventorydurbarmarg.SalesModule.API;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.watchinventorydurbarmarg.SalesModule.Contracts.SalesContracts;
import com.example.watchinventorydurbarmarg.SalesModule.POJO.BarcodeResponse;
import com.example.watchinventorydurbarmarg.Utilities.GlobalContext;
import com.example.watchinventorydurbarmarg.Utilities.LoginIPaddress;
import com.google.gson.Gson;

public class SalesAPI {

    public void loadDetails(String barcode, final SalesContracts.modelApiCallback callback) {
        // String url = "http://" + LoginIPaddress.ipAddress + "/api/loadDetails?barcode=" + barcode;
        String url = "http://"+ LoginIPaddress.ipAddress +"/api/loadDetails?bcode=" + barcode;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                BarcodeResponse barcodeResponse = new Gson().fromJson(response, BarcodeResponse.class);
                callback.onSuccessResponse(barcodeResponse);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.e("Error Response", String.valueOf(error));
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(GlobalContext.getAppContext());
        requestQueue.add(stringRequest);


    }
}
