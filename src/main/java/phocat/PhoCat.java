package phocat;

import java.time.LocalDateTime;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import org.metawidget.inspector.annotation.MetawidgetAnnotationInspector;
import org.metawidget.inspector.composite.CompositeInspector;
import org.metawidget.inspector.composite.CompositeInspectorConfig;
import org.metawidget.inspector.propertytype.PropertyTypeInspector;
import org.metawidget.swing.SwingMetawidget;
import org.metawidget.swing.widgetprocessor.binding.beansbinding.BeansBindingProcessor;
import org.metawidget.swing.widgetprocessor.binding.beansbinding.BeansBindingProcessorConfig;

import phocat.metawidget.DateConverter;
import phocat.metawidget.LocalDateTimeConverter;
import phocat.model.Image;

public class PhoCat {
	
	static SwingMetawidget metawidget;
	
	static BeansBindingProcessorConfig beansBindingProcessorConfig = 
			new BeansBindingProcessorConfig();
	static DateConverter dateConverter = new DateConverter();
	static LocalDateTimeConverter localDateTimeConverter = new LocalDateTimeConverter();

	public static void main(String[] args) {
		JFrame jf = new JFrame("PhoCat");

		metawidget = new SwingMetawidget();
		metawidget.setBorder(BorderFactory.createTitledBorder("Imagine"));
		Image im = new Image();
		im.setImagePath("2017/06/04/ifd9999");
		im.setId(1234);
		im.getKeywords().add("Ian");
		im.getKeywords().add("Betty");
		im.getKeywords().add("Cattifer");
		@SuppressWarnings("deprecation")
		Date created = new Date(2011-1900, 06, 01, 12, 12, 12);
		im.setCreated(created);
		im.setModified(new Date());
		CompositeInspectorConfig inspectorConfig = 
				new CompositeInspectorConfig().setInspectors(
						new PropertyTypeInspector(),
						new MetawidgetAnnotationInspector());
		metawidget.setInspector(new CompositeInspector(inspectorConfig));
		beansBindingProcessorConfig.setConverter(Date.class, String.class, dateConverter);
		beansBindingProcessorConfig.setConverter(LocalDateTime.class, String.class, localDateTimeConverter);
		metawidget.addWidgetProcessor(new BeansBindingProcessor(beansBindingProcessorConfig));
		metawidget.setToInspect(im);

		jf.add(metawidget);

		jf.setSize(500, 400);
		jf.setLocation(200, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

}
