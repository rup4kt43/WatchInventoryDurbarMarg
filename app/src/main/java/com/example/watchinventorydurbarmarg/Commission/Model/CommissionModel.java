package com.example.watchinventorydurbarmarg.Commission.Model;

import com.example.watchinventorydurbarmarg.Commission.API.CommisionAPI;

public class CommissionModel {
    private CommisionAPI commisionAPI;

    public void loadDetails(String barcode) {
        //API CALL
        commisionAPI = new CommisionAPI();
        commisionAPI.loadDetails(barcode);

    }
}
