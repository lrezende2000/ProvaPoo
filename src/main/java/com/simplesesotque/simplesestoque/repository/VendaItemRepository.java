package com.simplesesotque.simplesestoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplesesotque.simplesestoque.models.VendaItem;

@Repository
public interface VendaItemRepository extends JpaRepository<VendaItem, Long> {

}
