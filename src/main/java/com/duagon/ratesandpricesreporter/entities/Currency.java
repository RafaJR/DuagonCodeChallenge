package com.duagon.ratesandpricesreporter.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "Currency")
@Table(name = "T_CURRENCY")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Currency {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_CURRENCY")
	private Long idCurrency;
	@Column(name = "CURRENCY_ISO", unique = true, nullable = false, length = 3)
	@Size(min = 3, max = 3)
	private String currencyISO;

}
