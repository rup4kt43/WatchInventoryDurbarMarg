package com.example.watchinventorydurbarmarg.UserLogin.Contracts;

public interface UserLoginContracts {


    interface  view{
        void showToast(String msg);
        void switchCashier();
        void switchAdmin();
        void switchSales();
    }
    interface presenter{

        void fieldEmptyValidation(String uname, String pass,String ip1,String ip2, String ip3,String ip4,String port);
    }

    interface modelAPICallBack{
        void onSuccessResponse(String msg);
        void onErrorResponse(String msg);

    }

    interface presenterModelCallBack{
        void onSuccessResponse(String msg);
        void onErrorResponse(String msg);
    }
}
