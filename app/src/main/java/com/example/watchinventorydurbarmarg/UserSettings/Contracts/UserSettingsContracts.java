package com.example.watchinventorydurbarmarg.UserSettings.Contracts;

import com.example.watchinventorydurbarmarg.UserSettings.POJO.UserListPOJO.UserListResponse;

public interface UserSettingsContracts {


    interface view {
            void apiLoadedData(UserListResponse userListResponse);
            void showToast(String msg);

            void changePass(String uName,String pass, String retype);
    }

    interface presenter {
        void loadUserList();
        void changePass(String uName,String pass, String retype);

    }

    interface presenterModelCallback {
        void modelResponse(UserListResponse userListResponse);
        void onErrorResponse(String msg);
    }

    interface modelApiCallback {
        void apiResponse(UserListResponse userListResponse);
        void onErrorResponse(String msg);



    }

    interface adapterItemCallback{
        void onItemClick(String uName);
    }

    interface passChangeResponse{
        void onSuccess(String msg);
        void onError(String msg);
    }

    interface presenterModelPassWordChangeCallback{
        void onSuccess(String msg);
        void onError(String msg);
    }


}
