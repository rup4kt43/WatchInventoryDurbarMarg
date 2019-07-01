package com.example.watchinventorydurbarmarg.UserLogin.Contracts;

public interface UserLoginContracts {


    interface  view{

    }
    interface presenter{
        void validateUnameAndPass(String uname, String pass);
    }
}
