package net.erchen.adventofcode.day04.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidHeightValidatorTest {


    ValidHeightValidator validator = new ValidHeightValidator();

    @Test
    void nullShouldBeNotValid() {
        var isValid = validator.isValid(null, null);

        assertThat(isValid).isFalse();
    }

    @Test
    void invalidFormatShouldBeNotValid() {
        assertThat(validator.isValid("77xz", null)).isFalse();
        assertThat(validator.isValid("", null)).isFalse();
        assertThat(validator.isValid("---", null)).isFalse();
    }

    @Test
    void shouldValidateCentimeter() {
        assertThat(validator.isValid("149cm", null)).isFalse();
        assertThat(validator.isValid("150cm", null)).isTrue();
        assertThat(validator.isValid("193cm", null)).isTrue();
        assertThat(validator.isValid("194cm", null)).isFalse();
    }

    @Test
    void shouldValidateInch() {
        assertThat(validator.isValid("58in", null)).isFalse();
        assertThat(validator.isValid("59in", null)).isTrue();
        assertThat(validator.isValid("76in", null)).isTrue();
        assertThat(validator.isValid("77in", null)).isFalse();
    }
}