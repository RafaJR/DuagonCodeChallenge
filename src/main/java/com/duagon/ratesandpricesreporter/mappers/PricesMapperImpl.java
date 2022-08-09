package com.duagon.ratesandpricesreporter.mappers;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.duagon.ratesandpricesreporter.constants.RatesAndPricesConstants;
import com.duagon.ratesandpricesreporter.entities.Prices;
import com.duagon.ratesandpricesreporter.model.RatesAndPricesOutputDTO;

@Component
public class PricesMapperImpl implements IPricesMapper {

	/**
	 * @param ratesAndPricesOutputDTO
	 * @return Optional<RatesAndPricesOutputDTO> Convert a 'Prices' entity to
	 *         'RatesAndPricesOutputDTO' to build the endpoint response
	 */
	@Override
	public Optional<RatesAndPricesOutputDTO> mapFromPricesToPricesAndRatesOutputDTO(Prices prices) {

		if (isValid(prices)) {

			return Optional.of(RatesAndPricesOutputDTO.builder()
					.applicationEndDate(prices.getEndDate().format(RatesAndPricesConstants.DATE_FORMAT))
					.applicationStartDate(prices.getStartDate().format(RatesAndPricesConstants.DATE_FORMAT))
					.brandId(String.format("%s - %s", prices.getFkBrandId().getBrandCode(),
							prices.getFkBrandId().getBrandName()))
					.price(String.format(RatesAndPricesConstants.MONETARY_FIGURE_FORMAT, prices.getPrice()))
					.productId(prices.getFkProductId().getProductCodeId()).rate(prices.getFkRatesId().getRateCode())
					.build());

		} else {

			return Optional.empty();
		}

	}

	private boolean isValid(Prices prices) {

		return prices != null && prices.getStartDate() != null && prices.getEndDate() != null
				&& prices.getStartDate().isBefore(prices.getEndDate()) && prices.getFkBrandId() != null
				&& prices.getFkBrandId().getBrandCode() != null && prices.getFkCurrencyId() != null
				&& prices.getFkCurrencyId().getCurrencyISO() != null && prices.getFkProductId() != null
				&& prices.getFkProductId().getProductCodeId() != null && prices.getFkRatesId() != null
				&& prices.getFkRatesId().getRateCode() != null && prices.getPrice() != null
				&& prices.getPriority() != null;

	}

}
