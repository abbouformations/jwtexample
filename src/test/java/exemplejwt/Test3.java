package exemplejwt;

import ma.formations.jwt.TokenManager;

public class Test3 {
	public static final String TOKEN_1 = "fffeyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY4NDU5OTk2MiwiZXhwIjoxNjg0Njg2MzYyfQ.bwH3BiuBLpFXIx47YSozP5ahNeXXU36Nmu5ASRF9MtEn-ppUiqOJjaUzwL-MPnewzvELQ_aBaf1Ct-noJlA-ZA";
	public static final String TOKEN_2 = "zzzzeyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjpbIkFETUlOIiwiQ0xJRU5UIl0sImV4cCI6MTY4NDY4NjY0NCwiaWF0IjoxNjg0NjAwMjQ0LCJhZ2UiOjE1fQ.ae9G_Dvso7-ANryDpYemiz_GDl1RNGw76uiHXJmj2BU8I74x4_l0Kh_Mf-GQnhvT7d4odg70HycnP_-hNT12Hg";

	public static void main(String[] args) {
		try {
			boolean isToken1Valid=TokenManager.validateJwtToken(TOKEN_1);
			boolean isToken2Valid=TokenManager.validateJwtToken(TOKEN_2);
			System.out.println(isToken1Valid);
			System.out.println(isToken2Valid);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
