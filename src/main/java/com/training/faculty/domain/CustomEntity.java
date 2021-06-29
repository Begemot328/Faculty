package com.training.faculty.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class CustomEntity {
    @Id
    @EqualsAndHashCode.Exclude
    private long id;
}
