package br.com.uploadservice.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(of = { "id", "valor" })
@AllArgsConstructor
@NoArgsConstructor
public class DuplicataDTO {

	private Integer id;

	private Integer parcela;

	private BigDecimal valor;

	private Date dataVencimento;

}
