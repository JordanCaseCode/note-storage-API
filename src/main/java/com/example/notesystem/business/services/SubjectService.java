package com.example.notesystem.business.services;

import com.example.notesystem.backend.entities.Subject;
import com.example.notesystem.business.domains.SubjectProfile;
import com.example.notesystem.backend.repositories.PrivateNoteRepository;
import com.example.notesystem.backend.repositories.PublicNoteRepository;
import com.example.notesystem.backend.repositories.SubjectRepository;
import com.example.notesystem.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    //create service for getting database
    public SubjectProfile getSubjectProfile() {
        Iterable subjects = this.subjectRepository.findAll();
        SubjectProfile currentSubject = new SubjectProfile();

        subjects.forEach((subject)->{
            subject.getSubjectId();
        });
    }

}
