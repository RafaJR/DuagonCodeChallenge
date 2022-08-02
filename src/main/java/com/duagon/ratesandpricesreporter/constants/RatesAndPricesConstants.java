package com.duagon.ratesandpricesreporter.constants;

import java.time.format.DateTimeFormatter;

public class RatesAndPricesConstants {
	
	// Trace messages for controller
	public final static String CONTROLLER_GET_PRICES_AND_RATES_START = "Started request to get prices from parameters : \n\t{}\n###########";
	public final static String INITAL_DATA_LOADING = "";
	public final static String RATES_AND_PRICES_REPORTER_READY = "Rates and prices reporter is ready to work!";
	// Trace messages for dao
	public final static String SAVE_PRICES_START = "A new price is going to be saved with these data:\n\t{}";
	public final static String SAVE_PRICES_SUCCESS = "A new price has been saved with these data:\n\t{}";
	public final static String SAVE_PRICES_FAILED = "An error happened when trying to save a price with these data:\n\t{}";
	// Trace messages for application start up
	public final static String SAVING_DEFAULT_DATA = "Some data by default is going to be saved to start the application";
	public final static String DEFAULT_DATA_SAVE_SUCCESS = "Default data has been sucessfully saved:\n\t{}";
	public final static String DEFAULT_DATA_SAVE_FAILED = "An error happened when trying to save the application default data.";
	
	// Data format constraints
	public final static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
}