package com.mypage.product.pet.helpers;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class NumberFormatHelper {
    public static String formatNumber(Object number) {
        if (number == null) {
            return "";
        }

        long longNumber;

        if (number instanceof Long) {
            longNumber = (Long) number;
        } else if (number instanceof Integer) {
            longNumber = ((Integer) number).longValue();
        } else if (number instanceof String) {
            try {
                longNumber = Long.parseLong((String) number);
            } catch (NumberFormatException e) {
                return "Invalid number format";
            }
        } else {
            return "Unsupported number type";
        }

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');

        DecimalFormat decimalFormat = new DecimalFormat("#,###", symbols);

        return decimalFormat.format(longNumber);
    }
}
