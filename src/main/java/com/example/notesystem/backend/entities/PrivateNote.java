package com.example.notesystem.backend.entities;


import javax.persistence.*;

@Entity
@Table(name= "PRIVATENOTE")
public class PrivateNote {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PRIVATE_ID", nullable = false)
    private long privateId;
    @Column(name="NAME",nullable = false)
    private String privateNoteName;
    @Column(name="USER_ID", nullable = false)
    private String userId;
    @Column(name="SUBJECT_ID")
    private String subjectId;
    @Lob // define as large object
    @Column(name="CONTENT", columnDefinition = "CLOB", nullable = false) //character lob
    private String content;

    //getters and setters
    public void setPrivateNoteName(String privateNoteName) {
        this.privateNoteName = privateNoteName;
    }

    public String getPrivateNoteName() {
        return privateNoteName;
    }

    public void setPrivateId(long privateId) {
        this.privateId = privateId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getPrivateId() {
        return privateId;
    }

    public String getUserId() {
        return userId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getContent() {
        return content;
    }
}
