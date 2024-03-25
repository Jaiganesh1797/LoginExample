package com.example.LoginExample.Services;

import com.example.LoginExample.Model.Client;
import com.example.LoginExample.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private ClientRepository clientRepository;


    @Override
    public void addClient(Client client) throws Exception {
        clientRepository.save(client);

    }

    @Override
    public Client getClient(String customerEmail) throws Exception {
        Optional<Client> client=clientRepository.findBycustomerEmail(customerEmail);
        Client getallClient=client.get();
        return getallClient;
    }

    @Override
    public List<Client> getallClient() throws Exception {

        return null;
    }
}
