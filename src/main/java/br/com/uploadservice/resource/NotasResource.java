package br.com.uploadservice.resource;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.uploadservice.service.NotaFiscalService;

@RestController
@RequestMapping("/notas-fiscais")
public class NotasResource {

	@Autowired 
	private NotaFiscalService notaFiscalService;
		
	@PostMapping(path = "/upload")
	public ResponseEntity<?> upload(@RequestParam(required = true) MultipartFile file) throws IOException {
		
		notaFiscalService.salvar(file);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

}
