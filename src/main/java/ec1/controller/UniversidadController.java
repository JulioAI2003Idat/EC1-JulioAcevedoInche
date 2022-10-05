package ec1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import ec1.model.Curso;
import ec1.model.Universidad;
import ec1.service.CursoService;
import ec1.service.UniversidadService;

@RestController
@RequestMapping("/curso")
public class UniversidadController {
	
	@Autowired
	private UniversidadService service;
	
	@RequestMapping(path= "", method = RequestMethod.GET)
	public ResponseEntity<?> listar(){
		List<Universidad> listacursos = service.listar();
		return new ResponseEntity<>(listacursos,HttpStatus.OK);
	}
	
	@RequestMapping(path= "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?>buscarporid(@PathVariable Integer id){
		Universidad universidad = service.obtener(id);
		if (universidad!= null) {
			return new ResponseEntity<>(universidad,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(universidad,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("")
	public ResponseEntity<?> registrar(@RequestBody Universidad universidad){
		service.guardar(universidad);
		return new ResponseEntity<>(universidad,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody Universidad u,@PathVariable Integer id){
		
		Universidad universidad = service.obtener(u.getIduniversidad());
		if (universidad!= null) {
			service.actualizar(universidad);
			return new ResponseEntity<>(universidad,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(universidad,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id){
		Universidad universidad = service.obtener(id);
		if (universidad!= null) {
			service.eliminar(id);
			return new ResponseEntity<>(id,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(id,HttpStatus.NOT_FOUND);
		}
	}
	

}
