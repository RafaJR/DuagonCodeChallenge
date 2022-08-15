package com.duagon.ratesandpricesreporter.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.duagon.ratesandpricesreporter.constants.RatesAndPricesConstants;
import com.duagon.ratesandpricesreporter.entities.Prices;
import com.duagon.ratesandpricesreporter.model.RatesAndPricesInputDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PricesDao {

	@Autowired
	private IPricesDao iPricesDao;

	/**
	 * @param ratesAndPricesInputDTO
	 * @return Optional<List<Prices>> Return an empty result if no match is found at
	 *         DB query Find prices at DB by it's productCode, brand and date.
	 */
	public Optional<List<Prices>> findPrices(RatesAndPricesInputDTO ratesAndPricesInputDTO) {

		log.info(RatesAndPricesConstants.FIND_PRICES_START, ratesAndPricesInputDTO);

		LocalDateTime inputDate = LocalDateTime.parse(ratesAndPricesInputDTO.getAplicationDate(),
				RatesAndPricesConstants.DATE_FORMAT);

		Optional<List<Prices>> optPricesList = iPricesDao
				.findPricesByFkProductId_ProductCodeIdAndFkBrandId_BrandCodeAndStartDateBeforeAndEndDateAfter(
						ratesAndPricesInputDTO.getProductId(), ratesAndPricesInputDTO.getBrandId(), inputDate,
						inputDate);

		if (optPricesList.isPresent() && !optPricesList.get().isEmpty()) {

			log.info(RatesAndPricesConstants.DAO_FIND_PRICES_SUCCESS);

			return optPricesList;

		} else {

			log.info(RatesAndPricesConstants.DAO_FIND_PRICES_NOT_FOUND);

			return Optional.empty();
		}
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
