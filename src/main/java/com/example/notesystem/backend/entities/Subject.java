package com.example.notesystem.backend.entities;


import javax.persistence.*;

@Entity
@Table(name= "SUBJECT")
public class Subject {
    //the only column is the pk and subject itself
    @Id
    @Column(name="SUBJECT_ID", nullable = false)
    private String subjectId;

    //getters and setters
    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectId() {
        return subjectId;
    }
}
