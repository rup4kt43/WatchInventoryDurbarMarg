package com.example.watchinventorydurbarmarg.Presenter;

import com.example.watchinventorydurbarmarg.Contracts.AdminContracts;
import com.example.watchinventorydurbarmarg.View.AdminView;

public class AdminPresenter implements AdminContracts.presenter {
    private final AdminView view;

    public AdminPresenter(AdminView adminView) {
        this.view = adminView;
    }

    @Override
    public void onSpinnerSelectedItem(String msg) {


        switch (msg) {
            case "Monthly":
                view.showToast("Monthly selected");
                break;
            case "Daily":
                view.showToast("Daily selected");
                break;
            case "Yearly":
                view.showToast("Yearly selected");
                break;
            default:
                return;
        }

    }
}
