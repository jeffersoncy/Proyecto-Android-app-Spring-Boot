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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import app.unicauca.cdu.models.ImageModel;
import app.unicauca.cdu.models.Usuario2;
import app.unicauca.cdu.repositories.ImageRepository;
import app.unicauca.cdu.services.IUsuarioService;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false")
@RequestMapping("/api/user")
public class UsuarioRestController2 {

    @Autowired
    private IUsuarioService usuarioService;
    
    @Autowired
	ImageRepository imageRepository;

    @GetMapping("/usuarios/{id}")
    public Usuario2 findById(@PathVariable long id) {
    	Usuario2 userFind = this.usuarioService.findById(id).clone();
    	if (userFind!=null && userFind.getImage()!=null && userFind.getImage().getPicByte()!=null) {
    		userFind.getImage().setPicByte(decompressBytes(userFind.getImage().getPicByte())); 
			System.out.println("entro a descomprimir");
		}
    	
        return userFind;
    }
    
    @GetMapping("/usuarios")
    public List<Usuario2> findAll() {
        return this.usuarioService.findAll();
    }
    
    @PostMapping("/usuarios")
    public Usuario2 create(@RequestBody Usuario2 usuario2) {
    	if (usuario2!=null && usuario2.getImage()!=null && usuario2.getImage().getPicByte()!=null) {
    		usuario2.getImage().setPicByte(compressBytes(usuario2.getImage().getPicByte())); 
		}
        return usuarioService.save(usuario2);
    }
    
    @PostMapping("/usuarios-image/{id}")
    public Usuario2 createImage(@RequestParam("imageFile") MultipartFile file,@PathVariable long id) {
    	System.out.println("Invocando crear usuario");
    	Usuario2 user = new Usuario2();
    	try {
    		ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),compressBytes(file.getBytes()));
    		user = this.usuarioService.findById(id);
    		user.setImage(img);
		} catch (Exception e) {
		}
    	
        return usuarioService.save(user);
    }

    @PostMapping("/usuarios/all")
    public List<Usuario2> createAll(@RequestBody List<Usuario2> usuario2s) {
    	//System.out.println("Invocando crear usuario");
        return this.usuarioService.saveAll(usuario2s);
    }
    
    @PutMapping("/usuarios/{id}")
    public Usuario2 edit(@PathVariable long id,@RequestBody Usuario2 usuario2) {
    	
    	if (usuario2!=null && usuario2.getImage()!=null && usuario2.getImage().getPicByte()!=null) {
    		usuario2.getImage().setPicByte(compressBytes(usuario2.getImage().getPicByte()));  
		}
    	
        return this.usuarioService.edit(id, usuario2);
    }
    
    @DeleteMapping("/usuarios/{id}")
    public boolean edit(@PathVariable long id) {
        return this.usuarioService.remove(id);
    }
    
    @PostMapping("/upload")
	public boolean uplaodImage(@RequestParam("imageFile") MultipartFile file){

    	try {
    		//System.out.println("Original Image Byte Size - " + file.getBytes().length);
    		//System.out.println(this.imageRepository.findById(file.getOriginalFilename()));
    		
			ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
    				compressBytes(file.getBytes()));
			
			if (this.imageRepository.existsById(img.getName())) {
				System.out.println("ya existe la imagen...");
			}
			
			//this.imageRepository.delete(img);
    		imageRepository.save(img);
    		return false;
    		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e.getMessage());
		}
		
    	return false;

	}
    
   

	@GetMapping(path = { "/get/{imageName}" })
	public ImageModel getImage(@PathVariable("imageName") String imageName) throws IOException {
		ImageModel img = this.imageRepository.findImgByName(imageName);
//		final Optional<ImageModel> retrievedImage = imageRepository.findById(imageName);
//		System.out.println(retrievedImage);
//		if (retrievedImage!=null && retrievedImage.get()!=null) {
//			
//		}
		//img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
		//		decompressBytes(retrievedImage.get().getPicByte()));
		
		return img;
	}
	
	@GetMapping(path = { "/imagenes" })
	public List<ImageModel> getAllImage() throws IOException {

		return this.imageRepository.findAll();
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
