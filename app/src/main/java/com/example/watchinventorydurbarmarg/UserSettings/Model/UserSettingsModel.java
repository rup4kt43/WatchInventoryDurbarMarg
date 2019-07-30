package com.example.watchinventorydurbarmarg.UserSettings.Model;

import com.example.watchinventorydurbarmarg.UserSettings.API.UserSettingsAPI;
import com.example.watchinventorydurbarmarg.UserSettings.Contracts.UserSettingsContracts;
import com.example.watchinventorydurbarmarg.UserSettings.POJO.UserListPOJO.UserListResponse;

public class UserSettingsModel {

    private UserSettingsAPI api;
    String msg;

    public void loadUserList(final UserSettingsContracts.presenterModelCallback callback) {
        api = new UserSettingsAPI();
        api.loadUserData(new UserSettingsContracts.modelApiCallback() {
            @Override
            public void apiResponse(UserListResponse userListResponse) {
                callback.modelResponse(userListResponse);
            }

            @Override
            public void onErrorResponse(String msg) {
                callback.onErrorResponse(msg);
            }
        });


    }

    public void changePass(String uName, String pass, String retype, final UserSettingsContracts.presenterModelPassWordChangeCallback presenterCallback) {
        api = new UserSettingsAPI();
        api.changePass(uName,pass, new UserSettingsContracts.passChangeResponse() {
            @Override
            public void onSuccess(String msg) {
                presenterCallback.onSuccess(msg);
            }

            @Override
            public void onError(String msg) {
                presenterCallback.onError(msg);
            }
        });
    }
}
