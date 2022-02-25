package com.company;

import java.sql.*;

public class list {
    private Statement statement= null;
    private ResultSet resultSet=null;
    private Connection connection;


    public void addItem(int user_id,String item_name){
        try{
            connection=SingletonDB.getConnection();
            statement=connection.createStatement();
            PreparedStatement preparedStatement=connection.prepareStatement("insert into data(user_id,items) values(?,?)");
            preparedStatement.setInt(1,user_id);
            preparedStatement.setString(2,item_name);
            statement.executeUpdate(String.valueOf(preparedStatement));
            System.out.println("Data inserted successfully");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void viewlist(int user_id,String secretKey){
        try{
            connection=SingletonDB.getConnection();
            statement=connection.createStatement();
            PreparedStatement preparedStatement=connection.prepareStatement("select username,items from data join users on users.id = data.user_id " +
                    "where secretKey = ? and user_id = ?");
            preparedStatement.setString(1,secretKey);
            preparedStatement.setInt(2,user_id);
            resultSet=statement.executeQuery(String.valueOf(preparedStatement));
            System.out.format("%10s %10s \n","username","items");
            while(resultSet.next()){
                System.out.format("%10s %10s\n",resultSet.getString(1),resultSet.getString(2));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteList(int user_id){
        connection=SingletonDB.getConnection();
        try{
            statement=connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("Delete from data where user_id = ?");
            preparedStatement.setInt(1,user_id);
            statement.executeUpdate(String.valueOf(preparedStatement));
            System.out.println("List deleted successfully!!");
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}