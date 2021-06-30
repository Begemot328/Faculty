package com.training.faculty.persistence;

import com.training.faculty.domain.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface StudentRepository extends EntityRepository<Student> {
}
