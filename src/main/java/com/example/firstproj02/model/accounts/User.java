package com.example.firstproj02.model.accounts;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.beans.property.StringProperty;

abstract public class User {
    private final String userName;
    private String email;
    private String phoneNumber;
    private String password;
    private String firstName;
    private String lastName;
    private BooleanProperty isLoggedIn;

    public User(String userName, String email, String phoneNumber, String password) {
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        isLoggedIn=new BooleanPropertyBase() {
            @Override
            public Object getBean() {
                return false;
            }

            @Override
            public String getName() {
                return "false";
            }
        };
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BooleanProperty getIsLoggedIn(){
        return isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn){
        this.isLoggedIn.set(isLoggedIn);
    }

    @Override
    public String toString() {
        return "\nuser name: " + userName + "\nemail: " + email + "\nphone number: " + phoneNumber;
    }
}
