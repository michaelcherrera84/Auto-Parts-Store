package com.michaelcherrera.autopartsstore.repositories;

import com.michaelcherrera.autopartsstore.entities.OrderSalesman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderSalesmanRepository extends JpaRepository<OrderSalesman, OrderSalesman.OrderSalesmanPK> { }
