package com.example.notesystem.business.services;

import com.example.notesystem.backend.entities.PublicNote;
import com.example.notesystem.backend.entities.Subject;
import com.example.notesystem.business.domains.SubjectProfile;
import com.example.notesystem.backend.repositories.PrivateNoteRepository;
import com.example.notesystem.backend.repositories.PublicNoteRepository;
import com.example.notesystem.backend.repositories.SubjectRepository;
import com.example.notesystem.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SubjectService {
    private UserRepository userRepository;
    private PrivateNoteRepository privateNoteRepository;
    private PublicNoteRepository publicNoteRepository;
    private SubjectRepository subjectRepository;
    //constructor for the service class

    @Autowired
    public SubjectService(UserRepository userRepository, PrivateNoteRepository privateNoteRepository, PublicNoteRepository publicNoteRepository, SubjectRepository subjectRepository) {
        this.userRepository = userRepository;
        this.privateNoteRepository = privateNoteRepository;
        this.publicNoteRepository = publicNoteRepository;
        this.subjectRepository = subjectRepository;
    }

    //create service for getting subjects and their respective public notes and storing them in a temporary subject profile
    public SubjectProfile getSubjectProfile() {

        //find all existing subjects and public notes
        Iterable<Subject> subjects = this.subjectRepository.findAll();
        Iterable<PublicNote> publicNotes = this.publicNoteRepository.findAll();

        //create new subject profile
        SubjectProfile subjectProfile = new SubjectProfile();

        //for each subject in all subjects, set the current subject profile id and name equal to the subject id and name
        subjects.forEach(subject ->{
            subjectProfile.setId(subject.getSubjectId());
            subjectProfile.setName(subject.getSubjectName());
        });

        //store the public notes of the same subject in the subject profile
        //for each public note in the public notes arraylist, check if the subject id is equal to the current subject profile id
        //if they are equal, then add the public note name to a temp arralist filteredNotes
        //finally, set subject profile publicNotes arraylist to filtereNotes.
        publicNotes.forEach(publicNote -> {
            ArrayList<String> filteredNotes = new ArrayList<String>();
            if(publicNote.getSubjectId() == subjectProfile.getId()){
                filteredNotes.add(publicNote.getPublicNoteName());
            }
            subjectProfile.setPublicNotes(filteredNotes);
        });

        return subjectProfile;
    }

}
