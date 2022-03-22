package br.com.uploadservice.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JacksonXmlRootElement(localName = "root")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaFiscalXml {

	private ElementXml element;

	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@JsonIgnoreProperties(ignoreUnknown = true)
	private static class ElementXml {
		
		private String chave;
		
		private Date dataHoraRegistro;
		
		private String descricaoStatus;
		
		@JacksonXmlElementWrapper(localName = "duplicatas")
		@JacksonXmlProperty(localName = "element")
		private List<DuplicataXml> duplicatas;
		
		private String nomeDestinatario;
		
		private String nomeEmitente;
		
		private BigDecimal valor;
		
		private String nomeArquivo;
	}

	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@JsonIgnoreProperties(ignoreUnknown = true)
	private static class DuplicataXml {

		private Date dataVencimento;
		
		private Integer numeroParcela;
		
		private BigDecimal valorParcela;

	}
}
