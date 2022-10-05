package ec1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec1.model.Malla_Curricular;
import ec1.repository.MallaRepository;


@Service
public class MallaServiceImpl implements MallaService{

	@Autowired
	MallaRepository repositorio;
	
	@Override
	public void guardar(Malla_Curricular malla) {
		repositorio.save(malla);
	}

	@Override
	public void actualizar(Malla_Curricular malla) {
		repositorio.saveAndFlush(malla);
		
	}

	@Override
	public void eliminar(Integer id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public List<Malla_Curricular> listar() {
		return repositorio.findAll();
	}

	@Override
	public Malla_Curricular obtener(Integer id) {
		
		return repositorio.findById(id).orElse(null);
	}

}
