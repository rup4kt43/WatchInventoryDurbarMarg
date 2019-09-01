package com.example.watchinventorydurbarmarg.Income.Model;


import com.example.watchinventorydurbarmarg.Income.API.IncomeApi;

public class IncomeModel {
    public void saveExpense(Double amount, String expense, String payment_mode, String date) {
        IncomeApi incomeApi = new IncomeApi();

        incomeApi.apiCall(date, expense, amount, payment_mode);
    }
}
