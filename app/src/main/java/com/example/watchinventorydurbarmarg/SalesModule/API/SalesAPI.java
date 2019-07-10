package com.example.watchinventorydurbarmarg.SalesModule.API;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.watchinventorydurbarmarg.SalesModule.DTO.SalesResponse;
import com.example.watchinventorydurbarmarg.Utilities.GlobalContext;
import com.google.gson.Gson;

public class SalesAPI {

    public void loadDetails(String barcode) {
        // String url = "http://" + LoginIPaddress.ipAddress + "/api/loadDetails?barcode=" + barcode;
        String url = "http://192.168.125.150:45455/api/loadDetails?bcode=" + barcode;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Response", response);
                SalesResponse salesDTO = new Gson().fromJson(response, SalesResponse.class);
                Log.e("Model", salesDTO.getResult().getValue().getMODEL());
                Log.e("MRP", String.valueOf(salesDTO.getResult().getValue().getRATEA()));
                Log.e("CostPrice", String.valueOf(salesDTO.getResult().getValue().getPRATEA()));
                Log.e("PurchaseDate ", String.valueOf(salesDTO.getResult().getValue().getPURCHASEDATE()));
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
