package com.duagon.ratesandpricesreporter.controller;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.duagon.ratesandpricesreporter.constants.Constants;

import lombok.extern.slf4j.Slf4j;

/**
 * Application load listener to prepare initial data for testing.
 */
@Slf4j
@Component
public class ApplicationStartUp implements ApplicationListener<ApplicationReadyEvent> {

	/**
	 * @param Inital data loading just then of application load
	 */
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {

		//TODO: data load method
		log.info(Constants.RATES_AND_PRICES_REPORTER_READY);		

	}

}
