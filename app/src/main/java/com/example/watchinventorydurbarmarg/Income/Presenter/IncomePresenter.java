package com.example.watchinventorydurbarmarg.Income.Presenter;

import com.example.watchinventorydurbarmarg.Expenses.Contracts.ExpenseContracts;
import com.example.watchinventorydurbarmarg.Expenses.View.ExpensesView;
import com.example.watchinventorydurbarmarg.Income.Contracts.IncomeContracts;
import com.example.watchinventorydurbarmarg.Income.Model.IncomeModel;
import com.example.watchinventorydurbarmarg.Income.View.IncomeView;

public class IncomePresenter implements IncomeContracts.presenter {

    private final IncomeContracts.view view;
    private IncomeModel model;

    public IncomePresenter(IncomeView incomeView) {
        this.view =  incomeView;
        model = new IncomeModel();

    }

    @Override
    public void validateInputs(Double amount, String expense, String payment_mode, String date) {
        if (String.valueOf(amount).isEmpty() || expense.isEmpty() || date.isEmpty()) {
            view.showToast("Fill up the empty credentials!!");
        } else {
            model.saveExpense(amount, expense, payment_mode, date);

        }
    }
}
