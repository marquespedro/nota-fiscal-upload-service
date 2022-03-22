package br.com.uploadservice.execeptionHandler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UploadServiceExceptionHandler  extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
																HttpHeaders headers, 
																HttpStatus status, 
																WebRequest request) {

		List<Erro> erros = criarListaErros(ex.getBindingResult());
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	
	/*
	 * Captura todos os campos que contém erros e passa para o metodo
	 * handleMethodArgumentNotValid informar os erros na resposta da requisicao
	 */

	private List<Erro> criarListaErros(BindingResult bindingResult) {
		List<Erro> erros = new ArrayList<>();

		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			String mensagem = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			erros.add(new Erro(mensagem));
		}

		return erros;
	}
}
