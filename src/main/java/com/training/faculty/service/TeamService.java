package com.training.faculty.service;

import com.training.faculty.domain.Book;
import com.training.faculty.domain.Team;
import com.training.faculty.persistence.BookRepository;
import com.training.faculty.persistence.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService extends EntityService<Team>{
    @Autowired
    public TeamService(TeamRepository repository) {
        super(repository);
    }
}
