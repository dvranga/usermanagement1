package com.bridgelabz.usermanagement.model;

public class Location {
    private String countryName;
    private int usersCount;

    public Location(String countryName, int usersCount) {
        this.countryName = countryName;
        this.usersCount = usersCount;
    }

    public String getCountryName() {
        return countryName;
    }


    public int getUsersCount() {
        return usersCount;
    }

    @Override
    public String toString() {
        return "Location{" +
                "countryName='" + countryName + '\'' +
                ", usersCount=" + usersCount +
                '}';
    }
}