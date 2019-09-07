package br.dev.rodneybarreto.cadusupgeapi.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StringConverter {
	
	private StringConverter() {
	}
	
	public static LocalDate toDate(String dataStr) {
		return LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

}
