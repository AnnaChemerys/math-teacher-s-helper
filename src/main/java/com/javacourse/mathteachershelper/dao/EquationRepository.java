package com.javacourse.mathteachershelper.dao;

import com.javacourse.mathteachershelper.entity.Equation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquationRepository extends JpaRepository<Equation, Integer> {

    public List<Equation> findAllByOrderByNameOfCreatorAsc();
}
