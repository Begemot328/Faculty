package com.training.faculty.service;

import com.training.faculty.domain.Student;
import com.training.faculty.service.exception.BadRequestException;
import com.training.faculty.service.exception.NotFoundException;
import com.training.faculty.persistence.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private static final String NOT_FOUND = "Requested resource not found(%s = %s)!";

    private StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student getStudent(long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(String.format(NOT_FOUND, "id", id)));
    }

    public Page<Student> getAllStudents(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void delete(long id) {
        repository.delete(getStudent(id));
    }

    public Student create(Student student) {
        try {
            return repository.save(student);
        } catch (DataIntegrityViolationException e) {
            throw new BadRequestException(e);
        }
    }

    public void update(Student student) {
        getStudent(student.getId());
        try {
            repository.save(student);
        } catch (DataIntegrityViolationException e) {
            throw new BadRequestException(e);
        }
    }
}
