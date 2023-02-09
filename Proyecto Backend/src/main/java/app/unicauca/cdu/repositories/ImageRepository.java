package app.unicauca.cdu.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.unicauca.cdu.models.ImageModel;
public interface ImageRepository extends JpaRepository<ImageModel, String>{
	//Optional<ImageModel> findByName(String name);
	
	
	@Query(value = "SELECT * FROM image_table i WHERE i.name=:nombre;", nativeQuery=true)
    ImageModel findImgByName(String nombre);
	//void deleteByName(String name);
}
