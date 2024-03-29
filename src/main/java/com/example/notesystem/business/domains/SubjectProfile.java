package com.example.notesystem.business.domains;

import java.util.ArrayList;

//this domain is used when the user is browsing notes based on subject. it will temporarily access and store all notes
//within a given subject.
public class SubjectProfile {
    private long id;
    private String name;
    private ArrayList<String> publicNotes;


    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublicNotes(ArrayList<String> publicNotes) {
        this.publicNotes = publicNotes;
    }


    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<String> getPublicNotes() {
        return this.publicNotes;
    }
}
