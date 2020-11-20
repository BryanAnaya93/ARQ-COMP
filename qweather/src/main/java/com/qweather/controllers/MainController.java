package com.qweather.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qweather.models.Medicion;
import com.qweather.services.MedicionServiceImp;

@RestController
@CrossOrigin
@RequestMapping({"/api"})
public class MainController {

	@Autowired
	private MedicionServiceImp sMedicion;
	
	@PostMapping("/medicion")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Medicion almacenarMedicion(@RequestBody Medicion medicion) {
		Medicion newReg = sMedicion.save(medicion);
		
		/*Calendar cal = Calendar.getInstance();
		
		cal.setTime(medicion.getTiempo().getTime());
		
		System.out.println(cal.getTime());
		
		cal.set(Calendar.DAY_OF_MONTH, 15);
		cal.set(Calendar.MONTH, 10);
		
		cal.set(Calendar.HOUR_OF_DAY, 16);
		cal.set(Calendar.SECOND, 30);
		cal.set(Calendar.MINUTE, 30);
		
		System.out.println(cal.getTime());
		
		System.out.println("se registrará la siguiente medicion:"+medicion);
		
		if(newReg == null) {
			System.out.println("Error al guardar la medición");
		}else {
			System.out.println("se registró la siguiente medicion:"+newReg);
		}
		*/
		return newReg;
	}	

	@GetMapping("/medicion")
	public List<Medicion> consultar(){		
		return (List<Medicion>) sMedicion.getAll();
	}
	
	
}
