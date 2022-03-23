package br.com.uploadservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uploadservice.converter.NotaFiscalMapper;
import br.com.uploadservice.dto.NotaFiscalDTO;
import br.com.uploadservice.model.NotaFiscal;
import br.com.uploadservice.repository.NotaFiscalRepository;

@Service
public class NotaFiscalService {

	@Autowired
	private NotaFiscalRepository notaFiscalRepository;

	@Autowired
	private NotaFiscalMapper mapper;
	
	public List<NotaFiscalDTO> listar() {
		List<NotaFiscal> entidades = notaFiscalRepository.listar();
		return mapper.converter(entidades);
	}
}
