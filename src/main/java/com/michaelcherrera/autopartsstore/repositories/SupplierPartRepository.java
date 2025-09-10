package com.michaelcherrera.autopartsstore.repositories;

import com.michaelcherrera.autopartsstore.entities.SupplierPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierPartRepository extends JpaRepository<SupplierPart, SupplierPart.SupplierPartPK> { }
