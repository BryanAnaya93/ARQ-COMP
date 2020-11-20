package com.dashboard.daoInterfaces;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dashboard.models.Medicion;


public interface IMedicionDao extends CrudRepository<Medicion, Integer> {
	
	@Query(value = "{call getPromGeneral()}", nativeQuery = true)
	double getPromedioGeneral();

	@Query(value = "{call getTotalMediciones()}", nativeQuery = true)
	int getTotalMediciones();
	
	@Query(value = "{call getPromMediciones(:dispositivos, :fec_inicio, :fec_fin)}", nativeQuery = true)
	List<Medicion> getMedicionesFiltradas(
			@Param("dispositivos") String dispositivos,
			@Param("fec_inicio") Timestamp fec_inicio,
			@Param("fec_fin") Timestamp fec_fin
			);

}
