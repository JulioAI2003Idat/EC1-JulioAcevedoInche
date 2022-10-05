package ec1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec1.model.Universidad;
import ec1.repository.UniversidadRepository;


@Service
public class UniversidadServiceImpl implements UniversidadService{
	
	@Autowired
	UniversidadRepository repositorio;

	@Override
	public void guardar(Universidad uni) {
		repositorio.save(uni);
		
	}

	@Override
	public void actualizar(Universidad uni) {
		repositorio.saveAndFlush(uni);
		
	}

	@Override
	public void eliminar(Integer id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public List<Universidad> listar() {
		return repositorio.findAll();
	}

	@Override
	public Universidad obtener(Integer id) {

		return repositorio.findById(id).orElse(null);
	}

}
