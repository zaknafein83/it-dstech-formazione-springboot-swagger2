package it.dstech.formazione.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.dstech.formazione.chat.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{

	Persona findByUsername(String username);

}
