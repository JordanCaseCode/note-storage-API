package com.example.notesystem.business.services;

import com.example.notesystem.backend.entities.PrivateNote;
import com.example.notesystem.backend.entities.User;
import com.example.notesystem.business.domains.UserProfile;
import com.example.notesystem.backend.repositories.PrivateNoteRepository;
import com.example.notesystem.backend.repositories.PublicNoteRepository;
import com.example.notesystem.backend.repositories.SubjectRepository;
import com.example.notesystem.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;
import java.util.Base64;
import java.util.Optional;
import java.util.OptionalInt;

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
        //check to see if the client sent anything for username:password
        String[] userInfo = decodeAuthenticationString(authString);
        //if empty, then they didn't send the correct thing
        if(userInfo == null) {
            return null; //error!!  may need to throw 404 error
        }
        //if they provided the user info, we will being assembling the userProfile domain to send back to them
        UserProfile userProfile = new UserProfile();
        //find the user by sending the username in first two params because it could be either the username or the email of the user
        //the send string in userInfo should be the password
        Optional<User>  user = userRepository.findByUserNameOrEmailAndHashedPassword(userInfo[0],userInfo[0],userInfo[1]);
        if(!user.isPresent()) {
            //user doesn't exist, we need to throw a 404 error
            return null;
        }
        //set-up profile.... there might be a faster way to do this
        userProfile.setFirstName(user.get().getFirstName());
        userProfile.setLastName(user.get().getLastName());
        userProfile.setEmail(user.get().getEmail());
        userProfile.setId(user.get().getId());
        userProfile.setUserName(user.get().getUserName());
        //now find all notes for this user to add to the profile before sending it back
        Optional<Iterable<PrivateNote>> privateNoteSet = privateNoteRepository.findAllByUserId(userProfile.getId());
        if(privateNoteSet.isPresent()) {
            //TODO:finish creating the userProfile

        }


        return null;
    }

    //Decoding class to separate the authentication string sent as a standard http basic authentication header
    //string is of form username:password
    private String[] decodeAuthenticationString(String authString){
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
            String[] userInfo = decodedAuth.split(":");
            return userInfo;
        }
        return null; //didn't work or string is not there

    }

}
