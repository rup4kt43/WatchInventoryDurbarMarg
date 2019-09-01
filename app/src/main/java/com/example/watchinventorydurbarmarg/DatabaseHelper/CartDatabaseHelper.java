package com.example.watchinventorydurbarmarg.DatabaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.example.watchinventorydurbarmarg.CartModule.DTO.CartDTO;

import java.util.ArrayList;

public class CartDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "sulax.db";
    public static final String TABLE_NAME = "cart_table";
    public static final String CART_COL_1 = "ID";
    public static final String CART_COL_2 = "NAME";
    public static final String CART_COL_3 = "MODEL";
    public static final String CART_COL_4 = "QUANTITY";
    public static final String CART_COL_5 = "MINPRICE";
    public static final String CART_COL_6 = "MAXPRICE";
    public static final String CART_COL_7 = "AVGPRICE";


    public CartDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    public static final String Create_Table_Cart = "CREATE TABLE " + TABLE_NAME + "(" + CART_COL_1 + " INTEGER, " + CART_COL_2 + " TEXT, "
            + CART_COL_3 + " TEXT, " + CART_COL_4 + " INTEGER ," + CART_COL_5 + " REAL, " + CART_COL_6 + " REAL, " +
            CART_COL_7 + " REAL )";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create_Table_Cart);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }

    public String insertCartDetails(String itemName) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        long result;
        boolean b = columnExists(itemName);
        if (b) {
            String query = "SELECT QUANTITY FROM cart_table WHERE NAME='" + itemName + "'";
            Cursor cursor = db.rawQuery(query, null);
            if (cursor.moveToFirst()) {

                int quantity = Integer.parseInt(cursor.getString(cursor.getColumnIndex(CART_COL_4)));
                String quan = String.valueOf(quantity + 1);
                db.execSQL("UPDATE cart_table SET QUANTITY = 5 WHERE NAME = \"ROLEX\"");
                db.execSQL("UPDATE " + TABLE_NAME + " SET QUANTITY ='" + quan + "' WHERE NAME='" + itemName + "'");
                return "Quantity";

            }


        } else {

            cv.put(CART_COL_2, itemName);
            cv.put(CART_COL_3, "ttid3");
            cv.put(CART_COL_4, 1);
            cv.put(CART_COL_5, 5000);
            cv.put(CART_COL_6, 8000);
            cv.put(CART_COL_7, 6500);
            result = db.insert(TABLE_NAME, null, cv);
            if (result == -1)
                return "Fail";
            else
                return "Success";
        }

        return null;

    }

    public ArrayList<CartDTO> retriveCartItems() {
        ArrayList<CartDTO> cartDetails = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        String query = "select * from cart_table ";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                CartDTO cartDTO = new CartDTO();
                cartDTO.setItemQuantity(cursor.getString(cursor.getColumnIndex(CART_COL_4)));
                cartDTO.setItemModel(cursor.getString(cursor.getColumnIndex(CART_COL_3)));
                cartDTO.setItemName(cursor.getString(cursor.getColumnIndex(CART_COL_2)));
                cartDTO.setMinPrice(cursor.getString(cursor.getColumnIndex(CART_COL_5)));
                cartDTO.setAvgPrice(cursor.getString(cursor.getColumnIndex(CART_COL_7)));
                cartDTO.setMaxPrice(cursor.getString(cursor.getColumnIndex(CART_COL_6)));
                cartDetails.add(cartDTO);
            } while (cursor.moveToNext());
        }


        return cartDetails;

    }

    public void deleteCartData() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from " + TABLE_NAME);

    }

    public void removeCertainCartData(Context context, String name) {
        CartDatabaseHelper dbHelper = new CartDatabaseHelper(context);

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        try {

            String[] args = new String[]{name};
            db.delete(CartDatabaseHelper.TABLE_NAME, CartDatabaseHelper.CART_COL_2 + "=?", args);

            db.close();
        } catch (SQLiteException e) {
            db.close();
            e.printStackTrace();
        }


    }

    public boolean columnExists(String value) {

        SQLiteDatabase db = getWritableDatabase();
        String sql = "SELECT NAME FROM cart_table WHERE NAME='" + value + "'";
        Log.e("SQL QUERY", sql);


        try {
            Cursor cursor = db.rawQuery(sql, null);
            int count = cursor.getCount();
            Log.e("CURSOR COUNT", String.valueOf(count));
            if (cursor.getCount() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLiteException e) {
            Log.e("EXCEPTION", e.getMessage());
            return false;
        }


    }

    public void onUpdateColumns(ArrayList<CartDTO> headerArray) {
        //TODO update the  database table
        SQLiteDatabase db = getWritableDatabase();
        for (int i = 0; i < headerArray.size(); i++) {
            String name = headerArray.get(i).getItemName();
            ContentValues cv = new ContentValues();
            cv.put(CART_COL_4, headerArray.get(i).getItemQuantity());
            db.update(TABLE_NAME, cv, CART_COL_2 + "=?", new String[]{name});

        }

    }

    public int retriveCertainCartItem(String name) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "SELECT QUANTITY FROM cart_table WHERE NAME='" + name + "'";

        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToFirst()) {
            int quant = cursor.getInt(cursor.getColumnIndex(CART_COL_4));
            if (quant > 1) {
                return quant;
            } else
                return 1;
        }
        return 1;
    }
 


}





