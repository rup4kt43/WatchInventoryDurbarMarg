package com.example.watchinventorydurbarmarg.CashierModule.Utilities;

import android.app.Dialog;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.watchinventorydurbarmarg.CashierModule.View.CashierView;
import com.example.watchinventorydurbarmarg.R;

public class AddToCartCustomDialog {


    private final CashierView brandItemContext;
    private TextView iName, iQty, iPrice, iModel;
    private ImageView iv, increase_quantity, decrease_quantity;
    Button addToCart, cancel;
    private int qty;

    public AddToCartCustomDialog(CashierView applicationContext) {
        this.brandItemContext = applicationContext;
    }


    public void createCustomDialog(final String name, int quantity, String model, double price, final CashierView cashierView) {
        final Dialog dialog = new Dialog(brandItemContext);
        dialog.setContentView(R.layout.global_custom_dialog);
        iName = dialog.findViewById(R.id.tv_item_name);
        iQty = dialog.findViewById(R.id.tv_quantity);
        iModel = dialog.findViewById(R.id.tv_item_model);
        iPrice = dialog.findViewById(R.id.tv_item_price);
        iv = dialog.findViewById(R.id.iv_image);
        iv.setImageResource(R.drawable.ic_launcher_background);
        iQty.setText("1");


        increase_quantity = dialog.findViewById(R.id.iv_brand_increase_quantity);
        decrease_quantity = dialog.findViewById(R.id.iv_brand_decrease_quantity);

        addToCart = dialog.findViewById(R.id.brand_dialog_addto_cart);
        cancel = dialog.findViewById(R.id.brand_dialog_cancel);

        if (quantity > 1) {
            addToCart.setText("Apply");
        } else {
            addToCart.setText("Add To Cart");
        }


        iName.setText(name);
        iQty.setText(String.valueOf(quantity));
        iPrice.setText(String.valueOf(price));
        iModel.setText(String.valueOf(model));

        Window dialogWindow = dialog.getWindow();
        WindowManager m = cashierView.getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();

        lp.width = d.getWidth() * 1;

        dialog.show();

        increase_quantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qty = Integer.parseInt(iQty.getText().toString());
                iQty.setText(String.valueOf(qty + 1));
                decrease_quantity.setClickable(true);

            }
        });

        decrease_quantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qty = Integer.parseInt(iQty.getText().toString());
                if (qty == 1) {
                    decrease_quantity.setClickable(false);
                } else {
                    iQty.setText(String.valueOf(qty - 1));

                }

            }
        });
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 cashierView.addToCartDatabase(name);
                dialog.dismiss();

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });


    }
}
