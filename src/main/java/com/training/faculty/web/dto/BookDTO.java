package com.training.faculty.web.dto;

import com.training.faculty.domain.Subject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class BookDTO {

    private long id;

    private SubjectDTO subject;

    private String title;

    private String author;
}
