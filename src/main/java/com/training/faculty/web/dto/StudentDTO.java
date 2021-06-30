package com.training.faculty.web.dto;

import com.training.faculty.web.dto.simple.SimpleTeamDTO;
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
public class StudentDTO {
    private long id;

    private String firstName;

    private String lastName;

    private List<SimpleTeamDTO> teams;
}
