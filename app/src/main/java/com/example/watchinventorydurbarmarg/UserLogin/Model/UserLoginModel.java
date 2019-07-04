package com.example.watchinventorydurbarmarg.UserLogin.Model;

import com.example.watchinventorydurbarmarg.UserLogin.API.UserLoginAPI;
import com.example.watchinventorydurbarmarg.UserLogin.Contracts.UserLoginContracts;

public class UserLoginModel {
    UserLoginAPI api;

    public void validateCredentials(String uname, String password, final UserLoginContracts.presenterModelCallBack callBack) {
        api = new UserLoginAPI();
        api.validateWithAPI(uname,password, new UserLoginContracts.modelAPICallBack() {
            @Override
            public void onSuccessResponse(String msg) {
                callBack.onSuccessResponse(msg);
            }
        });
    }
}
