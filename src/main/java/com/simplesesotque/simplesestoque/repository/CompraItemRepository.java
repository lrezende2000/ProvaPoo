package com.simplesesotque.simplesestoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplesesotque.simplesestoque.models.CompraItem;

@Repository
public interface CompraItemRepository extends JpaRepository<CompraItem, Long> {

}
