package com.duagon.ratesandpricesreporter.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.duagon.ratesandpricesreporter.constants.RatesAndPricesConstants;
import com.duagon.ratesandpricesreporter.entities.Brands;
import com.duagon.ratesandpricesreporter.entities.Currencies;
import com.duagon.ratesandpricesreporter.entities.Prices;
import com.duagon.ratesandpricesreporter.entities.Products;
import com.duagon.ratesandpricesreporter.entities.Rates;
import com.duagon.ratesandpricesreporter.model.RatesAndPricesInputDTO;
import com.duagon.ratesandpricesreporter.model.RatesAndPricesOutputDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PricesDao {

	@Autowired
	private IPricesDao iPricesDao;

	public Optional<List<Prices>> findPrices(RatesAndPricesInputDTO ratesAndPricesInputDTO) {

		log.info(RatesAndPricesConstants.FIND_PRICES_START, ratesAndPricesInputDTO);

		return Optional.of(List.of(Prices.builder()
				.startDate(LocalDateTime.parse("2020-06-14-00.00.00", RatesAndPricesConstants.DATE_FORMAT))
				.endDate(LocalDateTime.parse("2020-12-31-23.59.59", RatesAndPricesConstants.DATE_FORMAT))
				.fkBrandId(Brands.builder().brandCode("1").brandName("ZARA").brandDescription("Provider").build())
				.fkCurrencyId(Currencies.builder().currencyISO("EUR").build())
				.fkProductId(Products.builder().productCodeId("1").productName("Necktie")
						.productDescription("Not for summer").build())
				.fkRatesId(Rates.builder().rateCode("1").build()).price(100.50d).priority(1).build()));
	}

	public Optional<Prices> savePrice(Prices price) {

		log.info(RatesAndPricesConstants.SAVE_PRICES_START, price.toString());

		Optional<Prices> optPrices = Optional.ofNullable(iPricesDao.save(price));

		if (optPrices.isPresent()) {
			log.info(RatesAndPricesConstants.SAVE_PRICES_SUCCESS, optPrices.get().toString());
		} else {
			log.error(RatesAndPricesConstants.SAVE_PRICES_FAILED, price);
		}

		return optPrices;
	}

	public Optional<List<Prices>> findAllPrices() {

		return Optional.ofNullable((List<Prices>) iPricesDao.findAll());

	}

}
