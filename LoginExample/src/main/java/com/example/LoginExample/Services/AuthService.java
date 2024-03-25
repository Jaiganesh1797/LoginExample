package com.example.LoginExample.Services;

import com.example.LoginExample.Model.Login;
import com.example.LoginExample.Model.Register;
import com.example.LoginExample.Response.LoginMessage;

public interface AuthService {

    public Register  addedUser(Register register)throws Exception;
    public LoginMessage authenticateUser(Login login)throws Exception;


}

