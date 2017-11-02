package utilities;

public class DaoException extends RuntimeException {

	public DaoException(String message, Throwable cause) throws Exception {
		super("DaoConfigurationException " + message, cause);
	}

	public DaoException(String message) throws Exception {
		super("DaoConfigurationException " + message);
	}

	public DaoException(Throwable cause) throws Exception {
		super(cause);
	}

}