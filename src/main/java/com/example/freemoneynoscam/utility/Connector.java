package com.example.freemoneynoscam.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connector {

    static Connection con;

    public Connection connectDB(){
        try {
            String url = "jdbc:mysql://localhost:3306/test_db";
            con = DriverManager.getConnection(url, "root", "Abearm27" +
                    ""); //pw er fjernet
            System.out.println("Connection established");
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
