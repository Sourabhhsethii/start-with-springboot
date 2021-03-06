package com.upgrad.movieapp.entities.mongo;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class CustomerMongoEnitity {

    @Id
    private int customerId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private LocalDateTime dateofBirth;

    public CustomerMongoEnitity() {
    }

    public CustomerMongoEnitity(int customerId, String firstName, String lastName, String userName, String password, LocalDateTime dateofBirth) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.dateofBirth = dateofBirth;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(LocalDateTime dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    @Override
    public String toString() {
        return "CustomerMongoEnitity{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", dateofBirth=" + dateofBirth +
                '}';
    }
}
