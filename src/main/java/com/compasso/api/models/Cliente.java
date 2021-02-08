package com.compasso.api.models;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * @author Rodrigo da Cruz
 * @version 1.0
 * @since 2021-01-05
 * 
 */

@Data
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(position = 0)
	private Long id;
	
	@Column(nullable = false)
	@ApiModelProperty(position = 1)
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 1, max = 155, message = "O tamanho deve ser entre 1 e 155 caracteres")
	private String nome;

	@Column(nullable = false)
	@ApiModelProperty(position = 2)
	@NotEmpty(message = "Preenchimento obrigatório")
	@Positive(message = "A idade deve ser um número inteiro e positivo")
	@Length(min = 1, max = 50, message = "O tamanho deve ser entre 1 e 50 caracteres")
	private String idade;
	
	@Column(nullable = false)
	@ApiModelProperty(position = 3)
	@NotNull(message = "Preenchimento obrigatório")
	private LocalDate data_nascimento;
	
	@Column(nullable = false)
	@ApiModelProperty(position = 4)
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 1, max = 10, message = "O tamanho deve ser entre 1 e 10 caracteres")
	private String sexo;

	@ManyToOne
	@ApiModelProperty(position = 5)
	private Cidade cidade;
	
}
