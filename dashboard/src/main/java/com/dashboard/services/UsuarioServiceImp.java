package com.dashboard.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dashboard.daoInterfaces.IUsuarioDao;
import com.dashboard.models.Usuario;

@Service
@Transactional
public class UsuarioServiceImp implements IEntityService<Usuario, Integer>{

	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> getById(int id) {
		// TODO Auto-generated method stub
		return usuarioDao.findById(id);
	}

	@Override
	@Transactional
	public Usuario save(Usuario t){
		// TODO Auto-generated method stub
		return usuarioDao.save(t);
	}

	@Override
	@Transactional
	public Usuario update(Usuario t) {
		// TODO Auto-generated method stub
		return usuarioDao.save(t);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		usuarioDao.deleteById(id);
	}
	
	
	
}
