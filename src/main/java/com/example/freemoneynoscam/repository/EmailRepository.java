package com.example.freemoneynoscam.repository;

import com.example.freemoneynoscam.utility.Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmailRepository {
    static Statement stmt;
    static String sqlString;
    static ResultSet rs;

    private Connector c = new Connector();
    private Connection con = c.connectDB();

    public void insertEmailToDB(String email){
        c.connectDB();
        try {
            stmt = con.createStatement();
            sqlString = "INSERT INTO email_table (e_mail) VALUES('" + email + "')";
            stmt.executeUpdate(sqlString);
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String fetchSingleEmail(){
        c.connectDB();
        String email = "";

        try{
            stmt = con.createStatement();
            sqlString = "SELECT `e_mail` FROM `test_db`.`email_table` where email_table.id = 1";
            rs = stmt.executeQuery(sqlString);
            rs.next();
            email = rs.getString(1);
            c.connectDB().close();
      }catch (Exception e){
            e.printStackTrace();
        }

        return email;
    }

    public List<String> fetchAllEmails(){
        c.connectDB();
        ArrayList<String> emailList = new ArrayList<>();
        try{

        stmt = con.createStatement();
        sqlString = "SELECT * FROM `test_db`.`email_table`";
        ResultSet allEmailsResultSet = stmt.executeQuery(sqlString);

        while (allEmailsResultSet.next()) {
            emailList.add(allEmailsResultSet.getString(2));
        }
        con.close();

        }catch (Exception e ){
            e.printStackTrace();
        }
        return emailList;
    }
}
