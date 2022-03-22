package br.com.uploadservice.execeptionHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Erro {
	
	private String mensagemUsuario;
	private String mensagemDesenvolvedor;
	
}
