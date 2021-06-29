package com.training.faculty.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Team  extends CustomEntity {

    private String name;

    @ManyToOne
    @JoinColumn(name="subject_id", nullable=false)
    private Subject subject;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_team",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id"))
    private List<Student> students;
}
