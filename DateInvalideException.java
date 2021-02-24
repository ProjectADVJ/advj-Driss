package application;

public class DateInvalideException extends Exception {
	
	
	public DateInvalideException() {
		super("La date saisie est invalide");
	}


	public DateInvalideException(String message) {
		super("La date saisie est invalide"+" "+ message);
	}
}