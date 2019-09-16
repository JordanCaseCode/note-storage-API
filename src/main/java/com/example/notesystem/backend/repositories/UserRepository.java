package com.example.notesystem.backend.repositories;

import com.example.notesystem.backend.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    //create the user
    User save(User user);

    //find user by either userName or email and their password
    //allows user to login with either the email/username and their password
    //returns optional because there's not guarantee
    Optional<User> findByUserNameOrEmailAndHashedPassword(String userName, String email, String hashedPassword);

}
