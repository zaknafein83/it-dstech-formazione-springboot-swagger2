package it.dstech.formazione.chat.service;

import it.dstech.formazione.chat.model.Messaggio;

public interface MessaggioServiceDAO {
	
	public Messaggio aggiungiMessaggio(Messaggio messaggio);
	
	public void rimuoviMessaggio(Messaggio messaggio);
	
	
}
