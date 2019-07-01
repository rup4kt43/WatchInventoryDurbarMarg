package com.example.watchinventorydurbarmarg.UserLogin.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.watchinventorydurbarmarg.AdminModule.View.AdminView;
import com.example.watchinventorydurbarmarg.R;
import com.example.watchinventorydurbarmarg.UserLogin.Contracts.UserLoginContracts;
import com.example.watchinventorydurbarmarg.UserLogin.Presenter.UserLoginPresenter;

public class UserLoginView extends Activity implements UserLoginContracts.view {

    EditText etUser, etPassword;
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

        String text =Encrypt("12345678","test");

        Log.e("EncryptedPass", text);
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();



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


        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP:
                        etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        etPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                        break;
                }
                return true;
            }
        });


      /*  this.getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getActionBar().setDisplayShowCustomEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setCustomView(R.layout.custom_action_bar);
        getActionBar().setIcon(R.mipmap.ic_ims_logo);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getActionBar().setElevation(4);
        }*/

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                userName = etUser.getText().toString();
                password = etPassword.getText().toString();


                if (userName.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Username or Password field cannot be Empty!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    //Encrypting the password for saving it in database --> 5/8/2019
                    encPassword = Encrypt(password, "AmitLalJoshi");

                    presenter.validateUnameAndPass(userName,encPassword);

                    //validating the username and password from value returned from database---> 5/8/2019

                    Log.i("checkuserlogin", ret);//Direndra Subba August-04-2016



                    /*if (ret.equals("no")) {
                        Toast.makeText(getApplicationContext(),
                                "Username or Password is Incorrect",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        if (checkBox.isChecked()) {
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("username", userName);
                            editor.putBoolean("LoginStatus", true);
                            editor.commit();
                            startMainActivity();
                        } else {

                            startMainActivity();
                        }
                    }*/
                }
            }
        });
    }

    private void startMainActivity() {
        Intent openMain = new Intent(getApplicationContext(),
                UserLoginView.class);
        startActivity(openMain);
        finish();
    }

    public static String Encrypt(String Text, String Key) {
        int i;
        char TEXTCHAR;
        char KEYCHAR;
        String keychar = "";
        String encoded = "";
        for (i = 0; i < Text.length(); i++) {
            TEXTCHAR = Text.charAt(i);
            int keysI = ((i + 1) % Key.length());
            keychar = Key.substring(keysI);
            KEYCHAR = keychar.charAt(0);
            int encrypted = (int) TEXTCHAR ^ (int) KEYCHAR;
            encoded += (char) encrypted;

        }
        return encoded;
    }


    /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}
