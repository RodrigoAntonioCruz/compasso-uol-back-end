package com.compasso.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
*
* @author  Rodrigo da Cruz
* @version 1.0
* @since   2021-02-05 
* 
*/

@Data
@Entity
public class Cidade {
    
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
	@Length(min = 1, max = 10, message = "O tamanho deve ser entre 1 e 10 caracteres")
	private String estado;

}
