package com.example.watchinventorydurbarmarg.CartModule.Contracts;

import com.example.watchinventorydurbarmarg.CartModule.DTO.CartDTO;

import java.util.ArrayList;

public interface CartContracts {

    interface view {
        void switchToSaveBil();



        void showToastMessage(String msg);

        void headerOnQuantityDecreaseValidation(int groupPosition);

        void headerOnQuantityDecrease(ArrayList<CartDTO> headerArray);

        void headerOnQuantityIncrease(int groupPosition);

        void headerOnClickRemove(int groupPosition);

        void loadCartData(ArrayList<CartDTO> cartItems);

        void loadEmptyCartLayout();

        void loadCartLayout();
    }

    interface presenter {

        void itemQuantityDecreaseValidation(ArrayList<CartDTO> headerArray, int position);

        void retriveCartItems();

        void proceedToSaveOnClick();

        void checkIfCartIsEmpty(ArrayList<CartDTO> headerArray);

        void updateCartDatabase(ArrayList<CartDTO> headerArray);

        void clearCartDatabase();
    }

    interface presenterModel {
        void presenterModelCallback(ArrayList<CartDTO> cartItems);
    }
}
