package com.duagon.ratesandpricesreporter.dao;

import org.springframework.data.repository.CrudRepository;

import com.duagon.ratesandpricesreporter.entities.Prices;

public interface IPricesDao extends CrudRepository<Prices, Long> {

}
