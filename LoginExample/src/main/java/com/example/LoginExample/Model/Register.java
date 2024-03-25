package com.example.LoginExample.Model;


//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "register-Db")
public class Register {

    @Id
    private int regId;
    private String regName;
    private String regPassword;
    private String regEmail;
}
