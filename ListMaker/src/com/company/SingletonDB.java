package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonDB {
    private static String url = "jdbc:postgresql://ec2-35-175-68-90.compute-1.amazonaws.com:5432/d8esop4e63et52";
    private static String user_id = "cuupwpxvdxivmg";
    private static String pass = "ba3a321d75e6a0a1c7fa7e9edfed870bd40c479c3a532d7c57abc1b4aac00105";

//    creating a singleton

    private static Connection connection=null;


    static{
        try{
            connection=DriverManager.getConnection(url,user_id,pass);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}