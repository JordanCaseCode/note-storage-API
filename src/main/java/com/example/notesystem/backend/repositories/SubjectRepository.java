package com.example.notesystem.backend.repositories;

import com.example.notesystem.backend.entities.Subject;
import org.hibernate.engine.transaction.jta.platform.internal.SunOneJtaPlatform;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends PagingAndSortingRepository<Subject, String> {

    Subject save (Subject subject); //save the subject
    Iterable<Subject> findAll(Sort sort);
    Page<Subject> findAll(Pageable pageable); //find all subjects and return pageable subjects

    //find subject and return optional object to run get() or isPresent() on
    Optional<Subject> findBySubjectId(String subjectId);




}
