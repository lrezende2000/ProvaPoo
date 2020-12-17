package com.simplesesotque.simplesestoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplesesotque.simplesestoque.models.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
  
}
