package com.duagon.ratesandpricesreporter.dao;

import org.springframework.data.repository.CrudRepository;

import com.duagon.ratesandpricesreporter.entities.Products;

public interface IProductsDao extends CrudRepository<Products, Long> {

}
