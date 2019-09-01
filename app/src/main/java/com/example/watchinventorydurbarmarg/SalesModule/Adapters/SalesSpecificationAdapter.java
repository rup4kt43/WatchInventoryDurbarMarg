package com.example.watchinventorydurbarmarg.SalesModule.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.watchinventorydurbarmarg.R;
import com.example.watchinventorydurbarmarg.SalesModule.View.SalesView;

import java.util.List;

public class SalesSpecificationAdapter extends RecyclerView.Adapter {
    private final SalesView context;
    private final List<String> specList;
    private TextView sn, spec;

    public SalesSpecificationAdapter(SalesView salesView, List<String> val) {
        this.context = salesView;
        this.specList = val;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.sales_specification_containeer, viewGroup, false);
        return new CustomSpecHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        sn.setText(String.valueOf(i + 1));

        spec.setText(String.valueOf(specList.get(i)));
    }

    @Override
    public int getItemCount() {
        return specList.size();
    }

    private class CustomSpecHolder extends RecyclerView.ViewHolder {
        public CustomSpecHolder(View view) {
            super(view);
            sn = view.findViewById(R.id.tv_sn);
            spec = view.findViewById(R.id.tv_spec);


        }
    }
}
