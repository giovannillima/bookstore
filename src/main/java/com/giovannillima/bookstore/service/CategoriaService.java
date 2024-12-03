package com.giovannillima.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.giovannillima.bookstore.domin.Categoria;
import com.giovannillima.bookstore.dto.CategoriaDTO;
import com.giovannillima.bookstore.exceptions.ObjectNotFoundException;
import com.giovannillima.bookstore.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {

		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Categoria não encontrado !! Id: " + id + " , tipo:" + Categoria.class.getName()));

	}
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO objDTO) {
		Categoria obj = findById(id);
		obj.setNome(objDTO.getNome());
		obj.setDescricao(objDTO.getDescricao());
		
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
			
		} catch (DataIntegrityViolationException e) {
			throw new com.giovannillima.bookstore.exceptions.DataIntegrityViolationException("Categoria não pode ser excluida");
			// TODO: handle exception
		}
		
	}

}
