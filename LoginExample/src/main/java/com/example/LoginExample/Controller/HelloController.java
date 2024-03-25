package com.example.LoginExample.Controller;

import com.example.LoginExample.Model.Login;
import com.example.LoginExample.Model.Register;
import com.example.LoginExample.Response.LoginMessage;
import com.example.LoginExample.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("adminInvoice")
public class HelloController {

    @Autowired
    private AuthService service;

    @PostMapping("addRegister")
    public ResponseEntity<String> response(@RequestBody Register register)throws Exception{
        ResponseEntity<String> responseEntity=null;
        try{
            service.addedUser(register);
            String msg="Added For New Register"+" : "+register.getRegName();
            responseEntity=new ResponseEntity<>(msg, HttpStatus.OK);
        }
        catch (Exception e){
            String msg=e.getMessage();
            responseEntity=new ResponseEntity<>(msg, HttpStatus.OK);
        }

        return responseEntity;
    }


//    @PostMapping("loginUser")
//    public ResponseEntity<LoginMessage> response(@RequestBody Login login)throws Exception{
//            LoginMessage loginMessage = service.authenticateUser(login);
//            ResponseEntity<LoginMessage> responseEntity = new ResponseEntity<>(loginMessage, HttpStatus.OK);
//        return responseEntity;
//    }
    @PostMapping("loginUser")
    public ResponseEntity<LoginMessage> response(@RequestBody Login login) throws Exception {
        LoginMessage loginMessage = service.authenticateUser(login);
        ResponseEntity<LoginMessage> responseEntity = new ResponseEntity<>(loginMessage, HttpStatus.OK);
        return responseEntity;
    }




}
