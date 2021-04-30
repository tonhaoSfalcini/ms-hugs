package com.hugs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hugs.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
}
