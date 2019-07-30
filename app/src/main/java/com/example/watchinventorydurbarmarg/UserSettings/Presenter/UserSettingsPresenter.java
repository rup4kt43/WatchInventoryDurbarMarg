package com.example.watchinventorydurbarmarg.UserSettings.Presenter;

import com.example.watchinventorydurbarmarg.UserSettings.Contracts.UserSettingsContracts;
import com.example.watchinventorydurbarmarg.UserSettings.Model.UserSettingsModel;
import com.example.watchinventorydurbarmarg.UserSettings.POJO.UserListPOJO.UserListResponse;
import com.example.watchinventorydurbarmarg.UserSettings.View.UserSettingsView;

public class UserSettingsPresenter implements UserSettingsContracts.presenter {

    private UserSettingsContracts.view view;
    private UserSettingsModel model;

    public UserSettingsPresenter(UserSettingsView userSettingsView) {
        this.view = userSettingsView;
        model = new UserSettingsModel();
    }

    @Override
    public void loadUserList() {
        model.loadUserList(new UserSettingsContracts.presenterModelCallback() {
            @Override
            public void modelResponse(UserListResponse userListResponse) {
                view.apiLoadedData(userListResponse);
            }

            @Override
            public void onErrorResponse(String msg) {
                view.showToast(msg);
            }
        });
    }

    @Override
    public void changePass(String uName, String pass, String retype) {
        model.changePass(uName, pass, retype, new UserSettingsContracts.presenterModelPassWordChangeCallback() {
            @Override
            public void onSuccess(String msg) {
                view.showToast(msg);
            }

            @Override
            public void onError(String msg) {
                view.showToast(msg);
            }
        });
    }
}
