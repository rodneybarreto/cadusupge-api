package br.dev.rodneybarreto.cadusupgeapi.helper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateHelper {
	
	private static final String FORMATO = "dd/MM/yyyy";
	
	private DateHelper() {
	}
	
	public static LocalDate toDate(String dataStr) {
		return LocalDate.parse(dataStr, DateTimeFormatter.ofPattern(FORMATO));
	}
	
	public static String toString(LocalDate date) {
		return date.format(DateTimeFormatter.ofPattern(FORMATO));
	}

}
