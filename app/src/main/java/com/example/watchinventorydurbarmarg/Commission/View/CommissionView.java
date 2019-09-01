package com.example.watchinventorydurbarmarg.Commission.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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

    private String disMax5 = "5", disMax10 = "10", disMax15 = "15";

    public static TextView com_dis_5, com_dis_10, com_dis_15;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_commission);

        presenter = new CommissionPresenter(this);
        final CommissionChangeCustomDialog commissionChangeCustomDialog = new CommissionChangeCustomDialog(this);

        loadDetails = findViewById(R.id.btn_loadDetails);

        barcode = findViewById(R.id.et_items_barcode);


        //API Call!!!
        loadDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = barcode.getText().toString();
                presenter.onClickLoadDetails(text);
            }
        });

    }

    @Override
    public void alternateLayout(int select) {


    }

    @Override
    public void showToast(String msg) {

    }
}
