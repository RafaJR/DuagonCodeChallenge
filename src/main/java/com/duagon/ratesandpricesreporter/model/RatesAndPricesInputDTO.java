package com.duagon.ratesandpricesreporter.model;

import javax.validation.constraints.NotNull;

import com.duagon.ratesandpricesreporter.validation.IntegerValueAsStringConstraint;

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
public class RatesAndPricesInputDTO {

	@NotNull
	String aplicationDate;
	@NotNull
	@IntegerValueAsStringConstraint
	String productId;
	@NotNull
	@IntegerValueAsStringConstraint
	String brandId;
}
