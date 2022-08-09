package com.duagon.ratesandpricesreporter.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duagon.ratesandpricesreporter.constants.RatesAndPricesConstants;
import com.duagon.ratesandpricesreporter.dao.PricesDao;
import com.duagon.ratesandpricesreporter.entities.Prices;
import com.duagon.ratesandpricesreporter.mappers.PricesMapperImpl;
import com.duagon.ratesandpricesreporter.model.RatesAndPricesInputDTO;
import com.duagon.ratesandpricesreporter.model.RatesAndPricesOutputDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RatesAndPricesService implements IRatesAndPricesService {
	
	@Autowired
	private PricesDao pricesDao;
	@Autowired
	private PricesMapperImpl pricesMapper;

	/**
	 * @param ratesAndPricesInputDTO
	 * @return Optional<List<RatesAndPricesOutputDTO>>
	 * @throws IOException Find prices that matches with the input data: brand,
	 *                     product, applicationDate
	 */
	@Override
	public Optional<List<RatesAndPricesOutputDTO>> findPrices(RatesAndPricesInputDTO ratesAndPricesInputDTO)
			throws IOException {
		
		log.info(RatesAndPricesConstants.SERVICE_FIND_PRICES_START, ratesAndPricesInputDTO.toString());
		
		Optional<List<RatesAndPricesOutputDTO>> optRatesAndPricesOutputDTOList = Optional.empty();
		
		// Finding the prices from database
		Optional<List<Prices>> optPriesList = pricesDao.findPrices(ratesAndPricesInputDTO);
		
		// Mapping to output format if any result is found.
		if(optPriesList.isPresent()) {
			
			optRatesAndPricesOutputDTOList = Optional.ofNullable(optPriesList.get().stream()
					.map(price -> pricesMapper.mapFromPricesToPricesAndRatesOutputDTO(price).get())
					.collect(Collectors.toList()));
			
		}		

		return optRatesAndPricesOutputDTOList;
	}

}
