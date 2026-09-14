package com.mypage.agencyportal.helpers;

import java.security.SecureRandom;
import java.util.Base64;

public class MiscHelper {
	public static String generateSecureToken(int length) {
		SecureRandom secureRandom = new SecureRandom();
		byte[] randomBytes = new byte[length];
		secureRandom.nextBytes(randomBytes);

		String token = Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);

		return token;
	}
}
