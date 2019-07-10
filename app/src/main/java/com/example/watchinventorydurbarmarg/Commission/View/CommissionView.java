package com.example.watchinventorydurbarmarg.Commission.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.watchinventorydurbarmarg.Commission.Contracts.CommissionContracts;
import com.example.watchinventorydurbarmarg.Commission.Presenter.CommissionPresenter;
import com.example.watchinventorydurbarmarg.Commission.Utilities.CommissionChangeCustomDialog;
import com.example.watchinventorydurbarmarg.R;

public class CommissionView extends AppCompatActivity implements CommissionContracts.view {

    private ImageView loadDetails;
    private CommissionPresenter presenter;
    private EditText barcode;

    private String dis_5 = "Min Dis-0% & Max Dis-5%";
    private String dis_10 = "Min Dis-6% & Max Dis-10%";
    private String dis_15 = "Min Dis-11% & Max";

    private String disMax5 = "5", disMax10= "10" , disMax15= "15";

    public static TextView com_dis_5, com_dis_10, com_dis_15;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_commission);

        presenter = new CommissionPresenter(this);
        final CommissionChangeCustomDialog commissionChangeCustomDialog = new CommissionChangeCustomDialog(this);

        loadDetails = findViewById(R.id.btn_loadDetails);
        com_dis_5 = findViewById(R.id.tv_dis_5);
        com_dis_10 = findViewById(R.id.tv_dis_10);
        com_dis_15 = findViewById(R.id.tv_dis_15);
       /* barcode = findViewById(R.id.et_commision_load_barcode);

        loadDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = barcode.getText().toString();
                presenter.onClickLoadDetails(text);
            }
        });*/
        com_dis_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               commissionChangeCustomDialog.createDialog(disMax5,dis_5);
            }
        });

        com_dis_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commissionChangeCustomDialog.createDialog(disMax10,dis_10);

            }
        });

        com_dis_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commissionChangeCustomDialog.createDialog(disMax15,dis_15);

            }
        });
    }
}
