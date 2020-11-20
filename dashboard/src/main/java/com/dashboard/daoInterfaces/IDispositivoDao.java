package com.dashboard.daoInterfaces;

import org.springframework.stereotype.Repository;

import com.dashboard.models.Dispositivo;

import org.springframework.data.repository.CrudRepository;


@Repository
public interface IDispositivoDao extends CrudRepository<Dispositivo, Integer> {

}
