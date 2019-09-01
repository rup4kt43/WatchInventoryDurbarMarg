package com.example.watchinventorydurbarmarg.AdminModule.View;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.watchinventorydurbarmarg.AdminModule.Adapter.AdminAdapter;
import com.example.watchinventorydurbarmarg.AdminModule.Contracts.AdminContracts;
import com.example.watchinventorydurbarmarg.AdminModule.Presenter.AdminPresenter;
import com.example.watchinventorydurbarmarg.Commission.View.CommissionView;
import com.example.watchinventorydurbarmarg.Expenses.View.ExpensesView;
import com.example.watchinventorydurbarmarg.R;
import com.example.watchinventorydurbarmarg.UserSettings.View.UserSettingsView;


public class AdminView extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AdminContracts.view {

    final String[] spinner_string = {"Daily", "Monthly", "Yearly"};
    private AdminPresenter adminPresenter;
    private Button select;
    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("ADMIN");


        adminPresenter = new AdminPresenter(this);


        select = findViewById(R.id.btn_select);


        //Recycler View content

        RecyclerView recyclerView = findViewById(R.id.home_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        AdminAdapter adminAdapter = new AdminAdapter(this, new AdminContracts.adapterCallback() {
            @Override
            public void onClickResponse(String msg) {
                Toast.makeText(AdminView.this, "MONTH: " + msg, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adminAdapter);


        //Drawer Content

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //Spinner View Action with static content
        final Spinner spinner = findViewById(R.id.sp_selection_type);
        final ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, spinner_string);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setSelection(1);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected_item = spinner.getSelectedItem().toString();
                adminPresenter.onSpinnerSelectedItem(selected_item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //   adminPresenter.onSpinnerSelectedItem("monthly");
            }
        });
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(AdminView.this);
                dialog.setContentView(R.layout.date_picker_custom_dialog);
                dialog.show();

                datePicker = dialog.findViewById(R.id.spinner_datePicker);
                Button applyBtn = dialog.findViewById(R.id.dp_btn_apply);


                applyBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String month = String.valueOf(datePicker.getMonth());
                        String year = String.valueOf(datePicker.getYear());
                        //   Toast.makeText(AdminView.this, day + "-"+ month + "-" + year, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_addNewUser) {
            startActivity(new Intent(AdminView.this, UserSettingsView.class));
        }

        if (id == R.id.nav_changeCommission) {
            startActivity(new Intent(AdminView.this, CommissionView.class));
        }

        if (id == R.id.nav_expenses) {
            startActivity(new Intent(AdminView.this, ExpensesView.class));
        }

    /*    if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg + "Selected", Toast.LENGTH_SHORT).show();
    }


}
