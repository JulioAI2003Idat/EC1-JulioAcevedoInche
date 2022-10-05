package ec1.service;

import java.util.List;

import ec1.model.Profesor;

public interface ProfesorService {

	void guardar(Profesor profesor);
	void actualizar(Profesor profesor);
	void eliminar(Integer id);
	List<Profesor> listar();
	Profesor obtener(Integer id);
}
