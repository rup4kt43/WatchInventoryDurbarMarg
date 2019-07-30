package com.example.watchinventorydurbarmarg.Expenses.Presenter;

import com.example.watchinventorydurbarmarg.Expenses.Contracts.ExpenseContracts;
import com.example.watchinventorydurbarmarg.Expenses.Model.ExpensesModel;
import com.example.watchinventorydurbarmarg.Expenses.View.ExpensesView;

public class ExpensesPresenter implements ExpenseContracts.presenter{

    private final ExpenseContracts.view view;
    private ExpensesModel model;

    public ExpensesPresenter(ExpensesView expensesView) {
        this.view = expensesView;
        model = new ExpensesModel();

    }

    @Override
    public void validateInputs(Double amount, String expense, String payment_mode, String date) {
        if(String.valueOf(amount).isEmpty() || expense.isEmpty() || date.isEmpty()){
            view.showToast("Fill up the empty credentials!!");
        }else{
            model.saveExpense(amount,expense,payment_mode,date);

        }
    }
}
