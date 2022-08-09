package com.duagon.ratesandpricesreporter.validation;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.duagon.ratesandpricesreporter.constants.RatesAndPricesConstants;
import com.duagon.ratesandpricesreporter.entities.Prices;

class PricesInputDatesValidatorTest {
	
	PricesInputDatesValidator pricesInputDatesValidator = new PricesInputDatesValidator();
	
	LocalDateTime beforeDate = LocalDateTime.parse("2020-06-14-00.00.00", RatesAndPricesConstants.DATE_FORMAT);
	LocalDateTime afterDate = LocalDateTime.parse("2020-12-31-23.59.59", RatesAndPricesConstants.DATE_FORMAT);

	@Test
	void pricesInputDatesValidationValidDatesTest() {
		
		assertTrue(pricesInputDatesValidator.isValid(Prices.builder()
				.startDate(beforeDate)
				.endDate(afterDate)
				.build(), null));
	}
	
	@Test
	void pricesInputDatesValidationNotValidDatesTest() {
		
		assertFalse(pricesInputDatesValidator.isValid(Prices.builder()
				.startDate(afterDate)
				.endDate(beforeDate)
				.build(), null));
	}
	
	@Test
	void pricesInputDatesValidationEqualDatesTest() {
		
		LocalDateTime now = LocalDateTime.now();
		
		assertFalse(pricesInputDatesValidator.isValid(Prices.builder()
				.startDate(now)
				.endDate(now)
				.build(), null));
	}

}
