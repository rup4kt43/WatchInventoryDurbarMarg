package com.example.watchinventorydurbarmarg.Commission.Contracts;

import com.example.watchinventorydurbarmarg.Commission.POJO.LoadResponse;

public interface CommissionContracts {

    interface view {
        void alternateLayout(int select);    //  0 for empty layout and 1 for loaded layout
        void showToast(String msg);
    }

    interface presenter {
        void onClickLoadDetails(String barcode);
    }




}
