 package app.unicauca.cdu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.unicauca.cdu.models.Programa;
public interface ProgramaRepository extends JpaRepository<Programa, Integer>{
	//Optional<ImageModel> findByName(String name);
	//void deleteByName(String name);
}
