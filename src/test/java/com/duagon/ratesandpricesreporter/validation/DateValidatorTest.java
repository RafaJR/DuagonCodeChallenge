package com.duagon.ratesandpricesreporter.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateValidatorTest {
	
	DateValidator dateValidator = new DateValidator();

	@Test
	void dateFormatValidation() {
		
		assertTrue(dateValidator.isValid("2020-06-14-00.00.00", null));
		assertTrue(dateValidator.isValid("2020-12-31-23.59.59", null));
		
		assertFalse(dateValidator.isValid("2020-06-14-00.00.0", null));
		assertFalse(dateValidator.isValid("a", null));
		assertFalse(dateValidator.isValid(null, null));
		assertFalse(dateValidator.isValid("", null));
		
		
	}

}
