package exemplejwt;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ma.formations.jwt.TokenManager;

public class Test2 {
	//d�lai de validit� du token est : un jour.
	private final static long PERIOD_VALIDITY = 1 * 24 * 60 * 60 * 1000;

	public static void main(String[] args) {
		Map<String, Object> cles = new HashMap<>();
		Date dateCreation = new Date();
		Date dateExpiration = new Date(dateCreation.getTime() + PERIOD_VALIDITY);
		cles.put("sub", "admin");
		cles.put("age", 15);
		cles.put("roles", Arrays.asList("ADMIN", "CLIENT"));
		String token=TokenManager.generateTokenwithRoles(cles, dateCreation, dateExpiration);
		System.out.println(token);
	}
}
