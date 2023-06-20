package com.javacourse.mathteachershelper.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CorrectnessOfInputEquationConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CorrectnessOfInputEquation {

    String message() default "Incorrect input of the equation";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
