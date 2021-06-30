package com.training.faculty.web.dto.simple;

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
public class SimpleStudentDTO {
    private long id;

    private String firstName;

    private String lastName;

    private List<SimpleTeamDTO> teams;
}
