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

@Entity(name = "Rates")
@Table(name = "T_RATES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Rates {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_RATE")
	private Long idRate;
	@Column(name = "RATE_CODE", unique = true, nullable = false, length = 10)
	@Size(min = 1, max = 10)
	private String rateCode;

}
