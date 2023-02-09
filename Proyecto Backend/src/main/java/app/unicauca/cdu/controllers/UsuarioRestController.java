package app.unicauca.cdu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import app.unicauca.cdu.models.Usuario;
import app.unicauca.cdu.repositories.UsuarioRepository;

@RestController
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false")
@RequestMapping("/api")
public class UsuarioRestController {

    @Autowired
    private UsuarioRepository usuarioService;

    @GetMapping("/usuarios/{id}")
    public Usuario findById(@PathVariable long id) {
    	Usuario userFind = this.usuarioService.findById(id).orElse(null);
    	
        return userFind;
    }
    
    @GetMapping("/usuarios")
    public List<Usuario> findAll() {
        return this.usuarioService.findAll();
    }
    
    @PostMapping("/usuarios")
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PostMapping("/usuarios/all")
    public List<Usuario> createAll(@RequestBody List<Usuario> usuarios) {
    	//System.out.println("Invocando crear usuario");
        return this.usuarioService.saveAll(usuarios);
    }
    
    @PutMapping("/usuarios/{id}")
    public Usuario edit(@PathVariable long id,@RequestBody Usuario usuario) {
        return this.usuarioService.save(usuario);
    }
    
    @DeleteMapping("/usuarios/{id}")
    public boolean edit(@PathVariable long id) {
       this.usuarioService.deleteById(id);
       return true;
    }
    
    
    
    
}
