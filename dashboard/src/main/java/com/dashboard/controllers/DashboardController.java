package com.dashboard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.models.Dispositivo;
import com.dashboard.models.Filtro;
import com.dashboard.models.Medicion;
import com.dashboard.models.Usuario;
import com.dashboard.services.IEntityService;
import com.dashboard.services.MedicionServiceImp;

@RestController
@CrossOrigin
@RequestMapping({"/dashboard"})
public class DashboardController {

	@Autowired
	private IEntityService<Usuario, Integer> sUsuario;
	
	@Autowired
	private IEntityService<Dispositivo, Integer> sDispositivo;
	
	@Autowired
	private MedicionServiceImp sMedicion;
	
	
	@PostMapping("/usuarios")
	public void crearUsuario(@RequestBody Usuario usuario) {
		System.out.println("Se realiza el envio de un usuario:"+usuario);
		sUsuario.save(usuario);
	}
	
	@GetMapping("/usuarios")
	public List<Usuario> consultarUsuarios(){		
		List<Usuario> usuarios = sUsuario.getAll();
		return usuarios;
	}
	
	
	@PostMapping("/loggin")
	public Usuario iniciarSession(@RequestBody Usuario usuario){		
		List<Usuario> usuarios = sUsuario.getAll();
		
		for(Usuario user : usuarios) {
			if(user.getUsuario().equals(usuario.getUsuario()) && user.getClave().equals(usuario.getClave())) {
				return user;
			}
		}
		return null;
	}
	
	@PostMapping("/dispositivos")
	public Dispositivo crearDispositivo(@RequestBody Dispositivo dispositivo) {
		System.out.println("Se realiza el envio de un usuario:"+dispositivo);
		return sDispositivo.save(dispositivo);
	}
	
	@GetMapping("/dispositivos")
	public List<Dispositivo> consultarDispositivos(){		
		List<Dispositivo> dispositivo = sDispositivo.getAll();
		return dispositivo;
	}
	
	@PutMapping("/dispositivos/{id}")
	public String editarDispositivo(@RequestBody Dispositivo dispositivo, @PathVariable int id) {
		Dispositivo temp = sDispositivo.getById(id).orElse(null);		
		temp.setCodigo(dispositivo.getCodigo());
		temp.setUbicacion(dispositivo.getUbicacion());
		temp.setLatitud(dispositivo.getLatitud());
		temp.setLongitud(dispositivo.getLongitud());
		
		return sDispositivo.save(temp) != null ? "edited" : "err";
	}
	
	@DeleteMapping("/dispositivos")
	public void eliminarDispositivo(@PathVariable int id) {
		sDispositivo.delete(id);
	}
	
	@GetMapping("/medicion")
	public List<Medicion> consultarMediciones(){		
		return (List<Medicion>) sMedicion.getAll();
	}
	
	@GetMapping("/promedio")
	public ResponseEntity<Double> consultarPromedioGeneral(){		
		return new ResponseEntity<Double>(sMedicion.getPromedioGeneral(), HttpStatus.OK);
	}
	
	@GetMapping("/total")
	public ResponseEntity<Integer> consultarTotalMediciones(){		
		return new ResponseEntity<Integer>(sMedicion.getTotalMediciones(), HttpStatus.OK);
	}
	
	@PostMapping("/mediciones")
	public ResponseEntity<List<Medicion>> consultarMedicionesFiltradas(@RequestBody Filtro filtro){
		List<Medicion> res = (List<Medicion>) sMedicion.getMedicionesFiltradas(
				filtro.getDispositivos(), filtro.getFec_inicio(), filtro.getFec_fin());
				
		return new ResponseEntity<List<Medicion>>(res, HttpStatus.OK);
	}
	
}
