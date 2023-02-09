 package app.unicauca.cdu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.unicauca.cdu.models.Categoria;
public interface CategoriaRepository extends JpaRepository<Categoria, String>{
	//Optional<ImageModel> findByName(String name);
	//void deleteByName(String name);
}
