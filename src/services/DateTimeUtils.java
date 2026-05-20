package services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
	public static String toLocal() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
		Instant instant = Instant.now();
		
		LocalDateTime moment = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		
		return moment.format(fmt);
	}
}
