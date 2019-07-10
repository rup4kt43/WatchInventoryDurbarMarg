package com.example.watchinventorydurbarmarg.CashierModule.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.watchinventorydurbarmarg.CashierModule.Contracts.CashierContracts;
import com.example.watchinventorydurbarmarg.CashierModule.View.CashierView;
import com.example.watchinventorydurbarmarg.R;

public class CashierAdapter extends RecyclerView.Adapter {
    private final CashierView context;
    private final CashierContracts.adapterCallBack callback;
    private TextView brandName;
    private LinearLayout linearLayout;
    String brands[] = new String[]{"ROLEX", "IMS ", "DIABLO", "ABC", "DEF", "GHI", "JKL", "MNOP", "QRS"};

    public CashierAdapter(CashierView cashierView, CashierContracts.adapterCallBack adapterCallBack) {
        this.context = cashierView;
        this.callback = adapterCallBack;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.brand_rv_containeer, viewGroup, false);
        return new CustomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        brandName.setText(brands[i]);
    }

    @Override
    public int getItemCount() {
        return brands.length;
    }

    private class CustomHolder extends RecyclerView.ViewHolder {
        public CustomHolder(View view) {
            super(view);
            brandName = view.findViewById(R.id.tv_brand_containeer);
            linearLayout = view.findViewById(R.id.ll_brand_containeer);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    callback.onAdapterItemClick(brands[position]);
                }
            });


        }
    }
}
