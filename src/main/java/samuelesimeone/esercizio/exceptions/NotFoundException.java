package samuelesimeone.esercizio.exceptions;

public class NotFoundException extends RuntimeException {
	public NotFoundException(long id) {
		super("L'Elemento con id " + id + " non è stato trovato");
	}
}
