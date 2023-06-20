package com.javacourse.mathteachershelper.controller;

import com.javacourse.mathteachershelper.entity.Equation;
import com.javacourse.mathteachershelper.service.EquationService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/equations")
public class EquationController {

    private EquationService equationService;

    public EquationController(EquationService theEquationService) {
        equationService = theEquationService;
    }

    @GetMapping("/list")
    public String listEquations(Model theModel) {

        List<Equation> theEquations = equationService.findAll();

        theModel.addAttribute("equations", theEquations);

        return "equations/list-equations";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Equation theEquation = new Equation();

        theModel.addAttribute("equation", theEquation);

        return "equations/equation-form";
    }

    @PostMapping("/save")
    public String saveEquation(@Valid @ModelAttribute("equation") Equation theEquation,
                               BindingResult theBindingResult) {
        if (theBindingResult.hasErrors()) {
            return "equations/equation-form";
        } else {
            equationService.save(theEquation);

            return "redirect:/equations/list";
        }
    }
}
