package com.gerenciamentopessoas.personapi.repository;

import com.gerenciamentopessoas.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
