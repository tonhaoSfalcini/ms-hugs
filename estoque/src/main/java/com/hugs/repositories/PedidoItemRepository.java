package com.hugs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hugs.entities.PedidoItem;


@Repository
public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long>{

}
