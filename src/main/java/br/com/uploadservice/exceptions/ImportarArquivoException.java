package br.com.uploadservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ImportarArquivoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ImportarArquivoException(String msg) {
		super(msg);
	}

}
