package com.example.watchinventorydurbarmarg.Income.Contracts;

public interface IncomeContracts {

    interface view{
        void  showToast(String msg);

    }
    interface presenter{
        void validateInputs(Double amount, String expense, String payment_mode, String date);
    }
}
