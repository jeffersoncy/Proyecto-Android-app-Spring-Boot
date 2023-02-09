package app.unicauca.cdu.repositories;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import app.unicauca.cdu.models.ImageModel;
import app.unicauca.cdu.models.Usuario2;

@Service
public class UsuarioRepository2 {

    private HashMap<Long, Usuario2> usuario2s;
    
    public UsuarioRepository2() {
        this.usuario2s = new HashMap<Long, Usuario2>();
        this.cargarUsuarios();
    }
    
    private void cargarUsuarios() {
    	this.usuario2s.put(1059362874L, new Usuario2("Facultad de Artes", "Artes Plásticas", 100916010573L, 1059362874L, "JHAN CARLOS", "ACOSTA CHILITO", "jcchilito",null));
    }

    public List<Usuario2> findAll(){
    	List<Usuario2> v_usuarios = new ArrayList<Usuario2>();
    	for (Map.Entry<Long, Usuario2> entry : this.usuario2s.entrySet()) {
			v_usuarios.add(entry.getValue());	
		}
    	//System.out.println("Invocando findAll usuarios");
    	return v_usuarios;
    }
    
    public Usuario2 findById(long id) {
        //System.out.println("Invocando findById");
        Usuario2 v_usuario = this.usuario2s.get(id);
        if (v_usuario == null) {
            v_usuario = new Usuario2();
        }
        return v_usuario;
    }
    
    public Usuario2 save(Usuario2 usuario2) {
        if(this.usuario2s.get(usuario2.getIdentificacion())==null) {
        	this.usuario2s.put(usuario2.getIdentificacion(), usuario2);
        	return usuario2;
        }else {
        	return new Usuario2("", "", -1L, -1L, "", "", "",null);
        }
    }
    
    public Usuario2 edit(long id,Usuario2 usuario2) {
        if(this.usuario2s.get(id)!=null) {
        	this.usuario2s.remove(id);
        	this.usuario2s.put(usuario2.getIdentificacion(), usuario2);
        	return usuario2;
        }else {
        	return new Usuario2("", "", -1L, -1L, "", "", "",null);
        }
    }
    
    public List<Usuario2> saveAll(List<Usuario2> listaUsuarios){
    	for (Usuario2 usuario2 : listaUsuarios) {
			this.usuario2s.put(usuario2.getIdentificacion(), usuario2);
		}
    	return listaUsuarios;
    }
    
    public boolean remove(long id) {
    	return this.usuario2s.remove(id)!=null;
    }

}
