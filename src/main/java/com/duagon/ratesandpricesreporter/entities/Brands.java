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

@Entity(name = "Brands")
@Table(name = "T_BRANDS")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Brands {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_BRAND")
	private Long idBrand;
	@Column(name = "BRAND_NAME", length = 25)
	@Size(min = 1, max = 25)
	private String brandName;
	@Column(name = "BRAND_DESCRIPTION", length = 100)
	@Size(min = 1, max = 100)
	private String brandDescription;

}
