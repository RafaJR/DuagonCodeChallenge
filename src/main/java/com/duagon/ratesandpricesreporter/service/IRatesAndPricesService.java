package com.duagon.ratesandpricesreporter.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.duagon.ratesandpricesreporter.model.RatesAndPricesInputDTO;
import com.duagon.ratesandpricesreporter.model.RatesAndPricesOutputDTO;

public interface IRatesAndPricesService {
	
	/**
	 * @param ratesAndPricesInputDTO
	 * @return Optional<List<RatesAndPricesOutputDTO>>
	 * @throws IOException
	 * Find prices that matches with the input data: brand, product, applicationDate
	 */
	public Optional<List<RatesAndPricesOutputDTO>> findPrice(RatesAndPricesInputDTO ratesAndPricesInputDTO) throws IOException;
}
