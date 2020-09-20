package com.bridgelabz.usermanagement.dao;

import com.bridgelabz.usermanagement.configurations.DataBaseConfiguration;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUserDAO {
    public  static boolean deleteUserPermissions(int userId){
        DataBaseConfiguration connection = new DataBaseConfiguration();
        try {
            PreparedStatement preparedStatement=connection.getConnection().prepareStatement("delete from user_permissions where user_id=?");
            preparedStatement.setInt(1, userId);
            int result = preparedStatement.executeUpdate();
            return (result!=0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
    public  static  boolean deleteUserDetails(int userId){
        DataBaseConfiguration connection = new DataBaseConfiguration();
        try {
            PreparedStatement preparedStatement=connection.getConnection().prepareStatement("delete from user_details where user_id=?");
            preparedStatement.setInt(1, userId);
            int result = preparedStatement.executeUpdate();
            return (result!=0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}
