package com.duagon.ratesandpricesreporter.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.duagon.ratesandpricesreporter.constants.RatesAndPricesConstants;

@Documented
@Constraint(validatedBy = InegerValueAsStringValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IntegerValueAsStringConstraint {
    String message() default RatesAndPricesConstants.INTEGER_CONSTRAINT_HTTP_MESSAGE;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}