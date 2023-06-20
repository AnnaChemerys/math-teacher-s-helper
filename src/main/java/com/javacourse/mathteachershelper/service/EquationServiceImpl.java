package com.javacourse.mathteachershelper.service;

import com.javacourse.mathteachershelper.dao.EquationRepository;
import com.javacourse.mathteachershelper.entity.Equation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquationServiceImpl implements EquationService {

    private EquationRepository equationRepository;

    @Autowired
    public EquationServiceImpl(EquationRepository theEquationRepository) {
        equationRepository = theEquationRepository;
    }

    @Override
    public List<Equation> findAll() {
        return equationRepository.findAllByOrderByNameOfCreatorAsc();
    }

    @Override
    public Equation findById(int theId) {
        Optional<Equation> result = equationRepository.findById(theId);

        Equation theEquation = null;

        if (result.isPresent()) {
            theEquation = result.get();
        } else {
            throw new RuntimeException("Did not find equation id - " + theId);
        }
        return theEquation;
    }

    @Override
    public void save(Equation theEquation) {
        theEquation.setCountOfNumbers(calculateCountOfNumbers(theEquation));
        equationRepository.save(theEquation);
    }

    @Override
    public int calculateCountOfNumbers(Equation equation) {
        String[] newEquation = equation.getBodyOfEquation().split("(\\s|\\+|-|\\*|/|=|\\(|\\)|x)+");
        return newEquation.length;
    }
}
