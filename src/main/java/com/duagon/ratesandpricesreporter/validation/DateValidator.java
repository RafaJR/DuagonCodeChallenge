package com.duagon.ratesandpricesreporter.validation;

import java.time.format.DateTimeParseException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.duagon.ratesandpricesreporter.constants.RatesAndPricesConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateValidator implements ConstraintValidator<DateConstraint, String> {

	@Override
	public boolean isValid(String dateTime, ConstraintValidatorContext context) {

		if (dateTime != null) {

			try {
				RatesAndPricesConstants.DATE_FORMAT.parse(dateTime);
			} catch (DateTimeParseException e) {
				log.error(RatesAndPricesConstants.DATE_CONSTRAINT_LOG, dateTime);
				return false;
			}
			
			return true;

		}

		return false;
	}

}