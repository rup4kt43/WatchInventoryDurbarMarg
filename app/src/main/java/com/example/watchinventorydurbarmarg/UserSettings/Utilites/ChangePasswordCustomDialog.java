package com.example.watchinventorydurbarmarg.UserSettings.Utilites;

import android.app.Dialog;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.watchinventorydurbarmarg.R;
import com.example.watchinventorydurbarmarg.UserSettings.View.UserSettingsView;

public class ChangePasswordCustomDialog {

    private TextView username;
    private EditText pass;
    private EditText retype;
    private Button changePass;

    private TextView iName, iQty, iPrice, iModel;
    private ImageView iv, increase_quantity, decrease_quantity;
    Button addToCart, cancel;
    private int qty;


    private final UserSettingsView context;

    public ChangePasswordCustomDialog(UserSettingsView userSettingsView) {
        this.context = userSettingsView;
    }


    public void createCustomDialog(final String uName) {

        Log.e("Username ", uName);
        Log.e("Username ", uName);
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.change_password_dialog);
        username = dialog.findViewById(R.id.tv_change_pw_dialog_username);
        pass = dialog.findViewById(R.id.et_password);
        retype = dialog.findViewById(R.id.et_retype);
        changePass = dialog.findViewById(R.id.btn_savePassword);

        username.setText(String.valueOf(uName));

        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pass.getText().toString().isEmpty() || retype.getText().toString().isEmpty()) {
                    context.showToast("Field cannot be empty!!");
                } else {
                    context.changePass(uName, pass.getText().toString(), retype.getText().toString());
                }
            }
        });

        Window dialogWindow = dialog.getWindow();
        WindowManager m = context.getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();

        lp.width = d.getWidth() * 1;

        dialog.show();

/*

        final Dialog dialog = new Dialog(context);
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


        Window dialogWindow = dialog.getWindow();
        WindowManager m = context.getWindowManager();
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
*/


    }
}
