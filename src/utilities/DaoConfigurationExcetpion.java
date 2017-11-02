package utilities;

public class DaoConfigurationExcetpion extends RuntimeException {

	public DaoConfigurationExcetpion(String message, Throwable cause) throws Exception {
		super("DaoConfigurationException " + message, cause);
	}

	public DaoConfigurationExcetpion(String message) throws Exception {
		super("DaoConfigurationException " + message);
	}

	public DaoConfigurationExcetpion(Throwable cause) throws Exception {
		super(cause);
	}

}
