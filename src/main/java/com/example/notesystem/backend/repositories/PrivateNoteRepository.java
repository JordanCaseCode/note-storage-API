package com.example.notesystem.backend.repositories;

import com.example.notesystem.backend.entities.PrivateNote;
import com.example.notesystem.backend.entities.PublicNote;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrivateNoteRepository extends PagingAndSortingRepository<PrivateNote, Long> {

    PublicNote save(PublicNote publicNote);//create note
    //optional iterable returned for users private notes
    Optional<Iterable<PrivateNote>> findAllByUserId(Long userId);
    //allow deleting of note
    PublicNote deleteByUserIdAndAndPrivateNoteName(String userId, String privateNoteName);
    //count how many notes this person has
    Long countByUserId(Long userId);



}
