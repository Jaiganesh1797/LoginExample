package com.example.LoginExample.Model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContactPerson {
    private String personfirstname;
    private String personlastname;
    private String personEmail;
    private Long personContact;

}
