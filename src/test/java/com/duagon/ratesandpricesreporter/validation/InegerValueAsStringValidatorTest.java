package com.duagon.ratesandpricesreporter.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InegerValueAsStringValidatorTest {
	
	InegerValueAsStringValidator inegerValueAsStringValidator = new InegerValueAsStringValidator();

	@Test
	void integerValueValidationTest() {
		
		assertTrue(inegerValueAsStringValidator.isValid("1", null));
		assertTrue(inegerValueAsStringValidator.isValid("38732783", null));
		
		assertFalse(inegerValueAsStringValidator.isValid("a", null));
		assertFalse(inegerValueAsStringValidator.isValid("0.1", null));
		assertFalse(inegerValueAsStringValidator.isValid("-1", null));
		
	}

}
