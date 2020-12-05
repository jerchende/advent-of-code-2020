package net.erchen.adventofcode.day04.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class ValidHeightValidator implements ConstraintValidator<ValidHeight, String> {

    private final static Pattern heightPattern = Pattern.compile("([0-9]+)(in|cm)");

    @Override
    public void initialize(ValidHeight constraint) {
    }

    @Override
    public boolean isValid(String height, ConstraintValidatorContext context) {
        if (height == null) {
            return false;
        }
        var matcher = heightPattern.matcher(height);
        if (!matcher.matches()) {
            return false;
        }
        int value = Integer.parseInt(matcher.group(1));
        String unit = matcher.group(2);

        switch (unit) {
            case "in":
                return validateInch(value);
            case "cm":
                return validateCentimeter(value);
            default:
                return false;
        }
    }

    private boolean validateCentimeter(int value) {
        return 150 <= value && value <= 193;
    }

    private boolean validateInch(int value) {
        return 59 <= value && value <= 76;
    }
}
