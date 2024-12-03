package com.giovannillima.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.giovannillima.bookstore.domin.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Integer> {

	/*@Query("select obj from Livro obj where obj.categoria.id = ?1")*/
	@Query("select obj from Livro obj where obj.categoria.id = :id_cat")
	List<Livro> findAllByCategoria(@Param(value = "id_cat") Integer id_cat);

}
