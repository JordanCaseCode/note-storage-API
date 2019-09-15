package com.example.notesystem.backend.entities;


import javax.persistence.*;

@Entity
@Table(name="USER") // slight redundancy to keep capitalization uniform and prevent potential errors
public class User {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="USER_ID", nullable = false)
    private long id;
    @Column(name="FIRST_NAME", nullable = false)
    private String firstName;
    @Column(name="LAST_NAME", nullable = false)
    private String lastName;
    @Column(name="USERNAME", nullable = false)
    private String userName;
    @Column(name="EMAIL", nullable = false)
    private String email;
    @Column(name="HASHED_PASSWORD", nullable = false)
    private String hashedPassword;

    //Create all setters and getters for each column value

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }
}
