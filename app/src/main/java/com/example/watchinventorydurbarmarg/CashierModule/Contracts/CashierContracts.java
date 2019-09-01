package com.example.watchinventorydurbarmarg.CashierModule.Contracts;

public interface CashierContracts {

    interface adapterCallBack {
        void onAdapterItemClick(String name);
    }

    interface view {
        void addToCartDatabase(String name);
        void showToast(String msg);
    }

    interface presenter {
        void addToCartDatabase(String name);
        void clearDatabase();
    }

    interface presenterModelCallback {
        void addToCartResult(String result);
       void barcode(String barcodeResult);
    }


}
