package net.erchen.adventofcode.day04.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.Payload;
import java.lang.annotation.Annotation;

import static org.assertj.core.api.Assertions.assertThat;

class ValidYearValidatorTest {

    ValidYearValidator validator = new ValidYearValidator();

    @BeforeEach
    void setUp() {
        validator.initialize(new ValidYear() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return null;
            }

            @Override
            public String message() {
                return null;
            }

            @Override
            public Class<?>[] groups() {
                return null;
            }

            @Override
            public Class<? extends Payload>[] payload() {
                return null;
            }

            @Override
            public int minYear() {
                return 1900;
            }

            @Override
            public int maxYear() {
                return 2000;
            }
        });
    }

    @Test
    void nullShouldBeNotValid() {
        var isValid = validator.isValid(null, null);

        assertThat(isValid).isFalse();
    }

    @Test
    void twoDigestShouldBeNotValid() {
        var isValid = validator.isValid("12", null);

        assertThat(isValid).isFalse();
    }

    @Test
    void belowMinShouldBeNotValid() {
        var isValid = validator.isValid("1899", null);

        assertThat(isValid).isFalse();
    }

    @Test
    void aboveMaxShouldBeNotValid() {
        var isValid = validator.isValid("2001", null);

        assertThat(isValid).isFalse();
    }

    @Test
    void shuldBeValid() {
        var isValid = validator.isValid("1950", null);

        assertThat(isValid).isTrue();
    }
}