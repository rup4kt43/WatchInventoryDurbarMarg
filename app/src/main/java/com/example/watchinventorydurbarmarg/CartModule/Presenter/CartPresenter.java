package com.example.watchinventorydurbarmarg.CartModule.Presenter;

import com.example.watchinventorydurbarmarg.CartModule.Contracts.CartContracts;
import com.example.watchinventorydurbarmarg.CartModule.DTO.CartDTO;
import com.example.watchinventorydurbarmarg.CartModule.Model.CartModel;
import com.example.watchinventorydurbarmarg.CartModule.View.CartView;

import java.util.ArrayList;

public class CartPresenter implements CartContracts.presenter {
    private final CartView mainContext;
    private CartModel cartModel;
    private ArrayList<CartDTO> cartItemDetails;

    public CartPresenter(CartView cartView) {
        this.mainContext = cartView;
        cartModel = new CartModel();
        cartItemDetails = new ArrayList<>();
    }


    @Override
    public void itemQuantityDecreaseValidation(ArrayList<CartDTO> headerArray, int position) {
        int quantity = Integer.parseInt(headerArray.get(position).getItemQuantity());
        if (quantity == 1) {
            return;
        } else {
            headerArray.get(position).setItemQuantity(String.valueOf(Integer.parseInt(headerArray.get(position).getItemQuantity())
                    - 1));
            mainContext.headerOnQuantityDecrease(headerArray);
        }

    }

    @Override
    public void retriveCartItems() {
        cartModel.retriveCartData(mainContext, new CartContracts.presenterModel() {
            @Override
            public void presenterModelCallback(ArrayList<CartDTO> cartItems) {
                if (!cartItems.isEmpty()) {
                    mainContext.loadCartData(cartItems);
                } else {
                    mainContext.showToastMessage("No item added to cart");
                }
            }
        });
    }

    @Override
    public void proceedToSaveOnClick() {
        mainContext.switchToSaveBil();
    }

    @Override
    public void checkIfCartIsEmpty(ArrayList<CartDTO> headerArray) {
        if (headerArray.isEmpty()) {
            mainContext.loadEmptyCartLayout();
        } else {
            mainContext.loadCartLayout();
        }
    }

    @Override
    public void updateCartDatabase(ArrayList<CartDTO> headerArray) {
        cartModel.updateDatabase(headerArray);
    }

    @Override
    public void clearCartDatabase() {
        cartModel.clearCartDatabase();
    }
}
