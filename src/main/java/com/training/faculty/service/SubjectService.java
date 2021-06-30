package com.training.faculty.service;

import com.training.faculty.domain.Book;
import com.training.faculty.domain.Subject;
import com.training.faculty.persistence.BookRepository;
import com.training.faculty.persistence.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService extends EntityService<Subject>{
    @Autowired
    public SubjectService(SubjectRepository repository) {
        super(repository);
    }
}
