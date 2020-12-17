package com.simplesesotque.simplesestoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplesesotque.simplesestoque.models.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
  
}
