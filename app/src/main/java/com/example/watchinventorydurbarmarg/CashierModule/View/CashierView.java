package com.example.watchinventorydurbarmarg.CashierModule.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.watchinventorydurbarmarg.CartModule.View.CartView;
import com.example.watchinventorydurbarmarg.CashierModule.Adapter.CashierAdapter;
import com.example.watchinventorydurbarmarg.CashierModule.Contracts.CashierContracts;
import com.example.watchinventorydurbarmarg.CashierModule.Presenter.CashierPresenter;
import com.example.watchinventorydurbarmarg.CashierModule.Utilities.AddToCartCustomDialog;
import com.example.watchinventorydurbarmarg.R;


public class CashierView extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, CashierContracts.view {

    public static boolean isChecked = false;
    public static TextView cartBadgeCount;
    private RecyclerView recyclerView;
    private CashierPresenter presenter;
    EditText et_itemsBarCode;
     ImageView btn_loadDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashier2);

        et_itemsBarCode=findViewById(R.id.et_items_barcode);
        btn_loadDetails=findViewById(R.id.btn_loadDetails);

        btn_loadDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String barCode=et_itemsBarCode.getText().toString();
                presenter.barcodeReader(barCode);
            }
        });



        //Initializing object of presenter
        presenter = new CashierPresenter(this);

        //Toolbar Properties
        Toolbar toolbar = findViewById(R.id.tb_cashier);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("CASHIER");

        //Drawer Layout and Navigation property
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        cartBadgeCount = findViewById(R.id.cart_badge);

        //Recycler View Properties
        recyclerView = findViewById(R.id.rv_brands);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        //Adapter for RecyclerView
        CashierAdapter cashierAdapter = new CashierAdapter(this, new CashierContracts.adapterCallBack() {
            @Override
            public void onAdapterItemClick(String name) {
                AddToCartCustomDialog add = new AddToCartCustomDialog(CashierView.this);
                add.createCustomDialog(name, 1, "Model-1", 20000, CashierView.this);
            }
        });


        recyclerView.setAdapter(cashierAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        final MenuItem menuItem = menu.findItem(R.id.action_cart);
        View actionView = MenuItemCompat.getActionView(menuItem);
        cartBadgeCount = actionView.findViewById(R.id.cart_badge);

        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuItem);
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_cart) {
            if (!isChecked) {
                isChecked = true;
                startActivity(new Intent(CashierView.this, CartView.class));
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void addToCartDatabase(String name) {
        presenter.addToCartDatabase(name);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        presenter.clearDatabase();
        super.onDestroy();

    }

}
