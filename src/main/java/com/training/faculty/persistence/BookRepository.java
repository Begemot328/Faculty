package com.training.faculty.persistence;

import com.training.faculty.domain.Book;
import com.training.faculty.domain.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier
public interface BookRepository extends EntityRepository<Book> {
}
