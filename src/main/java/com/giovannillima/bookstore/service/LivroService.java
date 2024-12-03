package com.giovannillima.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.giovannillima.bookstore.domin.Categoria;
import com.giovannillima.bookstore.domin.Livro;
import com.giovannillima.bookstore.exceptions.ObjectNotFoundException;
import com.giovannillima.bookstore.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Livro findById(Integer id) {

		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Livro não encontrado !! Id: " + id + " , tipo:" + Livro.class.getName()));

	}
	
	public List<Livro> findAll(Integer id_cat){
		
		categoriaService.findById(id_cat);
		
		return repository.findAllByCategoria(id_cat);
	}


	public Livro create(Integer id_cat, Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaService.findById(id_cat);
		obj.setCategoria(cat);
		
		return repository.save(obj);
	}

	public Livro update(Integer id, Livro obj) {
		Livro newObj = findById(id);
		updateData(newObj, obj);
		return repository.save(obj);
	}

	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setNome_autor(obj.getNome_autor());
		newObj.setTexto(obj.getTexto());
		newObj.setCategoria(obj.getCategoria());
	}

	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	
		
	}







	
}
