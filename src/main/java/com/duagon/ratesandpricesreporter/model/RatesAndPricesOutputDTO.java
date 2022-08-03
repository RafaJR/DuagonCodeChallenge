package com.duagon.ratesandpricesreporter.model;

import javax.validation.constraints.NotNull;

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

	@NotNull
	String aplicationDate;
	@NotNull
	String productId;
	@NotNull
	String brandId;

}
