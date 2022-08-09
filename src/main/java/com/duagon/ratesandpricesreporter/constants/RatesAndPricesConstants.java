package com.duagon.ratesandpricesreporter.constants;

import java.time.format.DateTimeFormatter;

public class RatesAndPricesConstants {
	
	// Trace messages for controller
	public static final String CONTROLLER_GET_PRICES_AND_RATES_START = "Started request to get prices from parameters : \n\t{}\n###########";
	public static final String INITAL_DATA_LOADING = "";
	public static final String RATES_AND_PRICES_REPORTER_READY = "Rates and prices reporter is ready to work!";
	public static final String NO_RESULT = "No prices found for input data:\n\t%s";
	public static final String IO_EXCEPTION = "An error happened when trying to find the price:\n\t{}";
	public static final String GENERAL_EXCEPTION = "An error happened when trying to find the price:\n\t{}";
	public static final String RATES_AND_PRICES_SUCCESFULL_REQUEST = "Successfull request to obtain the prices with the imput data:\n\t{}\nObtaining the result:\n\t{}";
	
	// Trace messages for dao
	public static final String SAVE_PRICES_START = "A new price is going to be saved with these data:\n\t{}";
	public static final String SAVE_PRICES_SUCCESS = "A new price has been saved with these data:\n\t{}";
	public static final String SAVE_PRICES_FAILED = "An error happened when trying to save a price with these data:\n\t{}";
	public static final String FIND_PRICES_START = "A database query to find prices is going to be thrown with these data:\n\t{}";
	
	// Trace messages for application start up
	public static final String SAVING_DEFAULT_DATA = "Some data by default is going to be saved to start the application";
	public static final String DEFAULT_DATA_SAVE_SUCCESS = "Default data has been sucessfully saved:\n\t{}";
	public static final String DEFAULT_DATA_SAVE_FAILED = "An error happened when trying to save the application default data.";
	
	// Trace messages for service
	public static final String SERVICE_FIND_PRICES_START = "Started service to find prices from data:\n\t{}";
	
	// Data format constraints
	public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
	public static final String MONETARY_FIGURE_FORMAT = "%.2f";
	
	// Input validation messages
	public static final String NOT_NULL_INPUT = "You must introduce the request parameters to obtain a price data.";
	public static final String INTEGER_CONSTRAINT_HTTP_MESSAGE = "This parameter must be introduced as a integer value.";
	public static final String INTEGER_CONSTRAINT_LOG = "The input parameter introduced as '{}' must be introduced as an integer value.";
	public static final String DATE_CONSTRAINT_HTTP_MESSAGE = "The dates must be introduced with format 'yyyy-MM-dd-HH.mm.ss'";
	public static final String DATE_CONSTRAINT_LOG = "The date introduced as '{}' must be introduced with format 'yyyy-MM-dd-HH.mm.ss'";
	public static final String DATES_CONSTRAINT_MESSAGE = "The start date must be before de end date";
	public static final String DATES_CONSTRAINT_LOG = "The start date '{}' inserted is after the end date '[]' inserted.";
	
}
