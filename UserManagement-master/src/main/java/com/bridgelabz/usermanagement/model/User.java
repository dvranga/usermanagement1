package com.bridgelabz.usermanagement.model;


import java.sql.Date;
import java.sql.Timestamp;

public class User {
    private int user_id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String country;
    private long mobileNumber;
    private long parentNumber;
    private String email;
    private  String address;
    private String userName;
    private String password;
    private String status;
    private int roleId;
    private String image;
    private String creator_stamp;
    private int loginAttempts;

    public int getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(int loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public String getCreator_stamp() {
        return creator_stamp;
    }

    public void setCreator_stamp(String creator_stamp) {
        this.creator_stamp = creator_stamp;
    }

    public String getCreator_user() {
        return creator_user;
    }

    public void setCreator_user(String creator_user) {
        this.creator_user = creator_user;
    }

    private String creator_user;

    public String getStatus() {
        return status;
    }


    public User(String firstName, String middleName, String lastName, Date dateOfBirth, String gender, String country, Long mobileNumber, Long parentsNumber, String email, String address, int roleId, String userName,
                String password, String image) {
        this.firstName=firstName;
        this.middleName=middleName;
        this.lastName=lastName;
        this.dateOfBirth=dateOfBirth;
        this.gender=gender;
        this.country=country;
        this.mobileNumber=mobileNumber;
        this.parentNumber=parentsNumber;
        this.email=email;
        this.address=address;
        this.roleId = roleId;
        this.userName=userName;
        this.password=password;
        this.image=image;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setParentNumber(long parentNumber) {
        this.parentNumber = parentNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User() {

    }

    public String getImage() {
        return image;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public long getParentNumber() {
        return parentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public int getRoleId() {
        return roleId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }


    public int getUser_id() {
        return user_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", country='" + country + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", parentNumber=" + parentNumber +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", roleId=" + roleId +
                ", image='" + image + '\'' +
                ", creator_stamp='" + creator_stamp + '\'' +
                ", creator_user='" + creator_user + '\'' +
                '}';
    }
}


