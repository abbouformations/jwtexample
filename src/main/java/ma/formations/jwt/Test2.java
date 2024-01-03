package ma.formations.jwt;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class Test2 {
	private final static String KEY = "@zerty123.*$!";
	private final static long PERIOD_VALIDITY = 1 * 24 * 60 * 60 * 1000;

	public static String generateToken(String username, Date dateCreation, Date dateExpiration) {
		String token = null;
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(username);
		builder.setIssuedAt(dateCreation);
		builder.setExpiration(dateExpiration);
		builder.signWith(SignatureAlgorithm.HS512, KEY);
		token = builder.compact();
		return token;
	}

	public static String generateTokenwithRoles(Map<String, Object> credentials, Date dateCreation,
			Date dateExpiration) {
		String token = null;
		JwtBuilder builder = Jwts.builder();
		builder.setClaims(credentials);
		builder.setIssuedAt(dateCreation);
		builder.setExpiration(dateExpiration);
		builder.signWith(SignatureAlgorithm.HS512, KEY);
		token = builder.compact();
		return token;
	}

	public static void main(String[] args) {
		Date dateCreation = new Date();
		Date dateExpiration = new Date(dateCreation.getTime() + PERIOD_VALIDITY);

//		System.out.println("Token=" + generateToken("admin", dateCreation, dateExpiration));
//
		Map<String, Object> cles = new HashMap<>();
		cles.put("sub", "admin");
		cles.put("roles", Arrays.asList("ADMIN", "MANAGER"));
		cles.put("autre", "nnnn");
		System.out.println("Token2=" + generateTokenwithRoles(cles, dateCreation, dateExpiration));
//
		System.out.println("username=" + getUserNameFromJwtToken(
				"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjpbIkFETUlOIiwiTUFOQUdFUiJdLCJleHAiOjE2NDE5MjExMjIsImlhdCI6MTY0MTgzNDcyMiwiYXV0cmUiOiJubm5uIn0.G7qkBCkJfVHSVFBzgIHJpQtjGAuij0wTY9ygCyRvJJ8pSAd1UCIFUD9j8wFKDNeJEKyXQ80TFsDfuJRW2j4XLg"));
//
		TokenManager.getDataFromJwtToken(
				"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjpbIkFETUlOIiwiTUFOQUdFUiJdLCJleHAiOjE2NDE5MjExMjIsImlhdCI6MTY0MTgzNDcyMiwiYXV0cmUiOiJubm5uIn0.G7qkBCkJfVHSVFBzgIHJpQtjGAuij0wTY9ygCyRvJJ8pSAd1UCIFUD9j8wFKDNeJEKyXQ80TFsDfuJRW2j4XLg");

	}

	public static String getUserNameFromJwtToken(String token) {
		JwtParser parser = Jwts.parser();
		parser.setSigningKey(KEY);
		Jws<Claims> jws = parser.parseClaimsJws(token);
		return jws.getBody().getSubject();

		// return
		// Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody().getSubject();
	}

	public static boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(KEY).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			e.printStackTrace();
		} catch (MalformedJwtException e) {
			e.printStackTrace();
		} catch (ExpiredJwtException e) {
			e.printStackTrace();
		} catch (UnsupportedJwtException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		return false;
	}

}
