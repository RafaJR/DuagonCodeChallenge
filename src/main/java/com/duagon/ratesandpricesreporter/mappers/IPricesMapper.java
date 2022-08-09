package com.duagon.ratesandpricesreporter.mappers;

import java.util.Optional;

import org.mapstruct.Mapper;

import com.duagon.ratesandpricesreporter.entities.Prices;
import com.duagon.ratesandpricesreporter.model.RatesAndPricesOutputDTO;

@Mapper
public interface IPricesMapper {
	
	/**
	 * @param ratesAndPricesOutputDTO
	 * @return Optional<RatesAndPricesOutputDTO>
	 * Convert a 'Prices' entity to 'RatesAndPricesOutputDTO' to build the endpoint response
	 */
	public Optional<RatesAndPricesOutputDTO> mapFromPricesToPricesAndRatesOutputDTO(Prices prices);

}
