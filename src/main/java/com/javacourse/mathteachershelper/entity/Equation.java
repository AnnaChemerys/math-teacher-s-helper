package com.javacourse.mathteachershelper.entity;

import com.javacourse.mathteachershelper.validation.CorrectnessOfInputEquation;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="equation")
public class Equation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "name_of_creator")
    @Size(min=1, message="is required")
    private String nameOfCreator;

    @Column(name = "body_of_equation")
    @CorrectnessOfInputEquation
    private String bodyOfEquation;

    @Column(name = "count_of_numbers")
    private int countOfNumbers;

    public Equation() {
    }

    public Equation(String nameOfCreator, String bodyOfEquation, int countOfNumbers) {
        this.nameOfCreator = nameOfCreator;
        this.bodyOfEquation = bodyOfEquation;
        this.countOfNumbers = countOfNumbers;
    }

    public Equation(int id, String nameOfCreator, String bodyOfEquation, int countOfNumbers) {
        this.id = id;
        this.nameOfCreator = nameOfCreator;
        this.bodyOfEquation = bodyOfEquation;
        this.countOfNumbers = countOfNumbers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfCreator() {
        return nameOfCreator;
    }

    public void setNameOfCreator(String nameOfCreator) {
        this.nameOfCreator = nameOfCreator;
    }

    public String getBodyOfEquation() {
        return bodyOfEquation;
    }

    public void setBodyOfEquation(String bodyOfEquation) {
        this.bodyOfEquation = bodyOfEquation;
    }

    public int getCountOfNumbers() {
        return countOfNumbers;
    }

    public void setCountOfNumbers(int countOfNumbers) {
        this.countOfNumbers = countOfNumbers;
    }

    @Override
    public String toString() {
        return "Equation{" +
                "id=" + id +
                ", nameOfCreator='" + nameOfCreator + '\'' +
                ", bodyOfEquation='" + bodyOfEquation + '\'' +
                ", countOfNumbers=" + countOfNumbers +
                '}';
    }
}
