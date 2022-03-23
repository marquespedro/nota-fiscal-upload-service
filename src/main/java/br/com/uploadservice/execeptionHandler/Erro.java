package br.com.uploadservice.execeptionHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Erro {
	
	private String mensagemUsuario;
	private String mensagemDesenvolvedor;
	
}
