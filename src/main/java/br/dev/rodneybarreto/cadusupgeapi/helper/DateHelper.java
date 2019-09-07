package br.dev.rodneybarreto.cadusupgeapi.helper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateHelper {
	
	private DateHelper() {
	}
	
	public static LocalDate toDate(String dataStr) {
		return LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

}
