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

@Entity(name = "Products")
@Table(name = "T_PRODUCTS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_PRODUCT")
	private Long idProduct;
	@Column(name = "PRODUCT_CODE_ID", unique = true, nullable = false)
	private String productCodeId;
	@Column(name = "PRODUCT_NAME", length = 25, unique = true, nullable = false)
	@Size(min = 1, max = 25)
	private String productName;
	@Column(name = "PRODUCT_DESCRIPTION", length = 100)
	@Size(min = 1, max = 100)
	private String productDescription;

}
