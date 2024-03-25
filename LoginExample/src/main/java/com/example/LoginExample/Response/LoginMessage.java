package com.example.LoginExample.Response;

import lombok.Data;

@Data
public class LoginMessage {
    String message;
    Boolean status;
    String token;

    public LoginMessage(String string, boolean b, String tok) {
        // TODO Auto-generated constructor stub
        this.message=string;
        this.status=b;
        this.token=tok;
    }


    public void LoginMesage(String message, Boolean status, String token) {
        this.message = message;
        this.status = status;
        this.token = token;
    }



}
