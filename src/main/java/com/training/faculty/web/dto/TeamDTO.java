package com.training.faculty.web.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class TeamDTO {
    private long id;

    private String name;

    private SubjectDTO subject;

    private List<StudentDTO> students;
}
