package com.example.watchinventorydurbarmarg.CashierModule.Model;

import com.example.watchinventorydurbarmarg.CashierModule.Contracts.CashierContracts;
import com.example.watchinventorydurbarmarg.CashierModule.View.CashierView;
import com.example.watchinventorydurbarmarg.DatabaseHelper.CartDatabaseHelper;
import com.example.watchinventorydurbarmarg.Utilities.GlobalContext;

public class CashierModel {
    private CartDatabaseHelper cartDatabaseHelper;
    private CashierContracts.presenterModelCallback callBack;

    public CashierModel(){
        cartDatabaseHelper = new CartDatabaseHelper(GlobalContext.getAppContext());
    }

    public  void verifyBarCode(String barCode) {

    }


    public void addToCartDatabase(String name, CashierContracts.presenterModelCallback callback) {

        this.callBack = callback;

        String result = cartDatabaseHelper.insertCartDetails(name);
        callback.addToCartResult(result);

    }

    public void clearDatabase() {
        cartDatabaseHelper.deleteCartData();
    }
}
