package com.bridgelabz.usermanagement.configurations;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConfiguration {

    public Connection getConnection() throws IOException, SQLException, ClassNotFoundException, IllegalAccessException {

        Properties props = new Properties();
      FileInputStream inputStream = new FileInputStream("C:\\Users\\Heros\\Desktop\\usermanagement\\New folder\\UserManagement-master\\src\\main\\webapp\\resource\\db.properties");
        props.load(inputStream);

        String driver = props.getProperty("jdbc.driver");
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        Connection connection=null;
        try {

            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(url , username, password);
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return connection;
    }
}