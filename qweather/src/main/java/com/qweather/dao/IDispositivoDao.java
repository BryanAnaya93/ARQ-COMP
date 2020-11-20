package com.qweather.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qweather.models.Dispositivo;

@Repository
public interface IDispositivoDao extends CrudRepository<Dispositivo, Integer> {

}
