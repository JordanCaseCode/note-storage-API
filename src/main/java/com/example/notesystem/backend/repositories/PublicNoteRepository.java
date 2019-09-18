package com.example.notesystem.backend.repositories;

import com.example.notesystem.backend.entities.PublicNote;
import com.example.notesystem.backend.entities.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublicNoteRepository extends PagingAndSortingRepository<PublicNote, Long> {

    PublicNote save(PublicNote publicNote);
    Optional<Iterable<PublicNote>> findAllByUserId(Long userId);
    Iterable<PublicNote> findAll(Sort sort);
    Page<PublicNote> findAll(Pageable pageable);

}
