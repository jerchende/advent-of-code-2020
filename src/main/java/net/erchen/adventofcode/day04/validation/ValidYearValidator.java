package net.erchen.adventofcode.day04.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidYearValidator implements ConstraintValidator<ValidYear, String> {

    private int minYear;
    private int maxYear;

    @Override
    public void initialize(ValidYear constraint) {
        this.minYear = constraint.minYear();
        this.maxYear = constraint.maxYear();
    }

    @Override
    public boolean isValid(String year, ConstraintValidatorContext context) {
        return year != null && year.matches("[0-9]{4}") && Integer.parseInt(year) >= minYear && Integer.parseInt(year) <= maxYear;
    }
}
