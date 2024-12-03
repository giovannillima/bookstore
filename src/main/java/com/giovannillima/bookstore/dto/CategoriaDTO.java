package com.giovannillima.bookstore.dto;

import org.hibernate.validator.constraints.Length;

import com.giovannillima.bookstore.domin.Categoria;

import jakarta.validation.constraints.NotEmpty;

public class CategoriaDTO {
	
	private Integer id;
	
	@NotEmpty(message = "O Nome não podera ficar em branco")
	@Length(min = 3, max = 100, message = "O Nome dever ter no maximo 100 caracteres")
	private String nome;
	
	@NotEmpty(message = "A Descrição não podera ficar em branco")
	@Length(min = 3, max = 100, message = "A Descrição dever ter no maximo 100 caracteres")

	private String descricao;

	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

	
}
