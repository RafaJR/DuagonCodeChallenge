package com.duagon.ratesandpricesreporter.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.duagon.ratesandpricesreporter.entities.Prices;

public interface IPricesDao extends CrudRepository<Prices, Long> {

	/**
	 * @param ratesAndPricesInputDTO
	 * @return Optional<List<Prices>> Find prices at DB by it's productCode, brand
	 *         and date
	 */
	public Optional<List<Prices>> findPricesByFkProductId_ProductCodeIdAndFkBrandId_BrandCodeAndStartDateBeforeAndEndDateAfter(
			String productCode, String brandCode, LocalDateTime dateCompareWithStart, LocalDateTime dateCompareWithEnd);

}
