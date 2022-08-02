package com.duagon.ratesandpricesreporter.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "Prices")
@Table(name = "T_PRICES")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Prices {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_PRICE")
	private Long idPrice;
	@Column(name = "PRICE")
	private Double price;
	@Column(name = "PRIORITY")
	private Integer priority;
	@Column(name = "START_DATE")
	private LocalDateTime startDate;
	@Column(name = "END_DATE")
	private LocalDateTime endDate;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_BRAND_ID", nullable = false)
	private Brands fkBrandId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_PRODUCT_ID", nullable = false)
	private Products fkProductId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_CURRENCY_ID", nullable = false)
	private Currencies fkCurrencyId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_RATE_ID", nullable = false)
	private Rates fkRatesId;

}
