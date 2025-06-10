package uuu.petshopping.Exception;
public class PETDataInvalidException extends RuntimeException {
	public PETDataInvalidException() {
		super();
	}
	public PETDataInvalidException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public PETDataInvalidException(String message, Throwable cause) {
		super(message, cause);
	}
	public PETDataInvalidException(String message) {
		super(message);
	}
	public PETDataInvalidException(Throwable cause) {
		super(cause);
	}
}
