package com.example.LoginExample.Controller;

import com.example.LoginExample.Model.Client;
import com.example.LoginExample.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Client")
public class HomeClient {

    @Autowired
    private ClientService clientService;

    @PostMapping("AddClient")
    public ResponseEntity<String> responseEntity(@RequestBody Client client)throws Exception{
        clientService.addClient(client);
        String msg="Added For New Client";
        ResponseEntity<String> response=new ResponseEntity<>(msg, HttpStatus.OK);
        return response;
    }
    @GetMapping("getClient")
    public ResponseEntity<Client> responseEntity(@RequestParam String customerEmail)throws Exception{
        Client client=clientService.getClient(customerEmail);
        ResponseEntity<Client> response=new ResponseEntity<>(client,HttpStatus.OK);
        return response;
    }
}
