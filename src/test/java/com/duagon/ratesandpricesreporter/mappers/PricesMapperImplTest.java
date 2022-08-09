package com.duagon.ratesandpricesreporter.mappers;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.duagon.ratesandpricesreporter.constants.RatesAndPricesConstants;
import com.duagon.ratesandpricesreporter.entities.Brands;
import com.duagon.ratesandpricesreporter.entities.Currencies;
import com.duagon.ratesandpricesreporter.entities.Prices;
import com.duagon.ratesandpricesreporter.entities.Products;
import com.duagon.ratesandpricesreporter.entities.Rates;
import com.duagon.ratesandpricesreporter.model.RatesAndPricesOutputDTO;

class PricesMapperImplTest {

	private PricesMapperImpl pricesMapperImpl = new PricesMapperImpl();

	@Test
	void pricesMapperTestValidPrice() {

		Prices price = Prices.builder()
				.startDate(LocalDateTime.parse("2020-06-14-00.00.00", RatesAndPricesConstants.DATE_FORMAT))
				.endDate(LocalDateTime.parse("2020-12-31-23.59.59", RatesAndPricesConstants.DATE_FORMAT))
				.fkBrandId(Brands.builder().brandCode("1").brandName("ZARA").brandDescription("Provider").build())
				.fkCurrencyId(Currencies.builder().currencyISO("EUR").build())
				.fkProductId(Products.builder().productCodeId("1").productName("Necktie")
						.productDescription("Not for summer").build())
				.fkRatesId(Rates.builder().rateCode("1").build()).price(100.50d).priority(1).build();

		RatesAndPricesOutputDTO ratesAndPricesOutputDTO = RatesAndPricesOutputDTO.builder()
				.applicationStartDate("2020-06-14-00.00.00").applicationEndDate("2020-12-31-23.59.59")
				.brandId("1 - ZARA").price("100,50").productId("1").rate("1").build();

		Optional<RatesAndPricesOutputDTO> optRatesAndPricesOutputDTO = pricesMapperImpl
				.mapFromPricesToPricesAndRatesOutputDTO(price);

		assertTrue(optRatesAndPricesOutputDTO.isPresent());

		assertEquals(ratesAndPricesOutputDTO, optRatesAndPricesOutputDTO.get());

	}

	@Test
	void pricesMapperTestEmptyPrice() {

		Optional<RatesAndPricesOutputDTO> optRatesAndPricesOutputDTO = pricesMapperImpl
				.mapFromPricesToPricesAndRatesOutputDTO(Prices.builder().build());

		assertTrue(optRatesAndPricesOutputDTO.isEmpty());
	}

	@Test
	void pricesMapperTestIncoherentDates() {

		Prices price = Prices.builder()
				.startDate(LocalDateTime.parse("2020-12-31-23.59.59", RatesAndPricesConstants.DATE_FORMAT))
				.endDate(LocalDateTime.parse("2020-06-14-00.00.00", RatesAndPricesConstants.DATE_FORMAT))
				.fkBrandId(Brands.builder().brandCode("1").brandName("ZARA").brandDescription("Provider").build())
				.fkCurrencyId(Currencies.builder().currencyISO("EUR").build())
				.fkProductId(Products.builder().productCodeId("1").productName("Necktie")
						.productDescription("Not for summer").build())
				.fkRatesId(Rates.builder().rateCode("1").build()).price(100.50d).priority(1).build();

		Optional<RatesAndPricesOutputDTO> optRatesAndPricesOutputDTO = pricesMapperImpl
				.mapFromPricesToPricesAndRatesOutputDTO(price);

		assertTrue(optRatesAndPricesOutputDTO.isEmpty());
	}
	
	@Test
	void pricesMapperTestNullPrice() {
		
		Prices price = Prices.builder()
				.startDate(LocalDateTime.parse("2020-06-14-00.00.00", RatesAndPricesConstants.DATE_FORMAT))
				.endDate(LocalDateTime.parse("2020-12-31-23.59.59", RatesAndPricesConstants.DATE_FORMAT))
				.fkBrandId(Brands.builder().brandCode("1").brandName("ZARA").brandDescription("Provider").build())
				.fkCurrencyId(Currencies.builder().currencyISO("EUR").build())
				.fkProductId(Products.builder().productCodeId("1").productName("Necktie")
						.productDescription("Not for summer").build())
				.fkRatesId(Rates.builder().rateCode("1").build()).price(null).priority(1).build();
		
		Optional<RatesAndPricesOutputDTO> optRatesAndPricesOutputDTO = pricesMapperImpl
				.mapFromPricesToPricesAndRatesOutputDTO(price);

		assertTrue(optRatesAndPricesOutputDTO.isEmpty());
		
	}

}
