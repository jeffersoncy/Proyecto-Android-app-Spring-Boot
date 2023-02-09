package app.unicauca.cdu.services;

import java.util.List;

import app.unicauca.cdu.models.ImageModel;
import app.unicauca.cdu.models.Usuario2;

public interface IUsuarioService {
	
	public Usuario2 findById(long id);
	public List<Usuario2> findAll();
	public Usuario2 save(Usuario2 usuario2);
	public List<Usuario2> saveAll(List<Usuario2> usuario2s);
	public Usuario2 edit(long id, Usuario2 usuario2);
	public boolean remove(long id);
	
}
