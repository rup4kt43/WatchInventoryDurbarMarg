package com.example.watchinventorydurbarmarg.Commission.Presenter;

import com.example.watchinventorydurbarmarg.Commission.Contracts.CommissionContracts;
import com.example.watchinventorydurbarmarg.Commission.Model.CommissionModel;
import com.example.watchinventorydurbarmarg.Commission.View.CommissionView;

public class CommissionPresenter implements CommissionContracts.presenter {
    private CommissionContracts.view view;
    private CommissionModel model;

    public CommissionPresenter(CommissionView commissionView) {
        this.view = commissionView;
        model = new CommissionModel();
    }

    @Override
    public void onClickLoadDetails(String barcode) {

        if (!barcode.isEmpty()) {
            model.loadDetails(barcode);
        } else
            return;

    }
}
