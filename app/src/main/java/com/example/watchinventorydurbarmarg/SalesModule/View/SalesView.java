package com.example.watchinventorydurbarmarg.SalesModule.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.watchinventorydurbarmarg.R;
import com.example.watchinventorydurbarmarg.SalesModule.Adapters.SalesSpecificationAdapter;
import com.example.watchinventorydurbarmarg.SalesModule.Contracts.SalesContracts;
import com.example.watchinventorydurbarmarg.SalesModule.POJO.BarcodeResponse;
import com.example.watchinventorydurbarmarg.SalesModule.Presenter.SalesPresenter;

import java.util.Arrays;
import java.util.List;

public class SalesView extends AppCompatActivity implements SalesContracts.view {
    private EditText barcode;
    private SalesPresenter presenter;
    private LinearLayout mainLayout, backLayout;
    private RecyclerView recyclerView;
    private TextView model, markPrice, costPrice, purchaseDate;
    private SalesSpecificationAdapter salesSpecificationAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        mainLayout = findViewById(R.id.ll_main_layout);
        backLayout = findViewById(R.id.ll_back_layout);

        recyclerView = findViewById(R.id.rv_specification);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        presenter = new SalesPresenter(this);


        model = findViewById(R.id.tv_model_name);
        markPrice = findViewById(R.id.tv_mrp);
        costPrice = findViewById(R.id.tv_cp);
        purchaseDate = findViewById(R.id.tv_purchase_date);


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

    @Override
    public void loadBarcodeDetails(BarcodeResponse barcodeResponse) {

        String value = barcodeResponse.getValue().get(0).getDESCA();
        List<String> val = Arrays.asList(value.split(","));

       // model.setText(barcodeResponse.getValue().get(0).getMODEL().toString());
        markPrice.setText(String.valueOf(barcodeResponse.getValue().get(0).getRATEA()));
        costPrice.setText(String.valueOf(barcodeResponse.getValue().get(0).getPRATEA()));
        purchaseDate.setText(String.valueOf(barcodeResponse.getValue().get(0).getPURCHASEDATE()));

        if (!val.isEmpty()) {
            salesSpecificationAdapter = new SalesSpecificationAdapter(this, val);
            recyclerView.setAdapter(salesSpecificationAdapter);
        }


    }
}
