package com.training.faculty.persistence;

import com.training.faculty.domain.Book;
import com.training.faculty.domain.Team;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier
public interface TeamRepository extends EntityRepository<Team> {
}
