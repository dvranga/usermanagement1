package com.bridgelabz.usermanagement.dao;

import com.bridgelabz.usermanagement.configurations.DataBaseConfiguration;
import com.bridgelabz.usermanagement.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateUserDAO {

    DataBaseConfiguration connection=new DataBaseConfiguration();

    public  static void setStatus(String username, Boolean aBoolean) throws IllegalAccessException, ClassNotFoundException {

        DataBaseConfiguration connection=new DataBaseConfiguration();
        try {
            PreparedStatement preparedStatement=connection.getConnection().prepareStatement("" +
                    "UPDATE `user_management`.`user_details` SET  `status` = ? WHERE `user_name`=?;");
            preparedStatement.setBoolean(1,aBoolean);
            preparedStatement.setString(2,username);
            int resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean updatePermissions(int userId, int menuId, boolean add, boolean delete, boolean modify, boolean read) throws IllegalAccessException, ClassNotFoundException {

        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement("" +
                    "UPDATE `user_management`.`user_permissions` SET  `add` = ?, `delete` = ?, `modify` = ?, `read` = ? WHERE `user_id` = ? AND `web_page_id`=?;");
            preparedStatement.setBoolean(1, add);
            preparedStatement.setBoolean(2, delete);
            preparedStatement.setBoolean(3, modify);
            preparedStatement.setBoolean(4,read);
            preparedStatement.setInt(5, userId);
            preparedStatement.setInt(6, menuId);
            int result = preparedStatement.executeUpdate();
            return (result!=0);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateUser(User user, InputStream image, int user_id) throws IllegalAccessException, ClassNotFoundException {
        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement("" +
                    "UPDATE  `user_management`.`user_details`  SET `first_name` = ?, `middle_name`=?,`last_name`=?, `date_of_birth`=?, `gender`=?, `country`=?, `phone`=?, `phone_ext`=?, `email`=?, `address`=?, `user_name`=?, `password`=?, `role_id`=?, `image`=? WHERE user_id=?;");
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getMiddleName());
            preparedStatement.setString(3,user.getLastName());
            preparedStatement.setDate(4,user.getDateOfBirth());
            preparedStatement.setString(5,user.getGender());
            preparedStatement.setString(6,user.getCountry());
            preparedStatement.setLong(7,user.getMobileNumber());
            preparedStatement.setLong(8,user.getParentNumber());
            preparedStatement.setString(9,user.getEmail());
            preparedStatement.setString(10,user.getAddress());
            preparedStatement.setString(11,user.getUserName());
            preparedStatement.setString(12,user.getPassword());
            preparedStatement.setInt(13,user.getRoleId());
            preparedStatement.setBlob(14,image);
            preparedStatement.setInt(15,user_id);
            int result = preparedStatement.executeUpdate();
            return (result!=0);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


}
