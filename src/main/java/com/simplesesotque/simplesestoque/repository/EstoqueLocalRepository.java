package com.simplesesotque.simplesestoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplesesotque.simplesestoque.models.EstoqueLocal;

@Repository
public interface EstoqueLocalRepository extends JpaRepository<EstoqueLocal, Long>{
  
}
