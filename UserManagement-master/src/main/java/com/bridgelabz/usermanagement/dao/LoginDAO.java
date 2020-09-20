package com.bridgelabz.usermanagement.dao;

import com.bridgelabz.usermanagement.configurations.DataBaseConfiguration;
import com.bridgelabz.usermanagement.model.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;

public class LoginDAO {

    int count=0;
    public static ArrayList  getPermissions(int userId, int menuId){
        DataBaseConfiguration connection= new DataBaseConfiguration();
        ArrayList permissionList=new ArrayList(4);
        try {
            PreparedStatement preparedStatement=connection.getConnection().prepareStatement("select  * from user_permissions where user_id=? and web_page_id=?");
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2,menuId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                permissionList.add(resultSet.getInt("add")==1?true:false);
                permissionList.add(resultSet.getInt("delete")==1?true:false);
                permissionList.add(resultSet.getInt("modify")==1?true:false);
                permissionList.add(resultSet.getInt("read")==1?true:false);
            }
            return permissionList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static User validate(String username,String password) {
        DataBaseConfiguration connection=new DataBaseConfiguration();
        int id=0;
        User user=null;
        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement("select * from user_details where user_name=? and password=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet= preparedStatement.executeQuery();
            if(resultSet.next()){
                 user=new User();
                user.setUser_id(resultSet.getInt("user_id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setMiddleName(resultSet.getString("middle_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setUserName(resultSet.getString("user_name"));
                user.setRoleId(resultSet.getInt("role_id"));
                Blob image = resultSet.getBlob("image");
                InputStream binaryStream = image.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] bytes = new byte[4096];
                int byteRead=-1;
                while ((byteRead = binaryStream.read(bytes)) != -1) {
                    outputStream.write(bytes,0,byteRead);
                }
                byte[] toByteArray = outputStream.toByteArray();
                user.setImage(Base64.getEncoder().encodeToString(toByteArray));
            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }
    public static User getUserDetailsByUserId(int userId) {
        DataBaseConfiguration connection = new DataBaseConfiguration();
        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement("select * from user_details where user_id=?");
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user=new User();
                user.setUser_id(resultSet.getInt("user_id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setMiddleName(resultSet.getString("middle_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setDateOfBirth(resultSet.getDate("date_of_birth"));
                user.setGender(resultSet.getString("gender"));
                user.setCountry(resultSet.getString("country"));
                user.setMobileNumber(resultSet.getLong("phone"));
                user.setParentNumber(resultSet.getLong("phone_ext"));
                user.setEmail(resultSet.getString("email"));
                user.setAddress(resultSet.getString("address"));
                user.setUserName(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));
                user.setRoleId(resultSet.getInt("role_id"));
                Blob image = resultSet.getBlob("image");
                InputStream inputStream=image.getBinaryStream();
                ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
                byte[] buffer=new byte[4096];
                int bytesRead=-1;
                while ((bytesRead=inputStream.read(buffer))!=-1){
                    outputStream.write(buffer,0,bytesRead);
                }
                byte[] imagebytes=outputStream.toByteArray();
                user.setImage(Base64.getEncoder().encodeToString(imagebytes));

                return user;
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
        return null;
    }


}
