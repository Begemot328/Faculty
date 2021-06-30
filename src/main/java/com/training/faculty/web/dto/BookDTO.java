package com.training.faculty.web.dto;

import com.training.faculty.web.dto.simple.SimpleSubjectDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class BookDTO {

    private long id;

    private SimpleSubjectDTO subject;

    private String title;

    private String author;
}
