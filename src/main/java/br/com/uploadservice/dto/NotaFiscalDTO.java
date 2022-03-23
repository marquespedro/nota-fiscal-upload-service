package br.com.uploadservice.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.uploadservice.model.StatusProcessamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(of = {"id", "numero"})
@AllArgsConstructor
@NoArgsConstructor
public class NotaFiscalDTO {

	private Integer id;

	private String numero;

	private Date dhRegistro;

	private String nomeEmitente;

	private String nomeDestinatario;

	private BigDecimal valorNota;

	private String nomeArquivo;

	private StatusProcessamento status;

	private List<DuplicataDTO> duplicatas;
}
