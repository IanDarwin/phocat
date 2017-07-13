package phocat.metawidget;

import java.util.Date;
import org.jdesktop.beansbinding.Converter;

/** Converter for LocalDateTime */
public class DateConverter extends Converter<Date, String>{

	@Override
	public String convertForward(Date ld) {
		return ld == null ? "" : ld.toString();
	}

	@Override
	public Date convertReverse(String date) {
		return date == null ? null : new Date(Date.parse(date));
	}
}
