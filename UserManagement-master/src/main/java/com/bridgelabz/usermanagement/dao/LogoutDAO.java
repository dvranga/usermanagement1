package com.bridgelabz.usermanagement.dao;

import com.bridgelabz.usermanagement.configurations.DataBaseConfiguration;
import com.bridgelabz.usermanagement.model.User;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogoutDAO {


    public  boolean updateLoginDetails(int userId, String username){
        DataBaseConfiguration connection=new DataBaseConfiguration();
        User  user=new User();
        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement("" +
                    "INSERT INTO `user_management`.`login_details` (`userId`, `user_name`, `login_history`,`login_attempts`) VALUES (?, ?, ?, ?);");

            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, username);
            preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            preparedStatement.setInt(4, user.getLoginAttempts());

            int result = preparedStatement.executeUpdate();
            return (result!=0);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }


    public static void updateLoginAttempts(String name) {

        DataBaseConfiguration connection=new DataBaseConfiguration();

        try {
            PreparedStatement preparedStatement=connection.getConnection().prepareStatement("" +
                    "UPDATE `user_management`.`login_details` SET `login_attempts` = `login_attempts`+1 WHERE `user_name`=?  order by id desc limit 1;");
            preparedStatement.setString(1,name);
            int resultSet = preparedStatement.executeUpdate();
            System.out.println(resultSet+" inactive status");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int getLoginAttempts(String username) {
        DataBaseConfiguration connection=new DataBaseConfiguration();
        User user=new User();

        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement("" +
                    "SELECT `login_attempts` FROM user_management.login_details where user_name=? order by id desc limit 1;");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int login_attempts = resultSet.getInt("login_attempts");
                user.setLoginAttempts(login_attempts);
                return login_attempts;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }



}