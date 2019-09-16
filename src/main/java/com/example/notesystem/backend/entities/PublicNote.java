package com.example.notesystem.backend.entities;


import javax.persistence.*;

@Entity
@Table(name= "PUBLICNOTE")
public class PublicNote {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PUBLIC_ID", nullable = false)
    private long publicId;
    @Column(name="NAME",nullable = false)
    private String publicNoteName;
    @Column(name="USER_ID", nullable = false)
    private String userId;
    @Column(name="SUBJECT_ID", nullable = false)
    private String subjectId;
    @Lob // define as large object
    @Column(name="CONTENT", columnDefinition = "CLOB", nullable = false) //character lob
    private String content;

    //getters and setters


    public void setPublicNoteName(String publicNoteName) {
        this.publicNoteName = publicNoteName;
    }

    public String getPublicNoteName() {
        return publicNoteName;
    }

    public void setPublicId(long publicId) {
        this.publicId = publicId;
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

    public long getPublicId() {
        return publicId;
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
