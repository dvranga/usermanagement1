package com.bridgelabz.usermanagement.dao;

import com.bridgelabz.usermanagement.configurations.DataBaseConfiguration;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationGraphDetails {

    static DataBaseConfiguration connection = new DataBaseConfiguration();

    public static List AllTimeRegistration() {
        List<Integer> graphValues=new ArrayList<>(6);
        try {
            PreparedStatement preparedStatement1 = connection.getConnection().prepareStatement("" +
                    " select count(*)as members from (SELECT EXTRACT(YEAR_MONTH FROM creator_stamp )\n" +
                    "FROM user_management.user_details\n" +
                    "where EXTRACT(YEAR_MONTH FROM creator_stamp ) between 201908 and 201912)AS derived;");
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            if(resultSet1.next()){
                graphValues.add(resultSet1.getInt("members"));
            }
            PreparedStatement preparedStatement2 = connection.getConnection().prepareStatement("" +
                    " select count(*)as members from (SELECT EXTRACT(YEAR_MONTH FROM creator_stamp )\n" +
                    "FROM user_management.user_details\n" +
                    "where EXTRACT(YEAR_MONTH FROM creator_stamp ) between 202000 and 202001)AS derived;");
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            if(resultSet2.next()){
                graphValues.add(resultSet2.getInt("members"));
            }

            PreparedStatement preparedStatement3 = connection.getConnection().prepareStatement("" +
                    " select count(*)as members from (SELECT EXTRACT(YEAR_MONTH FROM creator_stamp )\n" +
                    "FROM user_management.user_details\n" +
                    "where EXTRACT(YEAR_MONTH FROM creator_stamp ) between 202002 and 202003)AS derived;");
            ResultSet resultSet3 = preparedStatement3.executeQuery();
            if(resultSet3.next()){
                graphValues.add(resultSet3.getInt("members"));
            }


            PreparedStatement preparedStatement4 = connection.getConnection().prepareStatement("" +
                    " select count(*)as members from (SELECT EXTRACT(YEAR_MONTH FROM creator_stamp )\n" +
                    "FROM user_management.user_details\n" +
                    "where EXTRACT(YEAR_MONTH FROM creator_stamp ) between 202004 and 202005)AS derived;");
            ResultSet resultSet4 = preparedStatement4.executeQuery();
            if(resultSet4.next()){
                graphValues.add(resultSet4.getInt("members"));
            }
            PreparedStatement preparedStatement5 = connection.getConnection().prepareStatement("" +
                    " select count(*)as members from (SELECT EXTRACT(YEAR_MONTH FROM creator_stamp )\n" +
                    "FROM user_management.user_details\n" +
                    "where EXTRACT(YEAR_MONTH FROM creator_stamp ) between 202006 and 202007)AS derived;");
            ResultSet resultSet5 = preparedStatement5.executeQuery();
            if(resultSet5.next()){
                graphValues.add(resultSet5.getInt("members"));
            }
            PreparedStatement preparedStatement6 = connection.getConnection().prepareStatement("" +
                    " select count(*)as members from (SELECT EXTRACT(YEAR_MONTH FROM creator_stamp )\n" +
                    "FROM user_management.user_details\n" +
                    "where EXTRACT(YEAR_MONTH FROM creator_stamp ) between 202008 and 202009)AS derived;");
            ResultSet resultSet6= preparedStatement6.executeQuery();
            if(resultSet6.next()){
                graphValues.add(resultSet6.getInt("members"));
            }

            return graphValues;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return graphValues;
    }

    public static List getMonthWise() {
        List<Integer> graphValues=new ArrayList<>(6);
        try {
            PreparedStatement preparedStatement1 = connection.getConnection().prepareStatement("" +
                    " select count(*)As members from ( select EXTRACT(day FROM creator_stamp )\n" +
                    "FROM user_management.user_details\n" +
                    "where EXTRACT(month FROM creator_stamp )=09 and EXTRACT(day FROM creator_stamp ) between 1 and 5) As derived;");
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            if(resultSet1.next()){
                graphValues.add(resultSet1.getInt("members"));
            }
            PreparedStatement preparedStatement2 = connection.getConnection().prepareStatement("" +
                    "select count(*)As members from ( select EXTRACT(day FROM creator_stamp )\n" +
                    "FROM user_management.user_details\n" +
                    "where EXTRACT(month FROM creator_stamp )=09 and EXTRACT(day FROM creator_stamp ) between 6 and 10) As derived;");
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            if(resultSet2.next()){
                graphValues.add(resultSet2.getInt("members"));
            }

            PreparedStatement preparedStatement3 = connection.getConnection().prepareStatement("" +
                    " select count(*)As members from ( select EXTRACT(day FROM creator_stamp )\n" +
                    "FROM user_management.user_details\n" +
                    "where EXTRACT(month FROM creator_stamp )=09 and EXTRACT(day FROM creator_stamp ) between 11 and 15) As derived;");
            ResultSet resultSet3 = preparedStatement3.executeQuery();
            if(resultSet3.next()){
                graphValues.add(resultSet3.getInt("members"));
            }


            PreparedStatement preparedStatement4 = connection.getConnection().prepareStatement("" +
                    " select count(*)As members from ( select EXTRACT(day FROM creator_stamp )\n" +
                    "FROM user_management.user_details\n" +
                    "where EXTRACT(month FROM creator_stamp )=09 and EXTRACT(day FROM creator_stamp ) between 16 and 20) As derived;");
            ResultSet resultSet4 = preparedStatement4.executeQuery();
            if(resultSet4.next()){
                graphValues.add(resultSet4.getInt("members"));
            }
            PreparedStatement preparedStatement5 = connection.getConnection().prepareStatement("" +
                    " select count(*)As members from ( select EXTRACT(day FROM creator_stamp )\n" +
                    "FROM user_management.user_details\n" +
                    "where EXTRACT(month FROM creator_stamp )=09 and EXTRACT(day FROM creator_stamp ) between 21 and 25) As derived;");
            ResultSet resultSet5 = preparedStatement5.executeQuery();
            if(resultSet5.next()){
                graphValues.add(resultSet5.getInt("members"));
            }
            PreparedStatement preparedStatement6 = connection.getConnection().prepareStatement("" +
                    " select count(*)As members from ( select EXTRACT(day FROM creator_stamp )\n" +
                    "FROM user_management.user_details\n" +
                    "where EXTRACT(month FROM creator_stamp )=09 and EXTRACT(day FROM creator_stamp ) between 26 and 30) As derived;");
            ResultSet resultSet6= preparedStatement6.executeQuery();
            if(resultSet6.next()){
                graphValues.add(resultSet6.getInt("members"));
            }
            return graphValues;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return graphValues;
    }
    public static List getYearWise() {
        List<Integer> graphValues=new ArrayList<>(6);
        try {
            PreparedStatement preparedStatement1 = connection.getConnection().prepareStatement("" +
                    " select count(*)As members from ( select EXTRACT(month FROM creator_stamp )\n" +
                    "FROM user_management.user_details\n" +
                    "where EXTRACT(month FROM creator_stamp )=09 ) As derived;");
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            if(resultSet1.next()){
                graphValues.add(resultSet1.getInt("members"));
            }
            PreparedStatement preparedStatement2 = connection.getConnection().prepareStatement("" +
                    "select count(*)As members from ( select EXTRACT(month FROM creator_stamp )\n" +
                    "FROM user_management.user_details\n" +
                    "where EXTRACT(month FROM creator_stamp )=08 ) As derived;");
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            if(resultSet2.next()){
                graphValues.add(resultSet2.getInt("members"));
            }

            PreparedStatement preparedStatement3 = connection.getConnection().prepareStatement("" +
                    " select count(*)As members from ( select EXTRACT(month FROM creator_stamp )\n" +
                    "FROM user_management.user_details\n" +
                    "where EXTRACT(month FROM creator_stamp )=07 ) As derived;");
            ResultSet resultSet3 = preparedStatement3.executeQuery();
            if(resultSet3.next()){
                graphValues.add(resultSet3.getInt("members"));
            }


            PreparedStatement preparedStatement4 = connection.getConnection().prepareStatement("" +
                    "select count(*)As members from ( select EXTRACT(month FROM creator_stamp )\n" +
                    "FROM user_management.user_details\n" +
                    "where EXTRACT(month FROM creator_stamp ) between 5 and 6 ) As derived;");
            ResultSet resultSet4 = preparedStatement4.executeQuery();
            if(resultSet4.next()){
                graphValues.add(resultSet4.getInt("members"));
            }
            PreparedStatement preparedStatement5 = connection.getConnection().prepareStatement("" +
                    " select count(*)As members from ( select EXTRACT(month FROM creator_stamp )\n" +
                    "FROM user_management.user_details\n" +
                    "where EXTRACT(month FROM creator_stamp ) between 3 and 4 ) As derived;");
            ResultSet resultSet5 = preparedStatement5.executeQuery();
            if(resultSet5.next()){
                graphValues.add(resultSet5.getInt("members"));
            }
            PreparedStatement preparedStatement6 = connection.getConnection().prepareStatement("" +
                    " select count(*)As members from ( select EXTRACT(month FROM creator_stamp )\n" +
                    "FROM user_management.user_details\n" +
                    "where EXTRACT(month FROM creator_stamp ) between 1 and 2 ) As derived;");
            ResultSet resultSet6= preparedStatement6.executeQuery();
            if(resultSet6.next()){
                graphValues.add(resultSet6.getInt("members"));
            }
            return graphValues;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return graphValues;
    }

    public  static List<String> getLabel(String data){
        List<String> yearLabels=new ArrayList<>();
        yearLabels.add("Sep.2020");
        yearLabels.add("Aug.2020");
        yearLabels.add("Jul.2020");
        yearLabels.add("May.2020");
        yearLabels.add("Mar.2020");
        yearLabels.add("Jan.2020");
        List<String> allTimeLabels=new ArrayList<>();
        allTimeLabels.add("Sep.2020");
        allTimeLabels.add("Jul.2020");
        allTimeLabels.add("May.2020");
        allTimeLabels.add("Mar.2020");
        allTimeLabels.add("Dec.2019");
        allTimeLabels.add("Sep.2019");
        List<String> monthLabels=new ArrayList<>();
        monthLabels.add("0-5Days");
        monthLabels.add("6-10Days");
        monthLabels.add("11-15days");
        monthLabels.add("16-20Days");
        monthLabels.add("20-25Days");
        monthLabels.add("25-30Days");
        if(data.equals("year")){
            return yearLabels;
        }else if(data.equals("month")){
            return monthLabels;
        }else if(data.equals("allTime")){
            return allTimeLabels;
        }

        return allTimeLabels;
    }



}