package com.bridgelabz.usermanagement.dao;

import com.bridgelabz.usermanagement.configurations.DataBaseConfiguration;
import com.bridgelabz.usermanagement.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AddUserDAO {

    DataBaseConfiguration connection=new DataBaseConfiguration();

    public boolean addPermissions(int userId, int menuId, boolean add, boolean delete, boolean modify, boolean read){

        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement("" +
                    "INSERT INTO `user_management`.`user_permissions` (`user_id`, `web_page_id`, `add`, `delete`, `modify`, `read`) VALUES (?, ?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, menuId);
            preparedStatement.setBoolean(3, add);
            preparedStatement.setBoolean(4, delete);
            preparedStatement.setBoolean(5, modify);
            preparedStatement.setBoolean(6,read);
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

    public boolean addUser(User user, InputStream image, String creator_user){

        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement("" +
                    "INSERT INTO `user_management`.`user_details` (`first_name`, `middle_name`, `last_name`, `date_of_birth`, `gender`, `country`," +
                    " `phone`, `phone_ext`, `email`, `address`, `user_name`, `password`, `status`, `role_id`, `image`, `creator_stamp`, `creator_user`)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
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
            preparedStatement.setBoolean(13,true);
            preparedStatement.setInt(14,user.getRoleId());
            preparedStatement.setBlob(15,image);
            preparedStatement.setTimestamp(16, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setString(17,creator_user);

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
    public int getUserId(String userName) {
        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement("" +
                    "select user_id from user_details where user_name=?;");
            preparedStatement.setString(1, userName);
            ResultSet resultSet= preparedStatement.executeQuery();

            if(resultSet.next()) {
                return resultSet.getInt("user_id");
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
