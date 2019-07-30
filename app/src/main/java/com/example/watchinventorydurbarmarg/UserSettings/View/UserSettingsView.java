package com.example.watchinventorydurbarmarg.UserSettings.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.watchinventorydurbarmarg.UserSettings.Adapter.UserSettingsAdapter;
import com.example.watchinventorydurbarmarg.UserSettings.Contracts.UserSettingsContracts;
import com.example.watchinventorydurbarmarg.UserSettings.POJO.UserListPOJO.UserListResponse;
import com.example.watchinventorydurbarmarg.UserSettings.Presenter.UserSettingsPresenter;
import com.example.watchinventorydurbarmarg.UserSettings.Utilites.ChangePasswordCustomDialog;
import com.example.watchinventorydurbarmarg.R;

public class UserSettingsView extends AppCompatActivity implements UserSettingsContracts.view {
    private RecyclerView recyclerView;
    private UserSettingsPresenter userSettingsPresenter;
    private UserListResponse userList;
    UserSettingsAdapter adapters;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);


        userSettingsPresenter = new UserSettingsPresenter(this);
        userSettingsPresenter.loadUserList();









    }

    private void setAdapter() {
//Horizontal separator
        recyclerView = findViewById(R.id.rv_userList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        adapters = new UserSettingsAdapter(this, userList, new UserSettingsContracts.adapterItemCallback() {
            @Override
            public void onItemClick(String uName) {
                Log.e("Username ", uName);
                Log.e("Username ", uName);
                ChangePasswordCustomDialog changePasswordCustomDialog = new ChangePasswordCustomDialog(UserSettingsView.this);
                changePasswordCustomDialog.createCustomDialog(uName);
            }
        });
        recyclerView.setAdapter(adapters);
    }

    @Override
    public void apiLoadedData(UserListResponse userListResponse) {
        this.userList = userListResponse;
        setAdapter();
        Log.e("LIST", userList.toString());
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void changePass(String uName, String pass, String retype) {
        userSettingsPresenter.changePass(uName,pass,retype);
    }
}
