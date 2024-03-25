package com.example.LoginExample.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {

    private String country;
    private String address;
    private String city;
    private String state;
    private Long zipcode;
}
