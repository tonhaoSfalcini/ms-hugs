package com.hugs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hugs.entities.PedidoEntrega;

@Repository
public interface PedidoEntregaRepository extends JpaRepository<PedidoEntrega, Long>{

}
