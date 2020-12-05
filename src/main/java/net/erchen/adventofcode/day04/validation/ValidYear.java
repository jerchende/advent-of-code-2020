package net.erchen.adventofcode.day04.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidYearValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidYear {

    String message() default "invalid year";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int minYear();

    int maxYear();


}
