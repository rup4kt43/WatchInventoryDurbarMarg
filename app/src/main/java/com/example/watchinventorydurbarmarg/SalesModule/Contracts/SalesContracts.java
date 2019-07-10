package com.example.watchinventorydurbarmarg.Sales.Contracts;

public interface SalesContracts {

    interface view {
        void showToast(String msg);

    }

    interface presenter {
            void LoadDetails(String barcode);
    }

}
