package com.training.faculty.web.controller;

import com.training.faculty.domain.Team;
import com.training.faculty.service.TeamService;
import com.training.faculty.web.dto.TeamDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/teams")
public class TeamController {

    private final ModelMapper mapper;
    private TeamService service;

    @Autowired
    public TeamController(TeamService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<TeamDTO> create(@RequestBody TeamDTO teamDTO) {
        teamDTO = mapper.map(service.create(mapper.map(teamDTO, Team.class)),
                TeamDTO.class);
        return new ResponseEntity<>(teamDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TeamDTO> find(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(mapper.map(service.getById(id), TeamDTO.class),
                HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TeamDTO> update(@RequestBody TeamDTO teamDTO) {
        service.update(mapper.map(teamDTO, Team.class));
        return new ResponseEntity<>(teamDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<TeamDTO> delete(@PathVariable(value = "id") int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<Page<TeamDTO>> find(Pageable pageable) {
        Page<TeamDTO> result = service.getAll(pageable)
                .map(team -> mapper.map(team, TeamDTO.class));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
