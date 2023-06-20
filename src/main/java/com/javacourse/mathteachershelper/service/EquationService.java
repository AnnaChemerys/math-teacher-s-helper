package com.javacourse.mathteachershelper.service;

import com.javacourse.mathteachershelper.entity.Equation;

import java.util.List;

public interface EquationService {

    List<Equation> findAll();

    Equation findById(int theId);

    void save(Equation theEquation);

    int calculateCountOfNumbers(Equation equation);
}
