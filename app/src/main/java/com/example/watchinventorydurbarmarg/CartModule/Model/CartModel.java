package com.example.watchinventorydurbarmarg.CartModule.Model;


import com.example.watchinventorydurbarmarg.CartModule.Contracts.CartContracts;
import com.example.watchinventorydurbarmarg.CartModule.DTO.CartDTO;
import com.example.watchinventorydurbarmarg.CartModule.View.CartView;
import com.example.watchinventorydurbarmarg.DatabaseHelper.CartDatabaseHelper;
import com.example.watchinventorydurbarmarg.Utilities.GlobalContext;

import java.util.ArrayList;

public class CartModel {
    private CartDatabaseHelper cartDatabaseHelper;

    public CartModel() {
        cartDatabaseHelper = new CartDatabaseHelper(GlobalContext.getAppContext());
    }

    public void retriveCartData(CartView mainContext, CartContracts.presenterModel presenterModel) {
        CartDatabaseHelper cartDatabaseHelper = new CartDatabaseHelper(mainContext);
        ArrayList<CartDTO> cartDTOS = cartDatabaseHelper.retriveCartItems();
        presenterModel.presenterModelCallback(cartDTOS);

    }

    public void updateDatabase(ArrayList<CartDTO> headerArray) {

        cartDatabaseHelper.onUpdateColumns(headerArray);
    }

    public void clearCartDatabase() {
        cartDatabaseHelper.deleteCartData();
    }
}
