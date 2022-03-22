package br.com.uploadservice.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DuplicataDTO {

	private Integer id;

	private Integer numeroParcela;

	private BigDecimal valorParcela;

	private Date dataVencimento;

}
