package com.qweather.services;

import java.util.List;
import java.util.Optional;

public interface IEntityService<T,ID> {
	
	List<T> getAll();
	
	Optional<T> getById(int id);
	
	T save(T t) ;
	
	T update(T t);
	
	void delete(int id);
	
}
