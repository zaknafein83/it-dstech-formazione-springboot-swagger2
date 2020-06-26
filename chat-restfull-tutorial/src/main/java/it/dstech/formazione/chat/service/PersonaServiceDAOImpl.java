package it.dstech.formazione.chat.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.formazione.chat.model.Messaggio;
import it.dstech.formazione.chat.model.Persona;
import it.dstech.formazione.chat.repository.MessaggioRepository;
import it.dstech.formazione.chat.repository.PersonaRepository;

@Service
public class PersonaServiceDAOImpl implements PersonaServiceDAO {

	@Autowired
	private PersonaRepository personaRepos;
	@Autowired
	private MessaggioRepository messageRepos;


	public List<Persona> cercaUsernames() {
		return personaRepos.findAll();
	}

	public void sendMessaggio(String persona, Messaggio messaggio) {
		Persona controparte = findPersona(messaggio.getControparte().getUsername());
		Persona sender = findPersona(persona);
		LocalDateTime now = LocalDateTime.now();

		messaggio.setTimestamp(now);
		messaggio.setControparte(controparte);
		
		messageRepos.save(messaggio);
		sender.getListaMessaggi().add(messaggio);
		personaRepos.save(sender);
		
		Messaggio duplicato = new Messaggio();
		duplicato.setMittente(!messaggio.getMittente());
		duplicato.setControparte(sender);
		duplicato.setTimestamp(now);
		duplicato.setTesto(messaggio.getTesto());
		messageRepos.save(duplicato);
		
		controparte.getListaMessaggi().add(duplicato);
		personaRepos.save(controparte);
	}

	public Persona findPersona(String username) {
		return personaRepos.findByUsername(username);
	}

	@Override
	public Persona createPersona(Persona persona) {
		return personaRepos.save(persona);
	}
	
	

}
