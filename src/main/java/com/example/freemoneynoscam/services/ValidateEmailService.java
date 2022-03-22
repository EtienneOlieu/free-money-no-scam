package com.example.freemoneynoscam.services;

import com.example.freemoneynoscam.repository.Repository;

public class ValidateEmailService {

    private Repository re = new Repository();

    public boolean isEmailValid(String email){
        if(email.contains("@") && email.contains(".")){
            re.insertEmailToDB(email);
            return true;
        }
        return false;
    }

    public void getConnection(){
        re.connectDB();
    }
}
