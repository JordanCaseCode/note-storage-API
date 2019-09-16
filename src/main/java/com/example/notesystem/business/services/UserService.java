package com.example.notesystem.business.services;

import com.example.notesystem.business.domains.UserProfile;
import com.example.notesystem.backend.repositories.PrivateNoteRepository;
import com.example.notesystem.backend.repositories.PublicNoteRepository;
import com.example.notesystem.backend.repositories.SubjectRepository;
import com.example.notesystem.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
//service class created to separate concerns between the repository and the API.
//holds the business logic for queries and data gather
@Service
public class UserService {

    private UserRepository userRepository;
    private PrivateNoteRepository privateNoteRepository;
    private PublicNoteRepository publicNoteRepository;
    private SubjectRepository subjectRepository;
    //constructor for the service class
    @Autowired
    public UserService(UserRepository userRepository, PrivateNoteRepository privateNoteRepository, PublicNoteRepository publicNoteRepository, SubjectRepository subjectRepository) {
        this.userRepository = userRepository;
        this.privateNoteRepository = privateNoteRepository;
        this.publicNoteRepository = publicNoteRepository;
        this.subjectRepository = subjectRepository;
    }

    //create service for getting database
    public UserProfile getUserProfile(String authString) {
        String userInfo = decodeAuthenticationString(authString);
        if(userInfo == null) {
            return null; //error!!  may need to throw 404 error
        }

        //:TODO separate username:password to check user table to getback user



    }

    //Decoding class to separate the authentication string sent as a standard http basic authentication header
    //string is of form username:password
    private String decodeAuthenticationString(String authString){

        String decodedAuth = "";
        // Header is in the format "Basic 5tyc0uiDat4"
        // We need to extract data before decoding it back to original string
        String[] authParts = authString.split("\\s+");
        String authInfo = authParts[1];
        // Decode the data back to original string
        byte[] bytes = null;
        try {
            bytes =  Base64.getDecoder().decode(authInfo); //decode the authorization header info
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        decodedAuth = new String(bytes);
        System.out.println(decodedAuth);
        if(decodedAuth != null) {
            return decodedAuth;
        }
        return null; //didn't work or string is not there

    }

}
