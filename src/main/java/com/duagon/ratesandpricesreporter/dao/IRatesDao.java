package com.duagon.ratesandpricesreporter.dao;

import org.springframework.data.repository.CrudRepository;

import com.duagon.ratesandpricesreporter.entities.Rates;

public interface IRatesDao extends CrudRepository<Rates, Long> {

}
