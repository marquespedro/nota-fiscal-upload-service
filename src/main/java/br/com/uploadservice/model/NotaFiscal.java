package br.com.uploadservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@ToString
public class NotaFiscal {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ToString.Include
	private Integer id;
	
	private String numero;
	
	@Column(name="dh_registro")
	private LocalDateTime dhRegistro;
	
	@Column(name="nome_emitente")
	private String nomeEmitente;
	
	@Column(name="nome_destinatario")
	private String nomeDestinatario;
	
	@Column(name="valor_nota")
	private BigDecimal valorNota;
	
	@Enumerated(EnumType.ORDINAL)
	private StatusProcessamento status;
	
	@OneToMany(mappedBy = "notaFiscal")
	private List<Duplicata> duplicatas;
	
}
