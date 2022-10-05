package ec1.service;

import java.util.List;

import ec1.model.Universidad;

public interface UniversidadService {

	void guardar(Universidad uni);
	void actualizar(Universidad uni);
	void eliminar(Integer id);
	List<Universidad> listar();
	Universidad obtener(Integer id);
}
