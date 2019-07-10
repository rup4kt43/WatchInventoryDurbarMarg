package com.example.watchinventorydurbarmarg.CashierModule.Presenter;

import com.example.watchinventorydurbarmarg.CashierModule.Contracts.CashierContracts;
import com.example.watchinventorydurbarmarg.CashierModule.Model.CashierModel;
import com.example.watchinventorydurbarmarg.CashierModule.View.CashierView;

public class CashierPresenter implements CashierContracts.presenter{
    private CashierContracts.view view;
    private CashierModel model;
    int cartBadgeCount;

    public CashierPresenter(CashierView cashierView) {
        this.view = cashierView;
        model = new CashierModel();
    }

    @Override
    public void addToCartDatabase(String name) {
        model.addToCartDatabase(name, new CashierContracts.presenterModelCallback() {
            @Override
            public void addToCartResult(String result) {
                switch (result) {
                    case "Success":
                        cartBadgeCount = Integer.parseInt(CashierView.cartBadgeCount.getText().toString());
                        CashierView.cartBadgeCount.setText(String.valueOf(cartBadgeCount + 1));
                        // BaseView.cartBadgeCount.setText(String.valueOf(cartBadgeCount + 1));
                        view.showToast("Added to Cart");
                        break;
                    case "Fail":
                        view.showToast("Failed to Add the data!");
                        break;
                    case "Quantity":
                        view.showToast("Quantity Increased");
                        break;
                    default:
                        return;
                }
            }
        });
    }

    @Override
    public void clearDatabase() {
        model.clearDatabase();
    }
}
