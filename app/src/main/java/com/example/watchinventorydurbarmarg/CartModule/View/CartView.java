package com.example.watchinventorydurbarmarg.CartModule.View;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.watchinventorydurbarmarg.CartModule.Adapter.CartAdapter;
import com.example.watchinventorydurbarmarg.CartModule.Contracts.CartContracts;
import com.example.watchinventorydurbarmarg.CartModule.DTO.CartDTO;
import com.example.watchinventorydurbarmarg.CartModule.Presenter.CartPresenter;
import com.example.watchinventorydurbarmarg.CashierModule.View.CashierView;
import com.example.watchinventorydurbarmarg.DatabaseHelper.CartDatabaseHelper;
import com.example.watchinventorydurbarmarg.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CartView extends AppCompatActivity implements CartContracts.view {


    CartPresenter cartPresenter;
    ArrayList<CartDTO> cartItemDetails;
    ArrayList<CartDTO> headerArray;
    RecyclerView recyclerView;
    CartAdapter cartAdapter;

    LinearLayout cartEmptyLayout, nonEmptyLayout;
    Button proceed;
    private Button addItem;


    private ArrayList<CartDTO> cArray;
    private HashMap<CartDTO, List<CartDTO>> childArray;
    private int lastExpandedPosition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        /**
         * TODO
         * 1) Do change in database if quantity in cart is changed and back pressed!
         * 2) add some item to cart action 
         */

        proceed = findViewById(R.id.proceed);


        headerArray = new ArrayList<>();
        cArray = new ArrayList<>();
        childArray = new HashMap<CartDTO, List<CartDTO>>();

        cartItemDetails = new ArrayList<>();
        cartEmptyLayout = findViewById(R.id.if_cart_is_empty);
        nonEmptyLayout = findViewById(R.id.ll_non_empty);

        addItem = findViewById(R.id.btn_add_item_to_cart);

        //Initializing the presenter object and calling method
        cartPresenter = new CartPresenter(this);
        cartPresenter.retriveCartItems();

        cartPresenter.checkIfCartIsEmpty(headerArray);


        //---Working with properties of action bar--//
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);
        getSupportActionBar().setElevation(0);

        TextView title = findViewById(getResources().getIdentifier("action_bar_title", "id", getPackageName()));
        title.setText("CART");
        ImageView imageView = findViewById(R.id.imageView2);
        //imageView.setImageResource(R.drawable.cart_24dp);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartPresenter.proceedToSaveOnClick();
               /* CartDatabaseHelper cartDatabaseHelper = new CartDatabaseHelper(CartView.this);
                cartDatabaseHelper.deleteCartData();
                BaseView.cartBadgeCount.setText(String.valueOf(headerArray.size()));*/


            }
        });
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   startActivity(new Intent(CartView.this, BaseView.class));
                BaseView.isChecked = false;
                CartView.this.finish();*/
                cartPresenter.clearCartDatabase();
                startActivity(new Intent(CartView.this, CashierView.class));
                CartView.this.finish();
                CashierView.isChecked = false;

            }
        });


        recyclerView = findViewById(R.id.rv_cart);


      /*  DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;

        expandableListView.setIndicatorBounds(width - GetDipsFromPixel(50), width - GetDipsFromPixel(10));*/

        setAdapter();


    }

    private void setAdapter() {
        cartAdapter = new CartAdapter(this, headerArray);

    }


    //--------------Implemented Methods---------------//

    //Switching activity
    @Override
    public void switchToSaveBil() {
        // Intent i = new Intent(CartView.this,BillView.class);
        // i.putExtra("cartContent", headerArray);
        //startActivity(i);
    }


    //Displaying custom Toast Message
    @Override
    public void showToastMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    //Loading the data from the cart database!
    @Override
    public void loadCartData(ArrayList<CartDTO> cartItems) {
        /**
         * TODO -> Put this section on presenter !!
         */
        this.cartItemDetails = cartItems;

        for (int i = 0; i < cartItems.size(); i++) {
            CartDTO headerData = new CartDTO();
            CartDTO childData = new CartDTO();

            headerData.setItemName(cartItems.get(i).getItemName());
            headerData.setItemModel(cartItems.get(i).getItemModel());
            headerData.setItemQuantity(cartItems.get(i).getItemQuantity());
            headerData.setMaxPrice(cartItems.get(i).getMaxPrice());

            headerArray.add(i, headerData);

            //TODO-> Make a separate DTO for child Section
            childData.setMinPrice(cartItems.get(i).getMinPrice());
            childData.setAvgPrice(cartItems.get(i).getAvgPrice());
            childData.setMaxPrice(cartItems.get(i).getMaxPrice());
            cArray.add(childData);

            childArray.put(headerArray.get(i), cArray);
        }
    }

    @Override
    public void loadEmptyCartLayout() {
        nonEmptyLayout.setVisibility(View.GONE);
        cartEmptyLayout.setVisibility(View.VISIBLE);


    }

    @Override
    public void loadCartLayout() {
        proceed.setVisibility(View.VISIBLE);
        cartEmptyLayout.setVisibility(View.GONE);
    }

    //Convert pixel to dip
    public int GetDipsFromPixel(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }

    //Checking if the item is equal to 1 or not :: so that cant decrease on item quantity 1
    @Override
    public void headerOnQuantityDecreaseValidation(int groupPosition) {
        cartPresenter.itemQuantityDecreaseValidation(headerArray, groupPosition);

    }


    //Item Quantity Decrease Action
    @Override
    public void headerOnQuantityDecrease(ArrayList<CartDTO> header) {

        headerArray = header;
        cartAdapter.notifyDataSetChanged();   //notifying adapter that data has been changed !!
    }

    //Header increase on Click Action
    @Override
    public void headerOnQuantityIncrease(int groupPosition) {
        // Require some validation???
        headerArray.get(groupPosition).setItemQuantity(String.valueOf(Integer.parseInt(headerArray.get(groupPosition).getItemQuantity())
                + 1));
        cartAdapter.notifyDataSetChanged(); //notifying adapter that item has been changed !!
    }


    //Header remove on Click Action

    @Override
    public void headerOnClickRemove(final int position) {
        /**
         * TODO -> this section should be performed on presenter since its a business logic
         * --------------------------------------------------------------------------------
         */

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Are you sure you want to remove this product?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CartDatabaseHelper cartDatabaseHelper = new CartDatabaseHelper(CartView.this);
                cartDatabaseHelper.removeCertainCartData(CartView.this, headerArray.get(position).getItemName());
                headerArray.remove(position);
                Log.e("HeaderArraySize", String.valueOf(headerArray.size()));
                //    BaseView.cartBadgeCount.setText(String.valueOf(headerArray.size()));
                //  BrandItemsView.cartBadgeCount.setText(String.valueOf(headerArray.size()));
                cartPresenter.checkIfCartIsEmpty(headerArray);
                cartAdapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setAdapter();
        CashierView.isChecked = false;
        //BaseView.isChecked = false;
        //BrandItemsView.isChecked = false;
        cartPresenter.updateCartDatabase(headerArray);


    }


}
