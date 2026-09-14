package com.axa.payment.helpers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateDeserializerHelper implements JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonElement element, java.lang.reflect.Type typeOfT, JsonDeserializationContext context)
		throws JsonParseException {
		
		String date = element.getAsString();
		String expectedFormatLeadMonth = "MM/dd/yyyy hh:mm:ss a";
		String expectedFormatLeadYear = "yyyy-MM-dd'T'HH:mm:ss";
		String expectedFormatLeadYearShort = "yyyy-MM-dd";
		SimpleDateFormat format = new SimpleDateFormat();

		try {
			if (isValidDateFormat(date, expectedFormatLeadMonth) == true) {
				format.applyPattern(expectedFormatLeadMonth);
			}
			
			if (isValidDateFormat(date, expectedFormatLeadYear) == true) {
				format.applyPattern(expectedFormatLeadYear);
			}
			
			if (isValidDateFormat(date, expectedFormatLeadYearShort) == true) {
				format.applyPattern(expectedFormatLeadYearShort);
			}
			
			format.setTimeZone(TimeZone.getTimeZone("GMT"));
			
			return format.parse(date);
		} catch(ParseException e) {
			return null;
		}
	}
	
	private static boolean isValidDateFormat(String dateString, String expectedFormat) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(expectedFormat);
            dateFormat.setLenient(false);

            Date date = dateFormat.parse(dateString);

            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
