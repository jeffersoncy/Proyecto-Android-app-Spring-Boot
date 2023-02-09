package app.unicauca.cdu.controllers;

import java.util.List;
import java.util.stream.Collectors;

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

import app.unicauca.cdu.models.Programa;
import app.unicauca.cdu.repositories.ProgramaRepository;


@RestController
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false")
@RequestMapping("/api")
public class ProgramaRestController {

    @Autowired
    private ProgramaRepository programaService;
    
    @GetMapping("/programas/{id}")
    public Programa findById(@PathVariable Integer id) {
    	Programa programa = this.programaService.findById(id).orElse(null);
        return programa;
    }
    
    @GetMapping("/programas/nombre/{nombre}")
    public Programa findByNombre(@PathVariable String nombre) {
        return this.findAll().stream().filter(p-> p.getPro_nombre().equals(nombre)==true).collect(Collectors.toList()).get(0);
    }
    
    @GetMapping("/programas")
    public List<Programa> findAll() {
        return this.programaService.findAll();
    }
    
    @PostMapping("/programas")
    public Programa create(@RequestBody Programa programa) {
        return programaService.save(programa);
    }
    
    @PutMapping("/programas/{id}")
    public Programa edit(@PathVariable int id,@RequestBody Programa programa) {
        return this.programaService.save(programa);
    }
    
    @DeleteMapping("/programas/{id}")
    public boolean remove(@PathVariable int id) {
        this.programaService.deleteById(id);
        return true;
    }
    
    
}
