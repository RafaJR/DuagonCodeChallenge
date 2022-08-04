package com.duagon.ratesandpricesreporter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RatesAndPricesOutputDTO {

	String productId;
	String brandId;
	String rate;
	String applicationStartDate;
	String applicationEndDate;
	String price;

}
