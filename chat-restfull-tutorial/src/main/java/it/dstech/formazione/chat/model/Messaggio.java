package it.dstech.formazione.chat.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Messaggio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Persona controparte;
	
	private boolean mittente;
	
	private String testo;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDateTime timestamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public boolean getMittente() {
		return mittente;
	}

	public void setMittente(boolean mittente) {
		this.mittente = mittente;
	}

	public Persona getControparte() {
		return controparte;
	}

	public void setControparte(Persona controparte) {
		this.controparte = controparte;
	}
}
