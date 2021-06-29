package com.training.faculty.persistence;

import com.training.faculty.domain.Book;
import com.training.faculty.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends EntityRepository<Student> {
}
