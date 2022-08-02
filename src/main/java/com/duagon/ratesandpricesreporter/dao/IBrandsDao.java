package com.duagon.ratesandpricesreporter.dao;

import org.springframework.data.repository.CrudRepository;

import com.duagon.ratesandpricesreporter.entities.Brands;

public interface IBrandsDao extends CrudRepository<Brands, Long> {

}
