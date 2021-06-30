package com.training.faculty.web.controller;

import com.training.faculty.domain.Book;
import com.training.faculty.service.BookService;
import com.training.faculty.web.dto.BookDTO;
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
@RequestMapping(value = "/books")
public class BookController {

    private final ModelMapper mapper;
    private BookService service;

    @Autowired
    public BookController(BookService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<BookDTO> create(@RequestBody BookDTO bookDTO) {
        bookDTO = mapper.map(service.create(mapper.map(bookDTO, Book.class)),
                BookDTO.class);
        return new ResponseEntity<>(bookDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BookDTO> find(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(mapper.map(service.getById(id), BookDTO.class),
                HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<BookDTO> update(@RequestBody BookDTO bookDTO) {
        service.update(mapper.map(bookDTO, Book.class));
        return new ResponseEntity<>(bookDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BookDTO> delete(@PathVariable(value = "id") int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<Page<BookDTO>> find(Pageable pageable) {
        Page<BookDTO> result = service.getAll(pageable)
                .map(book -> mapper.map(book, BookDTO.class));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
