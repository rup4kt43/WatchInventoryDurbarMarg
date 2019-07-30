package com.example.watchinventorydurbarmarg.UserSettings.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.watchinventorydurbarmarg.UserSettings.Contracts.UserSettingsContracts;
import com.example.watchinventorydurbarmarg.UserSettings.POJO.UserListPOJO.UserListResponse;
import com.example.watchinventorydurbarmarg.UserSettings.View.UserSettingsView;
import com.example.watchinventorydurbarmarg.R;

public class UserSettingsAdapter extends RecyclerView.Adapter {
    private final UserListResponse data;
    private final UserSettingsView context;
    private final UserSettingsContracts.adapterItemCallback callback;
    private TextView username;
    private ImageView edit, delete;

    public UserSettingsAdapter(UserSettingsView userSettingsView, UserListResponse userList, UserSettingsContracts.adapterItemCallback callback) {
        this.data = userList;
        this.context = userSettingsView;
        this.callback = callback;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.userlist_containeer, viewGroup, false);
        return new CustomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        username.setText(String.valueOf(data.getValue().get(i).getUNAME()));
    }

    @Override
    public int getItemCount() {
        return data.getValue().size();
    }

    private class CustomHolder extends RecyclerView.ViewHolder {
        public CustomHolder(View view) {
            super(view);
            username = view.findViewById(R.id.tv_userName);
            edit = view.findViewById(R.id.iv_edit);
            delete = view.findViewById(R.id.iv_delete);

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    context.showToast(pos + "ITEM CLICKED");
                    callback.onItemClick(data.getValue().get(pos).getUNAME());

                }
            });
        }
    }


}
