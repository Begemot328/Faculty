package com.training.faculty.service;

import com.training.faculty.domain.CustomEntity;
import com.training.faculty.domain.Student;
import com.training.faculty.persistence.EntityRepository;
import com.training.faculty.persistence.StudentRepository;
import com.training.faculty.service.exception.BadRequestException;
import com.training.faculty.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EntityService<T extends CustomEntity> {
    private static final String NOT_FOUND = "Requested resource not found(%s = %s)!";

    private EntityRepository<T> repository;

    @Autowired
    public EntityService(EntityRepository<T> repository) {
        this.repository = repository;
    }

    public T getStudent(long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(String.format(NOT_FOUND, "id", id)));
    }

    public Page<T> getAllStudents(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void delete(long id) {
        repository.delete(getStudent(id));
    }

    public T create(T student) {
        try {
            return repository.save(student);
        } catch (DataIntegrityViolationException e) {
            throw new BadRequestException(e);
        }
    }

    public void update(T student) {
        getStudent(student.getId());
        try {
            repository.save(student);
        } catch (DataIntegrityViolationException e) {
            throw new BadRequestException(e);
        }
    }
}
