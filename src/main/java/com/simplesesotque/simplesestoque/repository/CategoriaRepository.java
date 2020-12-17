package com.simplesesotque.simplesestoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplesesotque.simplesestoque.models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
  
}
