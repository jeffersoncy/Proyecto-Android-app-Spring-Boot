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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.unicauca.cdu.models.Horario;
import app.unicauca.cdu.models.PK_Horario;
import app.unicauca.cdu.repositories.HorarioRepository;


@RestController
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false")
@RequestMapping("/api")
public class HorarioRestController {

    @Autowired
    private HorarioRepository horarioService;
    
    @GetMapping("/horario")
    public Horario findById(@RequestParam("hi") int hi,@RequestParam("hf") int hf,@RequestParam("fi") String fi,
    		@RequestParam("ff") String ff,@RequestParam("dia") String dia,@RequestParam("esc") String esc) {
    	
    	PK_Horario pk_horario = new PK_Horario();
    	pk_horario.setHor_hora_inicio(hi);
    	pk_horario.setHor_hora_fin(hf);
    	pk_horario.setHor_fecha_inicio(fi);
    	pk_horario.setHor_fecha_fin(ff);
    	pk_horario.setHor_dia(dia);
    	pk_horario.setEsc_nombre(esc);
    	
    	Horario horario = this.horarioService.findById(pk_horario).orElse(null);
        return horario;
    }
    
    @GetMapping("/horarios/escenario/{esc}")
    public List<Horario> findByEscenario(@PathVariable String esc) {
        return this.horarioService.findAll().stream().filter( h ->  h.getPk_horario().getEsc_nombre().equals(esc)==true).collect(Collectors.toList());
    }
    
    @GetMapping("/horarios")
    public List<Horario> findAll() {
        return this.horarioService.findAll();
    }
    
    @PostMapping("/horarios")
    public Horario create(@RequestBody Horario horario) {
    	
        return horarioService.save(horario);
    }
    
    @PutMapping("/horarios/{id}")
    public Horario edit(@PathVariable int id,@RequestBody Horario horario) {
    	
        return this.horarioService.save(horario);
    }
    
    @DeleteMapping("/horarios")
    public boolean remove(@RequestParam("hi") int hi,@RequestParam("hf") int hf,@RequestParam("fi") String fi,
    		@RequestParam("ff") String ff,@RequestParam("dia") String dia,@RequestParam("esc") String esc) {
        //this.horarioService.deleteById(id);
    	PK_Horario pk_horario = new PK_Horario();
    	pk_horario.setHor_hora_inicio(hi);
    	pk_horario.setHor_hora_fin(hf);
    	pk_horario.setHor_fecha_inicio(fi);
    	pk_horario.setHor_fecha_fin(ff);
    	pk_horario.setHor_dia(dia);
    	pk_horario.setEsc_nombre(esc);
    	
    	this.horarioService.deleteById(pk_horario);
        return true;
    }
    
}
