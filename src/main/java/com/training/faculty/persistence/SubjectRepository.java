package com.training.faculty.persistence;

import com.training.faculty.domain.Student;
import com.training.faculty.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SubjectRepository extends EntityRepository<Subject> {
}
