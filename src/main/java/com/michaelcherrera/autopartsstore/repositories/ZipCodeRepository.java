package com.michaelcherrera.autopartsstore.repositories;

import com.michaelcherrera.autopartsstore.entities.ZipCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipCodeRepository extends JpaRepository<ZipCode, String> {
}
