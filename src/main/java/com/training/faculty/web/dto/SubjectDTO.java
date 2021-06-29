package com.training.faculty.web.dto;

import com.training.faculty.domain.Team;
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
public class SubjectDTO {
    private long id;

    private String name;

    private List<TeamDTO> teams;
}
