package br.com.uploadservice.converters;

import org.mapstruct.Mapper;

import br.com.uploadservice.dto.NotaFiscalDTO;
import br.com.uploadservice.model.NotaFiscal;

@Mapper(componentModel = "spring")
public interface NotaFiscalMapper {

	NotaFiscal converter(NotaFiscalDTO dto);

	NotaFiscalDTO converter(NotaFiscal entity);
}
