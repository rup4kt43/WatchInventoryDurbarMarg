package com.example.watchinventorydurbarmarg.SalesModule.Presenter;

import com.example.watchinventorydurbarmarg.SalesModule.Contracts.SalesContracts;
import com.example.watchinventorydurbarmarg.SalesModule.Model.SalesModel;
import com.example.watchinventorydurbarmarg.SalesModule.POJO.BarcodeResponse;
import com.example.watchinventorydurbarmarg.SalesModule.View.SalesView;

public class SalesPresenter implements SalesContracts.presenter {
    private SalesContracts.view view;
    private SalesModel model;


    public SalesPresenter(SalesView salesView) {
        this.view = salesView;
         model = new SalesModel();
    }

    @Override
    public void LoadDetails(String barcode) {
        if(!barcode.isEmpty()){
            model.loadDataDetails(barcode, new SalesContracts.presenterModelCallback() {
                @Override
                public void onSuccessResponse(BarcodeResponse barcodeResponse) {
                    view.loadBarcodeDetails(barcodeResponse);
                }
            });
        }else{
            view.showToast("Barcode Field Cannot be empty!");
        }
    }
}
