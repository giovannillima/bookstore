package com.giovannillima.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giovannillima.bookstore.domin.Categoria;
import com.giovannillima.bookstore.domin.Livro;
import com.giovannillima.bookstore.repository.CategoriaRepository;
import com.giovannillima.bookstore.repository.LivroRepository;

@Service
public class DbService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaDb() {
		
		Categoria cat1 = new Categoria(null,"informatica", "livros de TI");
		Livro l1 = new Livro(null, "clean code", "Robert Martins", "Lorem ipsum", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
	
		
		
	}

}
