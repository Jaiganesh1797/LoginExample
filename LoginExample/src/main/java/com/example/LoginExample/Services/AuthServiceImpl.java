package com.example.LoginExample.Services;

import com.example.LoginExample.Jwt.JwtUtils;
import com.example.LoginExample.Model.Login;
import com.example.LoginExample.Model.Register;
import com.example.LoginExample.Repository.UserRepository;
import com.example.LoginExample.Response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserRepository userRepository;



    @Autowired
    private JwtUtils jwtTokenProvider;

    @Override
    public Register addedUser(Register register) throws Exception {

        Optional<Register> register1=userRepository.findByregName(register.getRegName());
        if(register1.isPresent()){
            throw new Exception("Already Defined In this User");
        }
        return userRepository.save(register);
    }

    @Override
    public LoginMessage authenticateUser(Login login) throws Exception {
        Optional<Register> register=userRepository.findByregName(login.getRegName());
        Optional<Register> pass=userRepository.findByregPassword(login.getRegPassword());

        if(register.isPresent()){
            Register user = register.get();
            if(pass.isPresent()){
                String jwtToken = jwtTokenProvider.generateToken(user.getRegName());
                return new LoginMessage("Login Success",true,jwtToken);
            }
            else {
                return new LoginMessage("Pls Check The Password",false,"check Password");
            }
        }
        else {
            return new LoginMessage("pls Check The UserName",false,"Check Username");
        }


    }

}
