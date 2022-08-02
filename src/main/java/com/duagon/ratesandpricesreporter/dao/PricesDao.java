package com.duagon.ratesandpricesreporter.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.duagon.ratesandpricesreporter.constants.RatesAndPricesConstants;
import com.duagon.ratesandpricesreporter.entities.Prices;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PricesDao {

	@Autowired
	private IPricesDao iPricesDao;

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
