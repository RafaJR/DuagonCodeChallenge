package com.duagon.ratesandpricesreporter.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.duagon.ratesandpricesreporter.entities.Prices;

public class PricesInputDatesValidator implements ConstraintValidator<PricesInputDatesConstraint, Prices> {

	@Override
	public boolean isValid(Prices price, ConstraintValidatorContext context) {

		return price.getStartDate().isBefore(price.getEndDate());
	}

}
