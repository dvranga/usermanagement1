package com.bridgelabz.usermanagement.dao;

import com.bridgelabz.usermanagement.configurations.DataBaseConfiguration;
import com.bridgelabz.usermanagement.model.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;

public class UserListDAO {

    public  static ArrayList<User> getUserList(){
        ArrayList<User> userList=new ArrayList<>();
        DataBaseConfiguration connection=new DataBaseConfiguration();
        try {
            PreparedStatement preparedStatement=connection.getConnection().prepareStatement("" +
                    "select * from user_details");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
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
                user.setStatus(resultSet.getBoolean("status")==true?"Active":"InActive");
                user.setRoleId(resultSet.getInt("role_id"));
                Blob image = resultSet.getBlob("image");
                java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Timestamp creator_stamp = resultSet.getTimestamp("creator_stamp");
                user.setCreator_stamp((getRestrationTime(dateFormat.format(creator_stamp))));
                String creator_user = resultSet.getString("creator_user");
                user.setCreator_user(creator_user);
                InputStream inputStream=image.getBinaryStream();
                ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
                byte[] buffer=new byte[4096];
                int bytesRead=-1;
                while ((bytesRead=inputStream.read(buffer))!=-1){
                    outputStream.write(buffer,0,bytesRead);
                }
                byte[] imagebytes=outputStream.toByteArray();
                user.setImage(Base64.getEncoder().encodeToString(imagebytes));
                inputStream.close();
                outputStream.close();
                userList.add(user);
            }
            return userList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return userList;
    }
    public static String getRestrationTime(String time){
        String result ="";
        HashMap<String, String> months=new HashMap<>();
        months.put("01","Jan");
        months.put("02","Feb");
        months.put("03","Mar");
        months.put("04","Apr");
        months.put("05","May");
        months.put("06","Jun");
        months.put("07","July");
        months.put("08","Aug");
        months.put("09","Sep");
        months.put("10","Oct");
        months.put("11","Nov");
        months.put("12","Dec");
        char[] timeArray = time.toCharArray();
        result=months.get(timeArray[5] + String.valueOf(timeArray[6]))+" ";
        result+=time.substring(8,10)+" ";
        result+=time.substring(0,4)+" ";
        int hours = Integer.parseInt(time.substring(11, 13));
        if(hours>12){
            hours=hours-12;
            result+=hours;
            result+=time.substring(13,16)+"PM";

        }
        else {
            result+=hours+time.substring(13,16)+"AM";
        }

        return result;
    }
}
