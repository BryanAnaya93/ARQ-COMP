package com.qweather.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qweather.dao.IDispositivoDao;
import com.qweather.models.Dispositivo;

@Service
@Transactional
public class DispositivoServiceImp implements IEntityService<Dispositivo, Integer>{

	@Autowired
	private IDispositivoDao dispositivoDao;
	
	@Override
	public List<Dispositivo> getAll() {
		// TODO Auto-generated method stub
		return (List<Dispositivo>) dispositivoDao.findAll();
	}

	@Override
	public Optional<Dispositivo> getById(int id) {
		// TODO Auto-generated method stub
		return dispositivoDao.findById(id);
	}

	@Override
	public Dispositivo save(Dispositivo t) {
		// TODO Auto-generated method stub
		return dispositivoDao.save(t);
	}

	@Override
	public Dispositivo update(Dispositivo t) {
		// TODO Auto-generated method stub
		return dispositivoDao.save(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dispositivoDao.deleteById(id);
	}

}
