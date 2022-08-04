package com.duagon.ratesandpricesreporter.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.duagon.ratesandpricesreporter.constants.RatesAndPricesConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InegerValueAsStringValidator implements ConstraintValidator<IntegerValueAsStringConstraint, String> {

	// Regular expression to check the 'integer convertible format' of a String
	private static final String regexInteger = "\\d+$";

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		boolean isValid = value.matches(regexInteger);

		if (!isValid) {

			log.error(RatesAndPricesConstants.INTEGER_CONSTRAINT, value);
		}

		return isValid;
	}

}