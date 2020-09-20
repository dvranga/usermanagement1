package com.bridgelabz.usermanagement.dao;

import com.bridgelabz.usermanagement.configurations.DataBaseConfiguration;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgeGroupData {

    static DataBaseConfiguration connection = new DataBaseConfiguration();

    public static List getAgedata() {
        List<Integer> ageList=new ArrayList<>(7);
        try {
            PreparedStatement preparedStatement1 = connection.getConnection().prepareStatement("" +
                    "select count(*) as members from (select TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE())\n" +
                    "from user_details\n" +
                    "where TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) between 18 and 22)AS derived;");
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            if(resultSet1.next()){
                ageList.add(resultSet1.getInt("members"));
            }
            PreparedStatement preparedStatement2 = connection.getConnection().prepareStatement("" +
                    "select count(*) as members from (select TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE())\n" +
                    "from user_details\n" +
                    "where TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) between 23 and 27)AS derived;");
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            if(resultSet2.next()){
                ageList.add(resultSet2.getInt("members"));
            }

            PreparedStatement preparedStatement3 = connection.getConnection().prepareStatement("" +
                    "select count(*) as members from (select TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE())\n" +
                    "from user_details\n" +
                    "where TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) between 28 and 32)AS derived;");
            ResultSet resultSet3 = preparedStatement3.executeQuery();
            if(resultSet3.next()){
                ageList.add(resultSet3.getInt("members"));
            }


            PreparedStatement preparedStatement4 = connection.getConnection().prepareStatement("" +
                    "select count(*) as members from (select TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE())\n" +
                    "from user_details\n" +
                    "where TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) between 33 and 37)AS derived;");
            ResultSet resultSet4 = preparedStatement4.executeQuery();
            if(resultSet4.next()){
                ageList.add(resultSet4.getInt("members"));
            }

            PreparedStatement preparedStatement5 = connection.getConnection().prepareStatement("" +
                    "select count(*) as members from (select TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE())\n" +
                    "from user_details\n" +
                    "where TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) between 38 and 42)AS derived;");
            ResultSet resultSet5 = preparedStatement5.executeQuery();
            if(resultSet5.next()){
                ageList.add(resultSet5.getInt("members"));
            }
            PreparedStatement preparedStatement6 = connection.getConnection().prepareStatement("" +
                    "select count(*) as members from (select TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE())\n" +
                    "from user_details\n" +
                    "where TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) > 42)AS derived;");
            ResultSet resultSet6 = preparedStatement6.executeQuery();
            if(resultSet6.next()){
                ageList.add(resultSet6.getInt("members"));
            }
            PreparedStatement preparedStatement7 = connection.getConnection().prepareStatement("" +
                    "select count(*) as members from (select TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE())\n" +
                    "from user_details\n" +
                    "where TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) < 18)AS derived;");
            ResultSet resultSet7 = preparedStatement7.executeQuery();
            if(resultSet7.next()){
                ageList.add(resultSet7.getInt("members"));
            }
            return ageList;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ageList;
    }
}