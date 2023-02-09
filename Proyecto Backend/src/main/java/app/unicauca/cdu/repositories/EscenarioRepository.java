package app.unicauca.cdu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.unicauca.cdu.models.Escenario;
public interface EscenarioRepository extends JpaRepository<Escenario, String>{
	//Optional<ImageModel> findByName(String name);
	//void deleteByName(String name);
}
