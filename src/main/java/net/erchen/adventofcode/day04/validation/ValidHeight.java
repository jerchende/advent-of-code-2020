package net.erchen.adventofcode.day04.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidHeightValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidHeight {

	String message() default "invalid height";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
