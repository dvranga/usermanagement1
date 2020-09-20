package com.bridgelabz.usermanagement.dao;

import com.bridgelabz.usermanagement.configurations.DataBaseConfiguration;
import com.bridgelabz.usermanagement.model.Location;
import com.bridgelabz.usermanagement.model.User;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DashboardDAO {
    static ArrayList<User> listOfUsers = UserListDAO.getUserList();

    public static int getNoRecords() {
        return listOfUsers.size();
    }

    public static int getActiveRecords() {
        return (int) listOfUsers.stream().filter((user) -> user.getStatus().equals("Active")).count();
    }

    public static int getInActiveRecords() {
        return (int) listOfUsers.stream().filter((user) -> user.getStatus().equals("InActive")).count();
    }


    public static double getMalePercentage() {
        double count = listOfUsers.stream().filter((user) -> user.getGender().equals("M")).count();
        double size = Double.valueOf(listOfUsers.size());
        double result = (count / size) * 100;
        result = Math.floor(result * 10) / 10;
        return result;
    }

    public static double getFemalePercentage() {
        double result = 100.00 - getMalePercentage();
        result = Math.floor(result * 10) / 10;
        return result;
    }

    public static List<Location> getTopLocations() {

        List<Location> topLocation = new ArrayList<>();
        topLocation.add(new Location("India", (int) listOfUsers.stream().filter((user) -> user.getCountry().equals("India")).count()));
        topLocation.add(new Location("Pakistan", (int) listOfUsers.stream().filter((user) -> user.getCountry().equals("Russia")).count()));
        topLocation.add(new Location("America", (int) listOfUsers.stream().filter((user) -> user.getCountry().equals("America")).count()));
        topLocation.add(new Location("England", (int) listOfUsers.stream().filter((user) -> user.getCountry().equals("England")).count()));
        topLocation.add(new Location("Australia", (int) listOfUsers.stream().filter((user) -> user.getCountry().equals("Australia")).count()));
        topLocation.add(new Location("Srilanka", (int) listOfUsers.stream().filter((user) -> user.getCountry().equals("Srilanka")).count()));
        topLocation = topLocation.stream().sorted((location1, location2) -> location2.getUsersCount() - location1.getUsersCount()).collect(Collectors.toList());
        return topLocation;
    }

    public static String getLastLoggedInDetails(int userId) throws IllegalAccessException, ClassNotFoundException {
        DataBaseConfiguration connection=new DataBaseConfiguration();

        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement("" +
                    "SELECT login_history FROM user_management.login_details where userId=? order by id desc limit 1;");
            java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Timestamp login_history = resultSet.getTimestamp("login_history");
                return UserListDAO.getRestrationTime(dateFormat.format(login_history));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}