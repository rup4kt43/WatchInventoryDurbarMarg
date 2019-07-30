package com.example.watchinventorydurbarmarg.UserLogin.API;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.watchinventorydurbarmarg.UserLogin.Contracts.UserLoginContracts;
import com.example.watchinventorydurbarmarg.UserLogin.POJO.LoginResponse;
import com.example.watchinventorydurbarmarg.Utilities.GlobalContext;
import com.example.watchinventorydurbarmarg.Utilities.LoginIPaddress;
import com.google.gson.Gson;

public class UserLoginAPI {
    public void validateWithAPI(final String uname, final String password, final UserLoginContracts.modelAPICallBack callBack) {


        //  Log.e("PASS", password);

        String url = "http://" + LoginIPaddress.ipAddress + "/api/login?username=" + uname + "&password=" + password;
        Log.e("URL MSG",url);


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                LoginResponse loginResponse = new Gson().fromJson(response, LoginResponse.class);
                String role = String.valueOf(loginResponse.getValue().get(0).getROLE());
                callBack.onSuccessResponse(role);

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


