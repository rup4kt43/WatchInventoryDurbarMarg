package com.example.watchinventorydurbarmarg.UserSettings.API;


import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.watchinventorydurbarmarg.UserLogin.Presenter.UserLoginPresenter;
import com.example.watchinventorydurbarmarg.UserSettings.Contracts.UserSettingsContracts;
import com.example.watchinventorydurbarmarg.UserSettings.POJO.ChangePasswordPOJO.ChangePasswordResponse;
import com.example.watchinventorydurbarmarg.UserSettings.POJO.UserListPOJO.UserListResponse;
import com.example.watchinventorydurbarmarg.Utilities.GlobalContext;
import com.example.watchinventorydurbarmarg.Utilities.LoginIPaddress;
import com.google.gson.Gson;

public class UserSettingsAPI {
    UserListResponse userListResponse;

    private UserSettingsContracts.modelApiCallback callback;

    public void loadUserData(final UserSettingsContracts.modelApiCallback modelApiCallback) {
        this.callback = modelApiCallback;
        String url = "http://" + LoginIPaddress.ipAddress + "/api/userrequest?username=" + UserLoginPresenter.uName;
        try {

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    userListResponse = new Gson().fromJson(response, UserListResponse.class);
                    callback.apiResponse(userListResponse);


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                    callback.onErrorResponse(error.getMessage());
                }
            });
            RequestQueue requestQueue = Volley.newRequestQueue(GlobalContext.getAppContext());
            requestQueue.add(stringRequest);

        } catch (Exception e) {
            Log.e("EXCEPTION CAPTURED", e.getMessage());


        }


    }

    public void changePass(String uName, String pass, final UserSettingsContracts.passChangeResponse result) {
        String url = "http://" + LoginIPaddress.ipAddress + "/api/changepassword?username=" + uName + "&password=" + pass;

        try {
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    ChangePasswordResponse changePasswordResponse = new Gson().fromJson(response,ChangePasswordResponse.class);
                    //Retrived here // TODO FROM HERE!!!
                    result.onSuccess(changePasswordResponse.getMessage());

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    result.onError(error.getMessage());
                    Log.e("PASSWORD CHANGE", error.getMessage());
                }
            });
            RequestQueue requestQueue = Volley.newRequestQueue(GlobalContext.getAppContext());
            requestQueue.add(stringRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
