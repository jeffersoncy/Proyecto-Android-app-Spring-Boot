 package app.unicauca.cdu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import app.unicauca.cdu.models.Horario;
import app.unicauca.cdu.models.PK_Horario;
public interface HorarioRepository extends JpaRepository<Horario, PK_Horario>{
	//Optional<ImageModel> findByName(String name);
	//void deleteByName(String name);
}
