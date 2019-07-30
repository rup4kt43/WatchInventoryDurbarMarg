package com.example.watchinventorydurbarmarg.Expenses.View;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.watchinventorydurbarmarg.Expenses.Contracts.ExpenseContracts;
import com.example.watchinventorydurbarmarg.Expenses.Presenter.ExpensesPresenter;
import com.example.watchinventorydurbarmarg.R;

import java.util.Calendar;

public class ExpensesView extends AppCompatActivity implements ExpenseContracts.view {

    private EditText datePicker;
    private DatePickerDialog datePickerDialog;
    private EditText et_amount,et_expense;
    private RadioButton rb_cash,rb_cheque;
    String payment_mode;
    private Button btn_submit;
    private String date;

    private ExpensesPresenter presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);


        //Referencing
        et_amount = findViewById(R.id.et_amount);
        et_expense = findViewById(R.id.et_expense);
        rb_cash = findViewById(R.id.rb_cash);
        rb_cheque = findViewById(R.id.rb_cheque);
        btn_submit = findViewById(R.id.btn_submit);

        presenter = new ExpensesPresenter(this);



        datePicker = findViewById(R.id.et_datePicker);
        datePicker.setInputType(InputType.TYPE_NULL);
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                final int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);


                datePickerDialog = new DatePickerDialog(ExpensesView.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        datePicker.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                        date = (month+1)+"/"+dayOfMonth+"/"+year;
                    }
                }, year, month, day);

                datePickerDialog.show();
            }
        });


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amount = Double.parseDouble(et_amount.getText().toString());
                String expense = et_expense.getText().toString();
                if(rb_cash.isChecked()){
                    payment_mode = String.valueOf(rb_cash.getText());
                }else if(rb_cheque.isChecked()){
                    payment_mode = String.valueOf(rb_cheque.getText());
                }

                presenter.validateInputs(amount,expense,payment_mode,date);

            }
        });



    }

    @Override
    public void showToast(String msg) {

    }
}
