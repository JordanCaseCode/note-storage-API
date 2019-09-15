package com.example.notesystem.backend.repositories;

import com.example.notesystem.backend.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    //create the user
    User save(User user);

    //find user by either userName or email
    //both are optional because they could not return anything which case will throw error to client
    Optional<User> findByUserName(String userName);
    Optional<User> findByEmail(String email);



}
