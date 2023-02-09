package app.unicauca.cdu.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.unicauca.cdu.models.ImageModel;
import app.unicauca.cdu.models.Usuario2;
import app.unicauca.cdu.repositories.UsuarioRepository2;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private UsuarioRepository2 servicioAccesoBaseDatos;

	@Override
	public Usuario2 findById(long id) {
		// TODO Auto-generated method stub
		return this.servicioAccesoBaseDatos.findById(id);
	}

	@Override
	public List<Usuario2> findAll() {
		// TODO Auto-generated method stub
		return this.servicioAccesoBaseDatos.findAll();
	}

	@Override
	public Usuario2 save(Usuario2 usuario2) {
		// TODO Auto-generated method stub
		return this.servicioAccesoBaseDatos.save(usuario2);
	}

	@Override
	public List<Usuario2> saveAll(List<Usuario2> usuario2s) {
		// TODO Auto-generated method stub
		return this.servicioAccesoBaseDatos.saveAll(usuario2s);
	}

	@Override
	public Usuario2 edit(long id, Usuario2 usuario2) {
		// TODO Auto-generated method stub
		return this.servicioAccesoBaseDatos.edit(id, usuario2);
	}

	@Override
	public boolean remove(long id) {
		// TODO Auto-generated method stub
		return this.servicioAccesoBaseDatos.remove(id);
	}


}
