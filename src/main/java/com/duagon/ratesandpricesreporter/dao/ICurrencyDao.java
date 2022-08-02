package com.duagon.ratesandpricesreporter.dao;

import org.springframework.data.repository.CrudRepository;

import com.duagon.ratesandpricesreporter.entities.Currencies;

public interface ICurrencyDao extends CrudRepository<Currencies, Long> {

}
