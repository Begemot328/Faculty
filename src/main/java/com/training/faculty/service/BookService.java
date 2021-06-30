package com.training.faculty.service;

import com.training.faculty.domain.Book;
import com.training.faculty.domain.Student;
import com.training.faculty.persistence.BookRepository;
import com.training.faculty.persistence.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService extends EntityService<Book>{
    @Autowired
    public BookService(BookRepository repository) {
        super(repository);
    }
}
