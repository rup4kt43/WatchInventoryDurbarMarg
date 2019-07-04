package com.example.watchinventorydurbarmarg.Sales.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.watchinventorydurbarmarg.R;
import com.example.watchinventorydurbarmarg.Sales.Contracts.SalesContracts;
import com.example.watchinventorydurbarmarg.Sales.Presenter.SalesPresenter;

public class SalesView extends AppCompatActivity implements SalesContracts.view {
    private EditText barcode;
    private SalesPresenter presenter;
    private LinearLayout mainLayout, backLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        mainLayout = findViewById(R.id.ll_main_layout);
        backLayout = findViewById(R.id.ll_back_layout);


        presenter = new SalesPresenter(this);


        ImageView loadDetails = findViewById(R.id.btn_loadDetails);
        barcode = findViewById(R.id.et_sales_barcode);

        loadDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bcode = barcode.getText().toString();
                presenter.LoadDetails(bcode);

            }
        });
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
