package ec1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec1.model.Profesor;
import ec1.repository.ProfesorRepository;


@Service
public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	private ProfesorRepository repositorio;
	
	@Override
	public void guardar(Profesor profesor) {
		repositorio.save(profesor);
		
	}

	@Override
	public void actualizar(Profesor profesor) {
		repositorio.saveAndFlush(profesor);
		
	}

	@Override
	public void eliminar(Integer id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public List<Profesor> listar() {
		return repositorio.findAll();
	}

	@Override
	public Profesor obtener(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

}
