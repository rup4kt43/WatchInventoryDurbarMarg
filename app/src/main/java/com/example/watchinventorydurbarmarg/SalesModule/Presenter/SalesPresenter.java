package com.example.watchinventorydurbarmarg.Sales.Presenter;

import com.example.watchinventorydurbarmarg.Sales.Contracts.SalesContracts;
import com.example.watchinventorydurbarmarg.Sales.Model.SalesModel;
import com.example.watchinventorydurbarmarg.Sales.View.SalesView;

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
            model.loadDataDetails(barcode);
        }else{
            view.showToast("Barcode Field Cannot be empty!");
        }
    }
}
