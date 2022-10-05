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
import ec1.model.Malla_Curricular;
import ec1.service.CursoService;
import ec1.service.MallaService;

@RestController
@RequestMapping("/malla")
public class MallaController {
	
	@Autowired
	private MallaService service;
	
	@RequestMapping(path= "", method = RequestMethod.GET)
	public ResponseEntity<?> listar(){
		List<Malla_Curricular> listamalla = service.listar();
		return new ResponseEntity<>(listamalla,HttpStatus.OK);
	}
	
	@RequestMapping(path= "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?>buscarporid(@PathVariable Integer id){
		Malla_Curricular malla = service.obtener(id);
		if (malla!= null) {
			return new ResponseEntity<>(malla,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(malla,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("")
	public ResponseEntity<?> registrar(@RequestBody Malla_Curricular malla){
		service.guardar(malla);
		return new ResponseEntity<>(malla,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody Malla_Curricular m,@PathVariable Integer id){
		
		Malla_Curricular malla = service.obtener(m.getIdmalla());
		if (malla!= null) {
			service.actualizar(malla);
			return new ResponseEntity<>(malla,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(malla,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id){
		Malla_Curricular malla = service.obtener(id);
		if (malla!= null) {
			service.eliminar(id);
			return new ResponseEntity<>(id,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(id,HttpStatus.NOT_FOUND);
		}
	}
	

}
