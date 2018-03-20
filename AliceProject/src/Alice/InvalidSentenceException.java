package Alice;

public class InvalidSentenceException extends Exception {

	public InvalidSentenceException () {
		super("InvalidSentenceException: ");
	}
	
	public InvalidSentenceException(String message) {
		super("InvalidSentenceException: " + message);
	}
}
