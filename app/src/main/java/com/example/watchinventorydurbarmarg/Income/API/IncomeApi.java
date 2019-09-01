package com.example.watchinventorydurbarmarg.Income.API;

import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.watchinventorydurbarmarg.Utilities.GlobalContext;

public class IncomeApi {


    public void apiCall(String date, String expense, Double amount, String payment_mode) {
        String url = "http://192.168.125.196:45457/api/saveexpenditure?date=" + date + "&particular=" + expense + "&amount=" + amount +
                "&paymentmode=" + payment_mode+"&mainhead="+"a";


        Log.e("URL:" ,url);
        Log.e("URL:" ,url);


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(GlobalContext.getAppContext(), response.toString(), Toast.LENGTH_SHORT).show();


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
