package com.dashboard.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dashboard.daoInterfaces.IMedicionDao;
import com.dashboard.models.Medicion;


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
		// TODO Auto-generated method 
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
	
	@Transactional
	public double getPromedioGeneral() {
		return medicionDao.getPromedioGeneral();
	}
	
	@Transactional
	public int getTotalMediciones() {
		return medicionDao.getTotalMediciones();
	}
	
	@Transactional
	public List<Medicion> getMedicionesFiltradas(
			String dispositivos, Timestamp fec_inicio, Timestamp fec_fin){
		return (List<Medicion>) medicionDao.getMedicionesFiltradas(dispositivos, fec_inicio, fec_fin); 
	}

}
