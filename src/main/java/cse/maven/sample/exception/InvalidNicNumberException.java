package cse.maven.sample.exception;

public class InvalidNicNumberException extends Exception {

	
	private static final long serialVersionUID = 1L;
        
        public InvalidNicNumberException(String message) {
		super(message);
	}

	public InvalidNicNumberException() {
		super("Invalid Nic Number");
	}
}
