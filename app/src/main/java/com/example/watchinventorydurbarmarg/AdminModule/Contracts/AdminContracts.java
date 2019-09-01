package com.example.watchinventorydurbarmarg.AdminModule.Contracts;

public interface AdminContracts {

    interface adapterCallback {
        void onClickResponse(String msg);


    }

    interface view {
        void showToast(String msg);


    }

    interface presenter {
        void onSpinnerSelectedItem(String msg);
    }
}
