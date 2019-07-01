package com.example.watchinventorydurbarmarg.UserLogin.Presenter;

import com.example.watchinventorydurbarmarg.UserLogin.Contracts.UserLoginContracts;
import com.example.watchinventorydurbarmarg.UserLogin.Model.UserLoginModel;
import com.example.watchinventorydurbarmarg.UserLogin.View.UserLoginView;

public class UserLoginPresenter implements UserLoginContracts.presenter {
    private UserLoginContracts.view view;
    private UserLoginModel model;


    public UserLoginPresenter(UserLoginView userLoginView) {

        this.view = userLoginView;
        model = new UserLoginModel();
    }

    @Override
    public void validateUnameAndPass(String uname, String pass) {
        model.validateCredentials(uname,pass);
    }
}
