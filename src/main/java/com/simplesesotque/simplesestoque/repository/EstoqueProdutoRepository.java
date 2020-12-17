package com.simplesesotque.simplesestoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplesesotque.simplesestoque.models.EstoqueProduto;

@Repository
public interface EstoqueProdutoRepository extends JpaRepository<EstoqueProduto, Long>{
  
}
