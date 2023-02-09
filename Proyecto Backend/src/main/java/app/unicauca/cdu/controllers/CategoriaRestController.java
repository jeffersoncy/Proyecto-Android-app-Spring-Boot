package app.unicauca.cdu.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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

import app.unicauca.cdu.models.Categoria;
import app.unicauca.cdu.models.Escenario;
import app.unicauca.cdu.repositories.CategoriaRepository;
import app.unicauca.cdu.repositories.EscenarioRepository;

import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false")
@RequestMapping("/api")
public class CategoriaRestController {

    @Autowired
    private CategoriaRepository categoriaService;

    @Autowired
    private EscenarioRepository escenarioService;
    
    @GetMapping("/categorias/{id}")
    public Categoria findById(@PathVariable String id) {
    	Categoria categoriaVacia = new Categoria();
    	categoriaVacia.setCat_nombre("-1");
    	Categoria categoria = this.categoriaService.findById(id).orElse(categoriaVacia);
//    	if (categoria!=null && categoria.getCat_foto()!=null) {
//    		categoria.setCat_foto(decompressBytes(categoria.getCat_foto())); 
//		}
        return categoria;
    }
    
    @GetMapping("/categorias/escenarios/{id}")
    public List<Escenario> findAllEscenariosByCat(@PathVariable String id) {
    	
    	List<Escenario> allEscenarios = this.escenarioService.findAll();
    	List<Escenario> result = new ArrayList<Escenario>();
    	if (!allEscenarios.isEmpty()) {
			for (Escenario escenario : allEscenarios) {
				if (escenario.getCategoria().getCat_nombre().equals(id)) {
					result.add(escenario);
				}
			}
		} 
        return result;
    }
    
    @GetMapping("/categorias")
    public List<Categoria> findAll() {
        return this.categoriaService.findAll();
    }
    
    @PostMapping("/categorias")
    public Categoria create(@RequestBody Categoria categoria) {
    	//if (categoria!=null && categoria.getCat_foto()!=null) {
    	//	categoria.setCat_foto(compressBytes(categoria.getCat_foto())); 
		//}
        return categoriaService.save(categoria);
    }

    @PostMapping("/categorias/all")
    public List<Categoria> createAll(@RequestBody List<Categoria> categorias) {
    	//System.out.println("Invocando crear Categoria");
        return this.categoriaService.saveAll(categorias);
    }
    
    @PutMapping("/categorias/{id}")
    public Categoria edit(@PathVariable String id,@RequestBody Categoria categoria) {
    	//Categoria categoriaEdit = this.categoriaService.getById(id);
//    	
//    	categoriaEdit.setCat_descripcion(categoria.getCat_descripcion());
//    	categoriaEdit.setCat_nombre(categoria.getCat_nombre());
    	
//    	if (categoria!=null && categoria.getCat_foto()!=null) {
//    		categoriaEdit.setCat_foto(compressBytes(categoria.getCat_foto())); 
//		}
    	
        return this.categoriaService.save(categoria);
    }
    
    @DeleteMapping("/categorias/{id}")
    public boolean remove(@PathVariable String id) {
        this.categoriaService.deleteById(id);
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
