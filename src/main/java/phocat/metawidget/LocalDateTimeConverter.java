package phocat.metawidget;

import java.time.LocalDateTime;
import org.jdesktop.beansbinding.Converter;

/** Converter for LocalDateTime */
public class LocalDateTimeConverter extends Converter<LocalDateTime,String>{

	@Override
	public String convertForward(LocalDateTime ld) {
		return ld == null ? "" : ld.toString();
	}

	@Override
	public LocalDateTime convertReverse(String date) {
		return date == null ? null : LocalDateTime.parse(date);
	}

}
