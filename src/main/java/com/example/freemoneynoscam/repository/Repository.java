package com.example.freemoneynoscam.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.Statement;

public class Repository {

    static Connection con;
    static Statement stmt;
    static String sqlString;

    public void connectDB(){
        try {
            String url = "jdbc:mysql://localhost:3306/test_db";
            con = DriverManager.getConnection(url, "root", "Abearm27");
            System.out.println("Connection established");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insertEmailToDB(String email){
        connectDB();
        try {
            stmt = con.createStatement();
            sqlString = "INSERT INTO email_table (e_mail) VALUES('" + email + "')";
            stmt.executeUpdate(sqlString);
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
