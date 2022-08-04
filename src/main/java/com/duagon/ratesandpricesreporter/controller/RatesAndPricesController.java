package com.duagon.ratesandpricesreporter.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duagon.ratesandpricesreporter.constants.RatesAndPricesConstants;
import com.duagon.ratesandpricesreporter.model.RatesAndPricesOutputDTO;
import com.duagon.ratesandpricesreporter.service.RatesAndPricesService;
import com.duagon.ratesandpricesreporter.model.RatesAndPricesInputDTO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/duagon")
@Slf4j
public class RatesAndPricesController {

	@Autowired
	private RatesAndPricesService ratesAndPricesService;

	@GetMapping("/ratesandprices")
	public ResponseEntity<?> getRatesAndPrices(
			@NotNull(message = RatesAndPricesConstants.NOT_NULL_INPUT) @Valid @RequestBody RatesAndPricesInputDTO ratesAndPricesInputDTO) {

		log.info(RatesAndPricesConstants.CONTROLLER_GET_PRICES_AND_RATES_START, ratesAndPricesInputDTO.toString());

		Optional<List<RatesAndPricesOutputDTO>> optListRatesAndPricesOutputDTO = Optional.empty();

		try {

			optListRatesAndPricesOutputDTO = ratesAndPricesService.findPrice(ratesAndPricesInputDTO);

		} catch (IOException e) {
			log.error(RatesAndPricesConstants.IO_EXCEPTION, e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error(RatesAndPricesConstants.GENERAL_EXCEPTION, e.getMessage());
			e.printStackTrace();
		}

		if (optListRatesAndPricesOutputDTO.isPresent()) {

			List<RatesAndPricesOutputDTO> listRatesAndPricesOutputDTO = optListRatesAndPricesOutputDTO.get();

			log.info(RatesAndPricesConstants.RATES_AND_PRICES_SUCCESFULL_REQUEST, ratesAndPricesInputDTO,
					listRatesAndPricesOutputDTO.stream().map(price -> price.toString()).collect(Collectors.joining()));
			
			return listRatesAndPricesOutputDTO.size() > 1 ? ResponseEntity.ok(listRatesAndPricesOutputDTO)
					: ResponseEntity.ok(listRatesAndPricesOutputDTO.stream().findFirst().get());

		} else {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(RatesAndPricesConstants.NO_RESULT);
		}

	}

}
