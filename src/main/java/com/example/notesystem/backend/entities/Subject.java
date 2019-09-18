package com.example.notesystem.backend.entities;


import javax.persistence.*;

@Entity
@Table(name= "SUBJECT")
public class Subject {

    //the only column is the pk and subject itself
    @Id
    @Column(name="SUBJECT_ID", nullable = false)
    private long subjectId;
    @Column(name="NAME", nullable = false)
    private String subjectName;

    //getters and setters
    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }


    public String getSubjectName() {
        return subjectName;
    }

    public long getSubjectId() {
        return subjectId;
    }
}
