package it.dstech.formazione.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.dstech.formazione.chat.model.Persona;
import it.dstech.formazione.chat.service.PersonaServiceDAO;
import it.dstech.formazione.chat.webbeans.MessageBeans;

@RestController
public class ControllerRest {

	@Autowired
	private PersonaServiceDAO personaDao;

	@RequestMapping(value = "/usernames", method = RequestMethod.GET)
	@ApiOperation(value = "Recupera tutti gli utenti dal sistema", notes = "Con questa chiamata riceveremo tutti gli utenti registrati al sistema")
	public List<Persona> getAllUsernames() {
		return personaDao.cercaUsernames();
	}

	@RequestMapping(value = "/send", method = RequestMethod.POST)
	@ApiOperation(value = "Invia Messaggio", notes = "Questo metodo permette ad un utente di inviare un messaggio di testo")
	public void sendMessage(
			@ApiParam(value = "Message Bean oggetto customizzato per l'invio di un messaggio", name = "messaggio") @RequestBody MessageBeans messaggio) {
//		

		personaDao.sendMessaggio(messaggio.getUsername(), messaggio.getMessaggio());
	}

	@RequestMapping(value = "/persona", method = RequestMethod.POST)
	@ApiOperation(value = "Aggiungi persona", notes = "Aggiunge al sistema un nuovo username che individua una persona")
	public void createPersona(@ApiParam(value = "Oggetto persona per la registrazione a sistema", name = "persona") @RequestBody Persona p) {
		personaDao.createPersona(p);
	}

}
