package com.example.watchinventorydurbarmarg.Expenses.Model;

import com.example.watchinventorydurbarmarg.Expenses.API.ExpenseAPI;

public class ExpensesModel {
    public void saveExpense(Double amount, String expense, String payment_mode, String date) {
        ExpenseAPI expenseAPI = new ExpenseAPI();
        expenseAPI.apiCall(date,expense,amount,payment_mode);
    }
}
