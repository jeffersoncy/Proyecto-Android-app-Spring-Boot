package app.unicauca.cdu.controllers;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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

import app.unicauca.cdu.models.Escenario;
import app.unicauca.cdu.repositories.EscenarioRepository;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false")
@RequestMapping("/api")
public class EscenarioRestController {

    @Autowired
    private EscenarioRepository escenarioService;

    @GetMapping("/escenarios/{id}")
    public Escenario findById(@PathVariable String id) {
    	Escenario escenarioVacio = new Escenario();
    	escenarioVacio.setEsc_nombre("-1");
    	escenarioVacio.setEsc_estado('0');
    	Escenario escenario = this.escenarioService.findById(id).orElse(escenarioVacio);
    	/*
    	if (escenario!=null && escenario.getEsc_foto()!=null) {
    		escenario.setEsc_foto(decompressBytes(escenario.getEsc_foto())); 
		}
		*/
        return escenario;
    }
    
    @GetMapping("/escenarios")
    public List<Escenario> findAll() {
    	
    	List<Escenario> lista = this.escenarioService.findAll();
    	/*
    	for (int i = 0; i < lista.size(); i++) {
    		if (lista.get(i).getEsc_foto()!=null) {
    			lista.get(i).setEsc_foto(decompressBytes(lista.get(i).getEsc_foto()));
			}
			
		}
    	*/
        return lista;
    }
    
    @PostMapping("/escenarios")
    public Escenario create(@RequestBody Escenario escenario) {
    	/*
    	if (escenario!=null && escenario.getEsc_foto()!=null) {
    		escenario.setEsc_foto(compressBytes(escenario.getEsc_foto())); 
		}
		*/
    	escenario.setEsc_nombre(escenario.getEsc_nombre().toUpperCase());
        return escenarioService.save(escenario);
    }
    

    @PostMapping("/escenarios/all")
    public List<Escenario> createAll(@RequestBody List<Escenario> escenarios) {
    	//System.out.println("Invocando crear Escenario");
        return this.escenarioService.saveAll(escenarios);
    }
    
    @PutMapping("/escenarios/{id}")
    public Escenario edit(@PathVariable String id,@RequestBody Escenario escenario) {
    	
    	if(!id.equals(escenario.getEsc_nombre())) {
    		this.escenarioService.deleteById(id);
    	}
    	escenario.setEsc_nombre(escenario.getEsc_nombre().toUpperCase());
    	/*
    	if (escenario!=null && escenario.getEsc_foto()!=null) {
    		escenario.setEsc_foto(compressBytes(escenario.getEsc_foto())); 
		}*/
        return this.escenarioService.save(escenario);
    }
    
    @DeleteMapping("/escenarios/{id}")
    public boolean remove(@PathVariable String id) {
        this.escenarioService.deleteById(id);
        return true;
    }

	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}
    
    
}
