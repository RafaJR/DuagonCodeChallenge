package com.duagon.ratesandpricesreporter;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.duagon.ratesandpricesreporter.constants.RatesAndPricesConstants;
import com.duagon.ratesandpricesreporter.dao.IBrandsDao;
import com.duagon.ratesandpricesreporter.dao.ICurrencyDao;
import com.duagon.ratesandpricesreporter.dao.IProductsDao;
import com.duagon.ratesandpricesreporter.dao.IRatesDao;
import com.duagon.ratesandpricesreporter.dao.PricesDao;
import com.duagon.ratesandpricesreporter.entities.Brands;
import com.duagon.ratesandpricesreporter.entities.Currencies;
import com.duagon.ratesandpricesreporter.entities.Prices;
import com.duagon.ratesandpricesreporter.entities.Products;
import com.duagon.ratesandpricesreporter.entities.Rates;

import lombok.extern.slf4j.Slf4j;

/**
 * Application load listener to prepare initial data for testing.
 */
@Slf4j
@Component
public class ApplicationStartUp implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private PricesDao pricesDao;
	@Autowired
	private IBrandsDao brandsDao;
	@Autowired
	private ICurrencyDao currencyDao;
	@Autowired
	private IProductsDao productsDao;
	@Autowired
	private IRatesDao ratesDao;

	/**
	 * @param Inital data loading just then of application load
	 */
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {

		log.info(RatesAndPricesConstants.SAVING_DEFAULT_DATA);

		// Saving brands
		Brands brand1 = brandsDao
				.save(Brands.builder().brandName("ZARA").brandDescription("Textile products supplier").build());
		Brands brand2 = brandsDao
				.save(Brands.builder().brandName("IKEA").brandDescription("Forniture supplier").build());

		// Saving rates
		Rates rate1 = ratesDao.save(Rates.builder().rateCode("1").build());
		Rates rate2 = ratesDao.save(Rates.builder().rateCode("2").build());
		Rates rate3 = ratesDao.save(Rates.builder().rateCode("3").build());
		Rates rate4 = ratesDao.save(Rates.builder().rateCode("4").build());

		// Saving products
		Products product1 = productsDao
				.save(Products.builder().productCodeId("35455").productName("Gentleman suit").build());
		Products product2 = productsDao.save(Products.builder().productCodeId("19347").productName("Necktie").build());

		// Saving Currencies
		Currencies currency1 = currencyDao.save(Currencies.builder().currencyISO("EUR").build());
		Currencies currency2 = currencyDao.save(Currencies.builder().currencyISO("USD").build());

		// Saving prices
		if (Stream.of(pricesDao.savePrice(Prices.builder().fkProductId(product1).fkBrandId(brand1)
				.fkCurrencyId(currency1).fkRatesId(rate1).price(35.50d).priority(0)
				.startDate(LocalDateTime.parse("2020-06-14-00.00.00", RatesAndPricesConstants.DATE_FORMAT))
				.endDate(LocalDateTime.parse("2020-12-31-23.59.59", RatesAndPricesConstants.DATE_FORMAT)).build()),
				pricesDao.savePrice(Prices.builder().fkProductId(product1).fkBrandId(brand1).fkCurrencyId(currency1)
						.fkRatesId(rate2).price(25.45d).priority(1)
						.startDate(LocalDateTime.parse("2020-06-14-15.00.00", RatesAndPricesConstants.DATE_FORMAT))
						.endDate(LocalDateTime.parse("2020-06-14-18.30.00", RatesAndPricesConstants.DATE_FORMAT))
						.build()),
				pricesDao.savePrice(Prices.builder().fkProductId(product1).fkBrandId(brand1).fkCurrencyId(currency1)
						.fkRatesId(rate3).price(30.50d).priority(1)
						.startDate(LocalDateTime.parse("2020-06-15-00.00.00", RatesAndPricesConstants.DATE_FORMAT))
						.endDate(LocalDateTime.parse("2020-06-15-11.00.00", RatesAndPricesConstants.DATE_FORMAT))
						.build()),
				pricesDao.savePrice(Prices.builder().fkProductId(product1).fkBrandId(brand1).fkCurrencyId(currency1)
						.fkRatesId(rate4).price(38.95d).priority(1)
						.startDate(LocalDateTime.parse("2020-06-15-16.00.00", RatesAndPricesConstants.DATE_FORMAT))
						.endDate(LocalDateTime.parse("2020-12-31-23.59.59", RatesAndPricesConstants.DATE_FORMAT))
						.build()),
				pricesDao.savePrice(Prices.builder().fkProductId(product2).fkBrandId(brand2).fkCurrencyId(currency2)
						.fkRatesId(rate4).price(20.50d).priority(0).startDate(LocalDateTime.now())
						.endDate(LocalDateTime.now()).build()))
				.allMatch(price -> price.isPresent())) {

			log.info(RatesAndPricesConstants.DEFAULT_DATA_SAVE_SUCCESS, pricesDao.findAllPrices().stream()
					.map(price -> price.toString()).collect(Collectors.joining()));
			log.info(RatesAndPricesConstants.RATES_AND_PRICES_REPORTER_READY);

		} else {
			log.error(RatesAndPricesConstants.DEFAULT_DATA_SAVE_FAILED);
		}

	}

}
