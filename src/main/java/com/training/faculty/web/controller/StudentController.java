package com.training.faculty.web.controller;

import com.training.faculty.domain.Student;
import com.training.faculty.service.StudentService;
import com.training.faculty.web.dto.StudentDTO;
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
@RequestMapping(value = "/students")
public class StudentController {

    private final ModelMapper mapper;
    private StudentService service;

    @Autowired
    public StudentController(StudentService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<StudentDTO> create(@RequestBody StudentDTO studentDTO) {
        studentDTO = mapper.map(service.create(mapper.map(studentDTO, Student.class)),
                StudentDTO.class);
        return new ResponseEntity<>(studentDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StudentDTO> find(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(mapper.map(service.getById(id), StudentDTO.class),
                HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<StudentDTO> update(@RequestBody StudentDTO studentDTO) {
        service.update(mapper.map(studentDTO, Student.class));
        return new ResponseEntity<>(studentDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<StudentDTO> delete(@PathVariable(value = "id") int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<Page<StudentDTO>> find(Pageable pageable) {
        Page<StudentDTO> result = service.getAll(pageable)
                .map(student -> mapper.map(student, StudentDTO.class));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
