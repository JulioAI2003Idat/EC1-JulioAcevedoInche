package ec1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec1.model.Malla_Curricular;

@Repository
public interface MallaRepository extends JpaRepository<Malla_Curricular, Integer> {

}
