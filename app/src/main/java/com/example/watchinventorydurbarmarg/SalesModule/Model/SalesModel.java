package com.example.watchinventorydurbarmarg.SalesModule.Model;

import com.example.watchinventorydurbarmarg.SalesModule.API.SalesAPI;
import com.example.watchinventorydurbarmarg.SalesModule.Contracts.SalesContracts;
import com.example.watchinventorydurbarmarg.SalesModule.POJO.BarcodeResponse;

public class SalesModel {
    private SalesAPI api;

    public void loadDataDetails(String barcode, final SalesContracts.presenterModelCallback callback) {
        api = new SalesAPI();
        api.loadDetails(barcode, new SalesContracts.modelApiCallback() {
            @Override
            public void onSuccessResponse(BarcodeResponse barcodeResponse) {
                callback.onSuccessResponse(barcodeResponse);

            }
        });
    }
}
