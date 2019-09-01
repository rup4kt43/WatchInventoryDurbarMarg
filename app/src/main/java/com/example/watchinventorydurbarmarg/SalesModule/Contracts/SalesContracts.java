package com.example.watchinventorydurbarmarg.SalesModule.Contracts;

import com.example.watchinventorydurbarmarg.SalesModule.POJO.BarcodeResponse;

public interface SalesContracts {

    interface view {
        void showToast(String msg);
        void loadBarcodeDetails(BarcodeResponse barcodeResponse);

    }

    interface presenter {
        void LoadDetails(String barcode);
    }


    interface modelApiCallback {
        void onSuccessResponse(BarcodeResponse barcodeResponse);
    }

    interface presenterModelCallback {
        void onSuccessResponse(BarcodeResponse barcodeResponse);
    }

}
