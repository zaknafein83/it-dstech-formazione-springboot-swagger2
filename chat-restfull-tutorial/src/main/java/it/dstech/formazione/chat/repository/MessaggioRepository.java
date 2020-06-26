package it.dstech.formazione.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.dstech.formazione.chat.model.Messaggio;

public interface MessaggioRepository extends JpaRepository<Messaggio, Long>{

}
