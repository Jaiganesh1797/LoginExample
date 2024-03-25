package com.example.LoginExample.Model;

//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "client_Data")
public class Client {

    @Id
    private int customerId;
    private String customerEmail;
    private String customerType;
    private Long primaryContact;
    private String companyName;
    private Long customerPhone;
    private String paymentTerms;
    private Address address;
    private ContactPerson contactPerson;




}
