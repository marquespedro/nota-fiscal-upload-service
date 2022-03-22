package br.com.uploadservice.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import br.com.uploadservice.dto.NotaFiscalXml;
import br.com.uploadservice.dto.NotaFiscalXml.DuplicataXml;
import br.com.uploadservice.dto.NotaFiscalXml.ElementXml;
import br.com.uploadservice.exceptions.ConverterArquivoNotaFiscalException;
import br.com.uploadservice.exceptions.ImportarArquivoException;
import br.com.uploadservice.model.Duplicata;
import br.com.uploadservice.model.NotaFiscal;
import br.com.uploadservice.model.StatusProcessamento;
import br.com.uploadservice.repository.NotaFiscalRepositoryCustom;

@Service
public class NotaFiscalService {

	@Autowired
	private NotaFiscalRepositoryCustom repository;

	@Value("${upload-service.path.input}")
	private String inputArquivos;
	
	@Transactional
	public NotaFiscal salvar(MultipartFile file) throws IOException {

		NotaFiscalXml notaFiscalXml = converterXmlParaNotaFiscalXml(file);
		NotaFiscal notaFiscal = montarNotaFiscal(notaFiscalXml);

		repository.salvar(notaFiscal);

		importarXmlNotaFiscal(file);

		return notaFiscal;
	}

	/**
	 * Escreve o arquivo no diretorio input
	 * 
	 * @param file
	 */
	public void importarXmlNotaFiscal(MultipartFile file) {

		String home = System.getProperty("user.home");
		String diretorioInput = home + this.inputArquivos.concat("/");

		Path path = Paths.get(diretorioInput);
		if(!Files.exists(path)) {
			new File(diretorioInput).mkdirs();
		}
		
		try (FileOutputStream outputStream = new FileOutputStream(diretorioInput.concat(file.getOriginalFilename()))) {
			byte[] bytesArquivo = file.getBytes();
			outputStream.write(bytesArquivo);
		} catch (IOException e) {
			throw new ImportarArquivoException(e.getMessage());
		}

	}

	private NotaFiscal montarNotaFiscal(NotaFiscalXml notaFiscalXml) {

		ElementXml elementXml = notaFiscalXml.getElement();

		NotaFiscal nota = NotaFiscal.builder().numero(elementXml.getChave())
				.status(StatusProcessamento.AGUARDANDO_PROCESSAMENTO).dhRegistro(elementXml.getDataHoraRegistro())
				.nomeEmitente(elementXml.getNomeEmitente()).nomeDestinatario(elementXml.getNomeDestinatario())
				.valorNota(elementXml.getValor()).duplicatas(montarDuplicatas(elementXml.getDuplicatas())).build();

		return nota;
	}

	private List<Duplicata> montarDuplicatas(List<DuplicataXml> duplicatasXml) {

		Stream<Duplicata> duplicatas = duplicatasXml.stream().map(d -> {

			return Duplicata.builder().dataVencimento(d.getDataVencimento()).valor(d.getValorParcela())
					.parcela(d.getNumeroParcela()).build();
		});

		return duplicatas.collect(Collectors.toList());
	}
	
	private NotaFiscalXml converterXmlParaNotaFiscalXml(MultipartFile file)  {
		XmlMapper mapper = new XmlMapper();
		NotaFiscalXml notaFiscalXml = null;
		
		try {
			
			notaFiscalXml =  mapper.readValue(new String(file.getBytes()), NotaFiscalXml.class);
		
		} catch (IOException e) {
		
			throw new ConverterArquivoNotaFiscalException(e.getMessage());
		}
		
		return notaFiscalXml;
	}
}
