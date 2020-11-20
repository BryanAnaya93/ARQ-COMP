package com.qweather.dao;

import org.springframework.data.repository.CrudRepository;

import com.qweather.models.Medicion;

public interface IMedicionDao extends CrudRepository<Medicion, Integer> {
	
}
