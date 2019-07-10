package com.example.watchinventorydurbarmarg.Sales.Model;

import com.example.watchinventorydurbarmarg.Sales.API.SalesAPI;

public class SalesModel {
    private SalesAPI api;

    public void loadDataDetails(String barcode) {
        api = new SalesAPI();
        api.loadDetails(barcode);
    }
}
