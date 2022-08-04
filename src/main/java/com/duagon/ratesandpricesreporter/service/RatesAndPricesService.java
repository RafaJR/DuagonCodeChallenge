package com.duagon.ratesandpricesreporter.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.duagon.ratesandpricesreporter.constants.RatesAndPricesConstants;
import com.duagon.ratesandpricesreporter.model.RatesAndPricesInputDTO;
import com.duagon.ratesandpricesreporter.model.RatesAndPricesOutputDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RatesAndPricesService implements IRatesAndPricesService {

	/**
	 * @param ratesAndPricesInputDTO
	 * @return Optional<List<RatesAndPricesOutputDTO>>
	 * @throws IOException Find prices that matches with the input data: brand,
	 *                     product, applicationDate
	 */
	@Override
	public Optional<List<RatesAndPricesOutputDTO>> findPrice(RatesAndPricesInputDTO ratesAndPricesInputDTO)
			throws IOException {
		
		log.info(RatesAndPricesConstants.SERVICE_FIND_PRICES_START, ratesAndPricesInputDTO.toString());

		return Optional.of(List.of(RatesAndPricesOutputDTO.builder().applicationEndDate("2020-12-31-23.59.59")
				.applicationStartDate("2020-06-14-00.00.00").brandId("ZARA").price("100.50").productId("35455")
				.rate("1").build()));
	}

}
