package com.example.notesystem.business.domains;

//this domain is used when the user is browsing notes based on subject. it will temporarily access and store all notes
//within a given subject.
public class SubjectProfile {
    private long id;
    private String name;
    private long[] privateNotes;
    private long[] publicNotes;


    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrivateNotes(long[] privateNotes) {
        this.privateNotes = privateNotes;
    }

    public void setPublicNotes(long[] publicNotes) {
        this.publicNotes = publicNotes;
    }


    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public long[] getPrivateNotes() {
        return this.privateNotes;
    }

    public long[] getPublicNotes() {
        return this.publicNotes;
    }
}
