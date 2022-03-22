package br.com.uploadservice.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@ToString
public class Duplicata {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ToString.Include
	private Integer id;
	
	private Integer parcela;

	private BigDecimal valor;
	
	@Column(name = "data_vencimento")
	private LocalDate dataVencimento;
	
	@JoinColumn(name = "nota_fiscal_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private NotaFiscal notaFiscal;
}
