 package app.unicauca.cdu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import app.unicauca.cdu.models.Usuario;
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	//Optional<ImageModel> findByName(String name);
	//void deleteByName(String name);
}
