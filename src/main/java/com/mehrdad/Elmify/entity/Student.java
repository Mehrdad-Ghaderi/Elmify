package com.mehrdad.Elmify.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Student {

    @Id
    @NotNull
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
    @NotNull
    @Size(min=1, max=45)
    @Column(name = "first_name")
    private String firstName;
    @NotNull
    @Size(min=1, max=45)
    @Column(name = "last_name")
    private String lastName;
    @NotNull
    @Email
    @Size(min=1, max=45)
    @Column(name = "email")
    private String email;
    @NotNull
    @Size(min=1, max=45)
    @Column(name = "phone_number")
    private String phoneNumber;
    @NotNull
    @Size(min=1, max=45)
    @Column(name = "username")
    private String username;
    @NotNull
    @Size(min=1, max=45)
    @Column(name = "password")
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
