package br.com.uploadservice.converter;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.uploadservice.dto.NotaFiscalDTO;
import br.com.uploadservice.model.NotaFiscal;

@Mapper(componentModel = "spring")
public interface NotaFiscalMapper {

	List<NotaFiscalDTO> converter(List<NotaFiscal> notas);
	
	NotaFiscalDTO converter(NotaFiscal nota);
}
