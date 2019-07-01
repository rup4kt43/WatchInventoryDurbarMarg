package com.example.watchinventorydurbarmarg.UserLogin.Model;

import com.example.watchinventorydurbarmarg.UserLogin.API.UserLoginAPI;

public class UserLoginModel {
    UserLoginAPI api;

    public void validateCredentials(String uname, String password) {
        api = new UserLoginAPI();
        api.validateWithAPI(uname,password);
    }
}
