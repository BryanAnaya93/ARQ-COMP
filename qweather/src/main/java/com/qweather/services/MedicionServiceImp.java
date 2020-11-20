package com.qweather.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qweather.dao.IMedicionDao;
import com.qweather.models.Medicion;

@Service
@Transactional
public class MedicionServiceImp implements IEntityService<Medicion, Integer>{

	@Autowired
	private IMedicionDao medicionDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Medicion> getAll() {
		// TODO Auto-generated method stub
		return (List<Medicion>) medicionDao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Medicion> getById(int id) {
		// TODO Auto-generated method stub
		return medicionDao.findById(id);
	}

	@Transactional
	@Override
	public Medicion save(Medicion t) {
		// TODO Auto-generated method stub
		return medicionDao.save(t);
	}

	@Transactional
	@Override
	public Medicion update(Medicion t) {
		// TODO Auto-generated method stub
		return medicionDao.save(t);
	}

	@Transactional
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		medicionDao.deleteById(id);
	}
	
	/*
	@Transactional
	public List<Medicion> consultarMediciones(String dispositivos, String fecha_ini, String fecha_fin) {
		return medicionDao.consultaDashboard(dispositivos, fecha_ini, fecha_fin);
	}
	*/
}
