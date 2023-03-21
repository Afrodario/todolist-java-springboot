package it.softwareInside.NoteAppLezione22.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.softwareInside.NoteAppLezione22.models.Note;
import it.softwareInside.NoteAppLezione22.service.NoteService;
import it.softwareInside.NoteAppLezione22.service.PdfService;

@RestController
public class NoteController {

	@Autowired
	NoteService noteService;
	
	@Autowired
	PdfService pdfService;
	
	@PostMapping("/crea")
	public boolean aggiungiNota(@RequestBody Note note) {
		return noteService.addNoteToDB(note);
	}
	
	@GetMapping("/stampa")
	public Iterable<Note> stampaNote() {
		return noteService.getAllNotes();
	}
	
	@PostMapping("/trova")
	public Note trovaNota(@RequestParam("id") Integer id) {
		return noteService.getNoteById(id);
	}
	
	@DeleteMapping("/cancella-nota")
	public Note cancellaNota(@RequestParam("id") Integer id) {
		return noteService.deleteNoteById(id);
	}
	
	@GetMapping("/cancella-tutto")
	public void cancellaTutto() {
		noteService.deleteAllNotes();
	}
	
	@PostMapping("/aggiorna")
	public boolean aggiornaNota(@RequestBody Note note) {
		return noteService.updateNote(note);
	}
	
	@GetMapping("/documento")
	public boolean nuovoDocumento(@RequestParam("id") Integer id) throws IOException {
		pdfService.creaDocumento(id);
		return true;
	}
	
}
