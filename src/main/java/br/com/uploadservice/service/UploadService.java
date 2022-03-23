package br.com.uploadservice.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {

	@Value("${upload-service.path.input}")
	private String propInputArquivos;

	public void upload(MultipartFile file) throws IOException {
		
		validarArquivo(file);
		
		importarArquivo(file);
	}

	/**
	 * Escreve o arquivo no diretorio input definido nas properties do projeto
	 * 
	 * @param file
	 * @throws IOException 
	 */
	private void importarArquivo(MultipartFile file) throws IOException {

		String home = System.getProperty("user.home");
		
		String caminhoEntrada = home + this.propInputArquivos.concat("/");

		Path path = Paths.get(caminhoEntrada);
		
		if (!Files.exists(path)) {
			new File(caminhoEntrada).mkdirs();
		}
		
		FileOutputStream out = new FileOutputStream(caminhoEntrada.concat(file.getOriginalFilename()));
		byte[] bytesArquivo = file.getBytes();
		out.write(bytesArquivo);
		out.close();
	}
	
	/**
	 * Valida arquivo diferente de nulo e possui extensao xml
	 * @param file
	 */
	private void validarArquivo(MultipartFile file)  {

		if (Objects.isNull(file)) {
			throw new IllegalArgumentException("Verifique se foi anexado um arquivo com o nome de parâmetro (file)");
		}
		
		boolean extensaoValida = file.getOriginalFilename().endsWith(".xml");
		
		if(!extensaoValida) {
			throw new IllegalArgumentException("Extensao arquivo invalido");
		}
	}

}
