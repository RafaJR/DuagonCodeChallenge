package com.duagon.ratesandpricesreporter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duagon.ratesandpricesreporter.constants.Constants;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/duagon")
@Slf4j
public class RatesAndPricesController {

	@GetMapping("/ratesandprices")
	public ResponseEntity<?> getRatesAndPrices(String queryParameter) {

		log.info(Constants.CONTROLLER_GET_PRICES_AND_RATES_START, queryParameter);
		return ResponseEntity.ok("Microservice is working!");

	}

}
