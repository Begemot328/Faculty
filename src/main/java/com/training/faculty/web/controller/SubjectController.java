package com.training.faculty.web.controller;

import com.training.faculty.domain.Subject;
import com.training.faculty.service.SubjectService;
import com.training.faculty.web.dto.SubjectDTO;
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
@RequestMapping(value = "/subjects")
public class SubjectController {

    private final ModelMapper mapper;
    private SubjectService service;

    @Autowired
    public SubjectController(SubjectService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<SubjectDTO> create(@RequestBody SubjectDTO subjectDTO) {
        subjectDTO = mapper.map(service.create(mapper.map(subjectDTO, Subject.class)),
                SubjectDTO.class);
        return new ResponseEntity<>(subjectDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SubjectDTO> find(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(mapper.map(service.getById(id), SubjectDTO.class),
                HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<SubjectDTO> update(@RequestBody SubjectDTO subjectDTO) {
        service.update(mapper.map(subjectDTO, Subject.class));
        return new ResponseEntity<>(subjectDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<SubjectDTO> delete(@PathVariable(value = "id") int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<Page<SubjectDTO>> find(Pageable pageable) {
        Page<SubjectDTO> result = service.getAll(pageable)
                .map(subject -> mapper.map(subject, SubjectDTO.class));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
