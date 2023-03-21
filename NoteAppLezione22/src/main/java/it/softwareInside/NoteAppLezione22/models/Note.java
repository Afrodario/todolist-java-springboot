package it.softwareInside.NoteAppLezione22.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Note {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	
	@NotNull(message="Il testo non deve essere NULL")
	@NotBlank(message="Il testo non deve essere vuoto")
	private String testo;
	
	@NotNull(message="L'autore non deve essere NULL")
	@NotBlank(message="L'autore non deve essere vuoto")
	private String autore;
	
	//COSTRUTTORE SENZA ID
	public Note(String testo, String autore) {
		setAutore(autore);
		setTesto(testo);
	}
	
}
