package com.duagon.ratesandpricesreporter.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duagon.ratesandpricesreporter.constants.RatesAndPricesConstants;
import com.duagon.ratesandpricesreporter.model.RatesAndPricesOutputDTO;
import com.duagon.ratesandpricesreporter.model.RatesAndPricesInputDTO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/duagon")
@Slf4j
public class RatesAndPricesController {

	@GetMapping("/ratesandprices")
	public ResponseEntity<?> getRatesAndPrices(
			@NotNull(message = RatesAndPricesConstants.NOT_NULL_INPUT) @Valid @RequestBody RatesAndPricesInputDTO ratesAndPricesInputDTO) {

		log.info(RatesAndPricesConstants.CONTROLLER_GET_PRICES_AND_RATES_START, ratesAndPricesInputDTO.toString());
		
		return ResponseEntity.ok(RatesAndPricesOutputDTO.builder()
				.applicationEndDate("2020-12-31-23.59.59")
				.applicationStartDate("2020-06-14-00.00.00")
				.brandId("ZARA")
				.price("100.50")
				.productId("35455")
				.rate("1")
				.build());

	}

}
