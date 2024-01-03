package exemplejwt;

import java.util.Date;

import ma.formations.jwt.TokenManager;

public class Test1 {
	//délai de validité du token est : un jour.
	private final static long PERIOD_VALIDITY = 1 * 24 * 60 * 60 * 1000;
	public static void main(String[] args) {
		Date dateCreation = new Date();
		Date dateExpiration = new Date(dateCreation.getTime() + PERIOD_VALIDITY);
		String token=TokenManager.generateToken("admin", dateCreation, dateExpiration);
		System.out.println(token);
	}
}
