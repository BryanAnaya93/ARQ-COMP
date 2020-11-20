package com.dashboard.daoInterfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dashboard.models.Usuario;


@Repository
public interface IUsuarioDao extends CrudRepository<Usuario, Integer>{

}
