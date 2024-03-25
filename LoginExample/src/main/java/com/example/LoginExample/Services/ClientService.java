package com.example.LoginExample.Services;

import com.example.LoginExample.Model.Client;

import java.util.List;

public interface ClientService {

    public void addClient(Client client)throws Exception;

    public Client getClient(String customerEmail)throws Exception;

    public List<Client> getallClient()throws Exception;
}
