package com.michaelcherrera.autopartsstore.repositories;

import com.michaelcherrera.autopartsstore.entities.PartInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartInventoryRepository extends JpaRepository<PartInventory, Long> { }
