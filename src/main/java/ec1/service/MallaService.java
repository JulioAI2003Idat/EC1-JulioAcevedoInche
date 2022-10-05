package ec1.service;

import java.util.List;

import ec1.model.Malla_Curricular;

public interface MallaService {

	void guardar(Malla_Curricular malla);
	void actualizar(Malla_Curricular malla);
	void eliminar(Integer id);
	List<Malla_Curricular> listar();
	Malla_Curricular obtener(Integer id);
}
