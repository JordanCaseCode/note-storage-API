package com.example.notesystem.business.domains;

//business layer abstraction from the backend information
//this is for when a user logs in, to receive all notes that they made using the notes and send this to the client
public class UserProfile {
    private long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String[] publicNotes;
    private String[] privateNotes;


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

    public void setPublicNotes(String[] publicNotes) {
        this.publicNotes = publicNotes;
    }

    public void setPrivateNotes(String[] privateNotes) {
        this.privateNotes = privateNotes;
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

    public String[] getPublicNotes() {
        return publicNotes;
    }

    public String[] getPrivateNotes() {
        return privateNotes;
    }
}
