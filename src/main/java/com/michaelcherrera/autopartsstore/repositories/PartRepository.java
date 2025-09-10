package com.michaelcherrera.autopartsstore.repositories;

import com.michaelcherrera.autopartsstore.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PartRepository extends JpaRepository<Part, UUID> { }
