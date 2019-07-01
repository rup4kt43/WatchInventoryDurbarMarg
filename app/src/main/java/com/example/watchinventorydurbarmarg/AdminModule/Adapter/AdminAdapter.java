package com.example.watchinventorydurbarmarg.AdminModule.Adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.watchinventorydurbarmarg.AdminModule.Contracts.AdminContracts;
import com.example.watchinventorydurbarmarg.R;
import com.example.watchinventorydurbarmarg.AdminModule.View.AdminView;

public class AdminAdapter extends RecyclerView.Adapter {


    private final FragmentActivity context;
    private final AdminContracts.adapterCallback callback;
    private String inc;

    private String[] month = new String[]{"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
    private int[] income = new int[]{10000, 14000, 8000, 6000, 55000, 1000, 20000, 3500, 14000, 75000, 11000, 12000};
    private int[] expense = new int[]{2000, 1000, 1500, 5000, 1000, 2000, 3000, 4500, 2400, 2800, 1700, 9300};

    public AdminAdapter(AdminView adminView, AdminContracts.adapterCallback adapterCallback) {
        this.context = adminView;
        this.callback = adapterCallback;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.admin_recycler_containeer, viewGroup, false);
        return new WhatsNewCustomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        Log.e("Value of i", String.valueOf(i));
        tv_month.setText(month[i]);
        tv_income.setText(String.valueOf(income[i]));
        tv_expense.setText(String.valueOf(expense[i]));


    }

    @Override
    public int getItemCount() {
        Log.e("Lenght:", String.valueOf(month.length));
        return month.length;
    }

    private TextView tv_month, tv_income, tv_expense;

    private class WhatsNewCustomHolder extends RecyclerView.ViewHolder {
        public WhatsNewCustomHolder(View view) {
            super(view);
            tv_month = view.findViewById(R.id.tv_month);
            tv_expense = view.findViewById(R.id.tv_expense);
            tv_income = view.findViewById(R.id.tv_income);

            tv_month.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    callback.onClickResponse(month[pos]);

                }
            });

        }
    }
}
