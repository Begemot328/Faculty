package com.training.faculty.service;

import com.training.faculty.domain.Student;
import com.training.faculty.persistence.EntityRepository;
import com.training.faculty.persistence.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends EntityService<Student>{
    @Autowired
    public StudentService(StudentRepository repository) {
        super(repository);
    }
}
