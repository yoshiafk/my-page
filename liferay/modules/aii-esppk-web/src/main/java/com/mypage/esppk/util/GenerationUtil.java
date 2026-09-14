package com.mypage.esppk.util;

import java.security.SecureRandom;

public class GenerationUtil {
	private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final SecureRandom RANDOM = new SecureRandom();

	public static String generateShortCode(int length) {
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < 5; i++) {
			sb.append(CHARS.charAt(RANDOM.nextInt(CHARS.length())));
		}
		return sb.toString();
	}

	public static String generateSubmissionNumber(String prefix) {
		String date = new java.text.SimpleDateFormat("yyMMdd").format(new java.util.Date());
		String rand = generateShortCode(5);
		return prefix + "-" + date + "-" + rand;
	}

}
