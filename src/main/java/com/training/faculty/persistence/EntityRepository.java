package com.training.faculty.persistence;

import com.training.faculty.domain.CustomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityRepository<T extends CustomEntity> extends JpaRepository<T, Long> {
}
