package com.example.watchinventorydurbarmarg.UserLogin.Presenter;

import com.example.watchinventorydurbarmarg.UserLogin.Contracts.UserLoginContracts;
import com.example.watchinventorydurbarmarg.UserLogin.Model.UserLoginModel;
import com.example.watchinventorydurbarmarg.UserLogin.View.UserLoginView;
import com.example.watchinventorydurbarmarg.Utilities.LoginIPaddress;

public class UserLoginPresenter implements UserLoginContracts.presenter {
    private UserLoginContracts.view view;
    private UserLoginModel model;
    private String encPassword = "";
    public static String uName = "";


    public UserLoginPresenter(UserLoginView userLoginView) {

        this.view = userLoginView;
        model = new UserLoginModel();
    }

    @Override
    public void fieldEmptyValidation(final String uname, String pass, String ip1, String ip2, String ip3, String ip4, String port) {
        if (uname.isEmpty() || pass.isEmpty() || ip1.isEmpty() || ip2.isEmpty() ||
                ip3.isEmpty() || ip4.isEmpty() || port.isEmpty()) {
            view.showToast("Fields cannot be empty!");
        } else {
            LoginIPaddress.setIpAddress(ip1, ip2, ip3, ip4, port);

            model.validateCredentials(uname, pass, new UserLoginContracts.presenterModelCallBack() {
                @Override
                public void onSuccessResponse(String msg) {
                    uName = uname;
                    switch (msg) {
                        case "A":
                            view.switchAdmin();
                            break;
                        case "C":
                            view.switchCashier();
                            break;
                        case "S":
                            view.switchSales();
                            break;
                        default:
                            return;
                    }
                }

                @Override
                public void onErrorResponse(String msg) {
                    view.showToast(msg);
                }
            });
        }
    }
}
