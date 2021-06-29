package com.training.faculty.persistence;

import com.training.faculty.domain.Book;
import com.training.faculty.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends EntityRepository<Book> {
}
