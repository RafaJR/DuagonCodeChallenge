package com.duagon.ratesandpricesreporter.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.duagon.ratesandpricesreporter.constants.RatesAndPricesConstants;
import com.duagon.ratesandpricesreporter.model.RatesAndPricesInputDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@Slf4j
class RatesAndPricesControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	private static final String FIND_PRICES_CONTEXT = "/duagon/ratesandprices";
	private static final String CONTENT_TYPE = "application/json";

	@BeforeAll
	static void beforeAll() {

		log.info(RatesAndPricesConstants.MAIN_CONTROLLER_TEST_START);
	}

	@BeforeEach
	void beforeEach(TestInfo testInfo) {

		log.info(RatesAndPricesConstants.MAIN_CONTROLLER_TEST, testInfo.getDisplayName());
	}

//	Test 1: petición a las 10:00 del día 14 del producto 35455
//	para la brand 1 (ZARA) 
	@Test
	void getRatesAndPricesValidRequestTest1() throws JsonProcessingException, Exception {

		RatesAndPricesInputDTO ratesAndPricesInputDTO = RatesAndPricesInputDTO.builder().brandId("1").productId("35455")
				.aplicationDate("2020-06-14-10.00.00").build();

		mockMvc.perform(get(FIND_PRICES_CONTEXT)
				.contentType(CONTENT_TYPE).content(objectMapper.writeValueAsString(ratesAndPricesInputDTO)))
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().json("{\n" + "    \"productId\": \"35455\",\n" + "    \"brandId\": \"1 - ZARA\",\n"
						+ "    \"rate\": \"1\",\n" + "    \"applicationStartDate\": \"2020-06-14-00.00.00\",\n"
						+ "    \"applicationEndDate\": \"2020-12-31-23.59.59\",\n" + "    \"price\": \"35,50\"\n"
						+ "}"));
	}

//	Test 2: petición a las 16:00 del día 14 del producto 35455
//	para la brand 1 (ZARA)
	@Test
	void getRatesAndPricesValidRequestTest2() throws JsonProcessingException, Exception {

		RatesAndPricesInputDTO ratesAndPricesInputDTO = RatesAndPricesInputDTO.builder().brandId("1").productId("35455")
				.aplicationDate("2020-06-14-16.00.00").build();

		mockMvc.perform(get(FIND_PRICES_CONTEXT)
				.contentType(CONTENT_TYPE).content(objectMapper.writeValueAsString(ratesAndPricesInputDTO)))
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().json("[\n" + "    {\n" + "        \"productId\": \"35455\",\n"
						+ "        \"brandId\": \"1 - ZARA\",\n" + "        \"rate\": \"1\",\n"
						+ "        \"applicationStartDate\": \"2020-06-14-00.00.00\",\n"
						+ "        \"applicationEndDate\": \"2020-12-31-23.59.59\",\n"
						+ "        \"price\": \"35,50\"\n" + "    },\n" + "    {\n"
						+ "        \"productId\": \"35455\",\n" + "        \"brandId\": \"1 - ZARA\",\n"
						+ "        \"rate\": \"2\",\n" + "        \"applicationStartDate\": \"2020-06-14-15.00.00\",\n"
						+ "        \"applicationEndDate\": \"2020-06-14-18.30.00\",\n"
						+ "        \"price\": \"25,45\"\n" + "    }\n" + "]"));
	}

//	Test 3: petición a las 21:00 del día 14 del producto 35455
//	para la brand 1 (ZARA)
	@Test
	void getRatesAndPricesValidRequestTest3() throws JsonProcessingException, Exception {

		RatesAndPricesInputDTO ratesAndPricesInputDTO = RatesAndPricesInputDTO.builder().brandId("1").productId("35455")
				.aplicationDate("2020-06-14-21.00.00").build();

		mockMvc.perform(get(FIND_PRICES_CONTEXT)
				.contentType(CONTENT_TYPE).content(objectMapper.writeValueAsString(ratesAndPricesInputDTO)))
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().json("{\n" + "    \"productId\": \"35455\",\n" + "    \"brandId\": \"1 - ZARA\",\n"
						+ "    \"rate\": \"1\",\n" + "    \"applicationStartDate\": \"2020-06-14-00.00.00\",\n"
						+ "    \"applicationEndDate\": \"2020-12-31-23.59.59\",\n" + "    \"price\": \"35,50\"\n"
						+ "}"));
	}

//	Test 4: petición a las 10:00 del día 15 del producto 35455
//	para la brand 1 (ZARA)
	@Test
	void getRatesAndPricesValidRequestTest4() throws JsonProcessingException, Exception {

		RatesAndPricesInputDTO ratesAndPricesInputDTO = RatesAndPricesInputDTO.builder().brandId("1").productId("35455")
				.aplicationDate("2020-06-15-10.00.00").build();

		mockMvc.perform(get(FIND_PRICES_CONTEXT)
				.contentType(CONTENT_TYPE).content(objectMapper.writeValueAsString(ratesAndPricesInputDTO)))
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().json("[\n" + "    {\n" + "        \"productId\": \"35455\",\n"
						+ "        \"brandId\": \"1 - ZARA\",\n" + "        \"rate\": \"1\",\n"
						+ "        \"applicationStartDate\": \"2020-06-14-00.00.00\",\n"
						+ "        \"applicationEndDate\": \"2020-12-31-23.59.59\",\n"
						+ "        \"price\": \"35,50\"\n" + "    },\n" + "    {\n"
						+ "        \"productId\": \"35455\",\n" + "        \"brandId\": \"1 - ZARA\",\n"
						+ "        \"rate\": \"3\",\n" + "        \"applicationStartDate\": \"2020-06-15-00.00.00\",\n"
						+ "        \"applicationEndDate\": \"2020-06-15-11.00.00\",\n"
						+ "        \"price\": \"30,50\"\n" + "    }\n" + "]"));
	}

//	Test 5: petición a las 21:00 del día 16 del producto 35455
//	para la brand 1 (ZARA)
	@Test
	void getRatesAndPricesValidRequestTest5() throws JsonProcessingException, Exception {

		RatesAndPricesInputDTO ratesAndPricesInputDTO = RatesAndPricesInputDTO.builder().brandId("1").productId("35455")
				.aplicationDate("2020-06-16-21.00.00").build();

		mockMvc.perform(get(FIND_PRICES_CONTEXT)
				.contentType(CONTENT_TYPE).content(objectMapper.writeValueAsString(ratesAndPricesInputDTO)))
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().json("[\n" + "    {\n" + "        \"productId\": \"35455\",\n"
						+ "        \"brandId\": \"1 - ZARA\",\n" + "        \"rate\": \"1\",\n"
						+ "        \"applicationStartDate\": \"2020-06-14-00.00.00\",\n"
						+ "        \"applicationEndDate\": \"2020-12-31-23.59.59\",\n"
						+ "        \"price\": \"35,50\"\n" + "    },\n" + "    {\n"
						+ "        \"productId\": \"35455\",\n" + "        \"brandId\": \"1 - ZARA\",\n"
						+ "        \"rate\": \"4\",\n" + "        \"applicationStartDate\": \"2020-06-15-16.00.00\",\n"
						+ "        \"applicationEndDate\": \"2020-12-31-23.59.59\",\n"
						+ "        \"price\": \"38,95\"\n" + "    }\n" + "]"));
	}

}
