package com.company;

import java.sql.*;

public class Users {
    private Statement statement= null;
    private ResultSet resultSet=null;
    private Connection connection;
    public void Users() throws SQLException{}

    public void addNewUser(String user_name,String secretKey){
        try{
            connection=SingletonDB.getConnection();

            statement=connection.createStatement();
            PreparedStatement preparedStatement=connection.prepareStatement("insert into users(username,secretKey) values(?,?)");
            preparedStatement.setString(1,user_name);
            preparedStatement.setString(2,secretKey);
            statement.executeUpdate(String.valueOf(preparedStatement));
            System.out.println("Data inserted successfully");
        }catch(SQLException e){
            e.printStackTrace();
    }
}

public void getUserInfo(int id){
    try{
        connection=SingletonDB.getConnection();
        statement=connection.createStatement();
        PreparedStatement preparedStatement=connection.prepareStatement("select * from users where id = ?");
        preparedStatement.setInt(1,id);
        resultSet=statement.executeQuery(String.valueOf(preparedStatement));
        System.out.format("%10s %10s %10s\n","Id","username","secretKey");
        while(resultSet.next()){
            System.out.format("%10s %10s %10s\n",resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
}

}