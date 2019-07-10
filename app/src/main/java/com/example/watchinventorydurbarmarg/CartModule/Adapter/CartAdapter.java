package com.example.watchinventorydurbarmarg.CartModule.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.watchinventorydurbarmarg.CartModule.DTO.CartDTO;
import com.example.watchinventorydurbarmarg.CartModule.View.CartView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter {
    private final CartView context;
    private final ArrayList<CartDTO> data;

    public CartAdapter(CartView cartView, ArrayList<CartDTO> headerArray) {
        this.context = cartView;
        this.data = headerArray;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
