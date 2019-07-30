package com.example.watchinventorydurbarmarg.UserLogin.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.watchinventorydurbarmarg.AdminModule.View.AdminView;
import com.example.watchinventorydurbarmarg.CashierModule.View.CashierView;
import com.example.watchinventorydurbarmarg.R;
import com.example.watchinventorydurbarmarg.SalesModule.View.SalesView;
import com.example.watchinventorydurbarmarg.UserLogin.Contracts.UserLoginContracts;
import com.example.watchinventorydurbarmarg.UserLogin.Presenter.UserLoginPresenter;

public class UserLoginView extends Activity implements UserLoginContracts.view {

    EditText etUser, etPassword, etIP1, etIP2, etIP3, etIP4, etPort;
    Button btnLogin;
    String password = "", ret, encPassword;
    public static String userName = "";
    SharedPreferences sharedPreferences;
    CheckBox checkBox;
    UserLoginPresenter presenter;



    ImageView iv;

    //ImsDao db = new ImsDao(UserLogin.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);


        //updated by Rupak ---> 6/16/2019
        presenter = new UserLoginPresenter(this);


       /* Log.e("EncryptedPass", text);
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
*/

        //updated  by Rupak --> 5/21/2019 for keep me signed in portion (using shared preference)
        sharedPreferences = getSharedPreferences("Login", Context.MODE_PRIVATE);
        boolean loginState = sharedPreferences.getBoolean("LoginStatus", false);
        if (loginState) {
            String uName = sharedPreferences.getString("username", "");
            userName = uName;
            startActivity(new Intent(UserLoginView.this, AdminView.class));
            finish();
        }


        etUser = (EditText) findViewById(R.id.etUser);
        etPassword = (EditText) findViewById(R.id.etPassword);
        iv = findViewById(R.id.iv_show_password);
        checkBox = findViewById(R.id.cb_keepSignedIn);
        etIP1 = findViewById(R.id.et_ip1);
        etIP2 = findViewById(R.id.et_ip2);
        etIP3 = findViewById(R.id.et_ip3);
        etIP4 = findViewById(R.id.et_ip4);
        etPort = findViewById(R.id.et_port);

        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = etUser.getText().toString();
                password = etPassword.getText().toString();
                String ip1 = etIP1.getText().toString();
                String ip2 = etIP2.getText().toString();
                String ip3 = etIP3.getText().toString();
                String ip4 = etIP4.getText().toString();
                String port = etPort.getText().toString();

                presenter.fieldEmptyValidation(userName, password, ip1, ip2, ip3,ip4, port);
            }
        });


    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void switchCashier() {
            startActivity(new Intent(UserLoginView.this, CashierView.class));
            this.finish();
    }

    @Override
    public void switchAdmin() {
        startActivity(new Intent(UserLoginView.this, AdminView.class));
        this.finish();

    }

    @Override
    public void switchSales() {
        startActivity(new Intent(UserLoginView.this, SalesView.class));
        this.finish();

    }
}
