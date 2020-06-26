package it.dstech.formazione.chat.service;

import java.util.List;

import it.dstech.formazione.chat.model.Messaggio;
import it.dstech.formazione.chat.model.Persona;

public interface PersonaServiceDAO {

	List<Persona> cercaUsernames();
	
	void sendMessaggio(String username, Messaggio message);
	
	Persona findPersona(String username);
	
	Persona createPersona(Persona persona);
}
