package com.training.faculty.web.dto;

import com.training.faculty.web.dto.simple.SimpleStudentDTO;
import com.training.faculty.web.dto.simple.SimpleSubjectDTO;
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

    private SimpleSubjectDTO subject;

    private List<SimpleStudentDTO> students;
}
