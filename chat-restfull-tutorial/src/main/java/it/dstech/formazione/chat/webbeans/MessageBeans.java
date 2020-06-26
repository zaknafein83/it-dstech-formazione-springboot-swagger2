package it.dstech.formazione.chat.webbeans;

import it.dstech.formazione.chat.model.Messaggio;

public class MessageBeans {
	
	private String username;
	
	private Messaggio messaggio;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Messaggio getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(Messaggio messaggio) {
		this.messaggio = messaggio;
	}

}
