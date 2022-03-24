package br.com.uploadservice.resource;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.uploadservice.dto.NotaFiscalDTO;
import br.com.uploadservice.service.NotaFiscalService;
import br.com.uploadservice.service.UploadService;

@RestController
@RequestMapping("/notas-fiscais")
@CrossOrigin(origins = { "http://localhost:4200" })
public class NotasResource {

	@Autowired
	private UploadService uploadService;
	
	@Autowired
	private NotaFiscalService notaFiscalService;

	@PostMapping(path = "/upload")
	public ResponseEntity<?> upload(@RequestParam(required = false) MultipartFile file) throws IOException {
		
		uploadService.upload(file);

		return ResponseEntity.status(HttpStatus.CREATED).build();

	}
	
	@GetMapping
	public ResponseEntity<List<NotaFiscalDTO>> listar() throws IOException {

		List<NotaFiscalDTO> notas =  notaFiscalService.listar();

		return ResponseEntity.status(HttpStatus.OK).body(notas);

	}
	


}
