package com.mypage.esppk.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class MaskingUtil {
    private MaskingUtil() {}

    public static String maskNik(String nik) {
        if (nik == null || nik.length() < 5) return nik;
        return nik.substring(0, 2) + repeat(nik.length() - 5) + nik.substring(nik.length() - 3);
    }

    public static String maskGender(String gender) {
        if (gender == null || gender.length() < 2) return gender;

        String[] parts = gender.split("-");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {
            sb.append(parts[i].charAt(0)).append(repeat(parts[i].length() - 1));
            if (i < parts.length - 1) sb.append("-");
        }
        return sb.toString();
    }

    public static String maskAndFormatBirthDate(Date date) {
        if (date == null) return "-";

        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", new Locale("id", "ID"));
        String formatted = localDate.format(formatter).toUpperCase();
        return formatted.substring(0, 7) + "****";
    }

    public static String maskPhone(String phone) {
        if (phone == null || phone.length() < 6) return phone;
        return phone.substring(0, 4) + repeat(phone.length() - 6) + phone.substring(phone.length() - 2);
    }

    public static String maskEmail(String email) {
        if (email == null || !email.contains("@")) return email;

        String[] parts = email.split("@");
        String username = parts[0];
        String domain = parts[1];

        if (username.length() <= 1) {
            return "*" + "@" + domain;
        }

        return username.charAt(0) + repeat(username.length() - 1) + "@" + domain;
    }

    public static String maskAddress(String address) {
        if (address == null) return null;

        String[] words = address.split(" ");
        if (words.length <= 2) return address;

        String prefix = words[0] + " " + words[1] + " ";
        int maskLength = Math.max(10, address.length() - prefix.length());

        return prefix + repeat(maskLength);
    }

    public static String maskOccupation(String occupation) {
        if (occupation == null || occupation.length() < 2) return occupation;
        return occupation.charAt(0) + repeat(occupation.length() - 1);
    }

    private static String repeat(int count) {
        if (count <= 0) return "";
        return new String(new char[count]).replace("\0", "*");
    }
}
