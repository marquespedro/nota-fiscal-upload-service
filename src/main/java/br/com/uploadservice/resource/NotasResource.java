package br.com.uploadservice.resource;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import br.com.uploadservice.dto.NotaFiscalXml;

@RestController
@RequestMapping("/notas-fiscais")
public class NotasResource {

	@Autowired
	private XmlMapper xmlMapper;

	@PostMapping(path = "/upload")
	public ResponseEntity<NotaFiscalXml> upload(@RequestParam(required = true) MultipartFile file) throws IOException {

		NotaFiscalXml dto = xmlMapper.readValue(new String(file.getBytes()), NotaFiscalXml.class);

		return ResponseEntity.ok(dto);

	}

	@GetMapping
	public ResponseEntity<String> get() {

		return ResponseEntity.ok("OK");

	}
}
