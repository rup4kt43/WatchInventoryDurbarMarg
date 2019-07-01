package com.example.watchinventorydurbarmarg.UserLogin.API;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.watchinventorydurbarmarg.Utilities.GlobalContext;

import java.util.HashMap;
import java.util.Map;

public class UserLoginAPI {
    public void validateWithAPI(final String uname, final String password) {


        String url = "";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //TODO SOMETHING ON SUCCESS RESPONSE -> CALLBACK
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json";
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Username", uname);
                params.put("Password", password);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(GlobalContext.getAppContext());
        requestQueue.add(stringRequest);
    }
}
