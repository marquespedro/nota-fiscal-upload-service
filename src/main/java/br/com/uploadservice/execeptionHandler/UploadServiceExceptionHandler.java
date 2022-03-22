package br.com.uploadservice.execeptionHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.uploadservice.exceptions.ConverterArquivoNotaFiscalException;
import br.com.uploadservice.exceptions.ImportarArquivoException;

@ControllerAdvice
public class UploadServiceExceptionHandler  extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler({ ImportarArquivoException.class })
	public ResponseEntity<Object> handleImportarArquivoException(ImportarArquivoException ex, WebRequest request) {
		String msg = messageSource.getMessage("erro.importar.arquivo", null, LocaleContextHolder.getLocale());
		Erro erro = new Erro(msg, ex.toString());
		return handleExceptionInternal(ex, erro, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
	
	
	@ExceptionHandler({ ConverterArquivoNotaFiscalException.class })
	public ResponseEntity<Object> handleConverterNotaFiscalException(ConverterArquivoNotaFiscalException ex, WebRequest request) {
		String msg = messageSource.getMessage("erro.conversao.arquivo", null, LocaleContextHolder.getLocale());
		Erro erro = new Erro(msg, ex.toString());
		return handleExceptionInternal(ex, erro, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
}
