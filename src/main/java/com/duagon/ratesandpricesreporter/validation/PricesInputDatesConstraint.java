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
@Constraint(validatedBy = PricesInputDatesValidator.class)
@Target({ ElementType.CONSTRUCTOR })
@Retention(RetentionPolicy.RUNTIME)
public @interface PricesInputDatesConstraint {
	String message() default RatesAndPricesConstants.DATES_CONSTRAINT_LOG;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
