package com.javacourse.mathteachershelper.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorrectnessOfInputEquationConstraintValidator
        implements ConstraintValidator<CorrectnessOfInputEquation, String> {

    @Override
    public boolean isValid(String theEquation, ConstraintValidatorContext constraintValidatorContext) {

        if (theEquation != null && isCorrectInput(theEquation)
                && isValidBrackets(theEquation) && isValidMathSign(theEquation)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isCorrectInput(String theEquation) {
        boolean correctness = theEquation.matches("(((0|[1-9]\\d*)(\\.\\d+)?)|x|-|\\+|\\*|/|=|\\(|\\))*");
        return correctness;
    }

    public boolean isValidBrackets(String bracketString) {
        char openingBrackets = '(';
        char closingBrackets = ')';

        Deque<Character> stack = new LinkedList<>();
        for(Character character : bracketString.toCharArray()) {
            if (character == openingBrackets) {
                stack.push(character);
            } else if (character == closingBrackets) {
                if (stack.isEmpty() || stack.pop() != openingBrackets) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public boolean isValidMathSign(String myMath) {
        Pattern mathSign = Pattern.compile("((\\+|-|\\*|/|=|\\()(\\+|\\*|/|=|\\))|(\\)\\())");
        Matcher mathMatcher = mathSign.matcher(myMath);
        return !mathMatcher.find();
    }
}
