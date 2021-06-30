package com.training.faculty.persistence;

import com.training.faculty.domain.Subject;
import com.training.faculty.domain.Team;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier
public interface SubjectRepository extends EntityRepository<Subject> {
}
