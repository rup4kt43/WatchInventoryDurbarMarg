package com.example.watchinventorydurbarmarg.Commission.Utilities;

import android.app.Dialog;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.watchinventorydurbarmarg.Commission.View.CommissionView;
import com.example.watchinventorydurbarmarg.R;

public class CommissionChangeCustomDialog {
    private final CommissionView context;
    private TextView disSlab;
    private EditText et_change_commission;
    private Button apply;
    private String new_com;

    public CommissionChangeCustomDialog(CommissionView commissionView) {
        this.context = commissionView;
    }

    public void createDialog(final String dis, String disString) {

        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.commission_change_custom_dialog);

        disSlab = dialog.findViewById(R.id.dialog_dis_tv_slab);
        et_change_commission = dialog.findViewById(R.id.dialog_et_commission);
        apply = dialog.findViewById(R.id.dialog_btn_apply);

        disSlab.setText(disString);

        Window dialogWindow = dialog.getWindow();
        WindowManager m = context.getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = d.getWidth() * 1;


        dialog.show();

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new_com = et_change_commission.getText().toString();
                if (new_com.isEmpty()) {
                    return;
                } else {
                    switch (dis) {
                        case "5":
                            CommissionView.com_dis_5.setText(new_com+"%");
                            dialog.dismiss();
                            break;
                        case "10":
                            CommissionView.com_dis_10.setText(new_com+"%");
                            dialog.dismiss();
                            break;
                        case "15":
                            CommissionView.com_dis_15.setText(new_com+"%");
                            dialog.dismiss();
                            break;
                        default:
                            return;
                    }
                }
            }
        });


    }
}
