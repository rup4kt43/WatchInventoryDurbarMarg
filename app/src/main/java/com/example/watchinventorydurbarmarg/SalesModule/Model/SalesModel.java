package com.example.watchinventorydurbarmarg.SalesModule.Model;

import com.example.watchinventorydurbarmarg.SalesModule.API.SalesAPI;

public class SalesModel {
    private SalesAPI api;

    public void loadDataDetails(String barcode) {
        api = new SalesAPI();
        api.loadDetails(barcode);
    }
}
