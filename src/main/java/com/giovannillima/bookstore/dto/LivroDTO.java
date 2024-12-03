package com.giovannillima.bookstore.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.giovannillima.bookstore.domin.Livro;

import jakarta.validation.constraints.NotEmpty;

public class LivroDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;

	@NotEmpty(message = "O Titulo não podera ficar em branco")
	@Length(min = 3, max = 100, message = "O Titulo dever ter no maximo 100 caracteres")
	private String titulo;

	public LivroDTO() {
		super();
	}

	public LivroDTO(Livro obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	

}
