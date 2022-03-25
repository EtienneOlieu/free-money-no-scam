package com.example.freemoneynoscam.services;

import com.example.freemoneynoscam.repository.EmailRepository;

public class ValidateEmailService {

    EmailRepository er = new EmailRepository();

    public boolean isEmailValid(String email){
        if(email.contains("@") && email.contains(".")){
            er.insertEmailToDB(email);
            return true;
        }
        return false;
    }
}
