package com.example.watchinventorydurbarmarg.Expenses.Contracts;

public interface ExpenseContracts {

    interface view{
        void  showToast(String msg);

    }
    interface presenter{
        void validateInputs(Double amount,String expense,String payment_mode,String date);
    }
}
