package phocat;

import java.awt.BorderLayout;
import java.time.LocalDateTime;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

		jf.add(BorderLayout.CENTER, metawidget);
		
		JPanel bottom = new JPanel();
		bottom.setBorder(BorderFactory.createTitledBorder("Controls"));
		bottom.add(new JLabel("+Keyword:"));
		final JTextField newKwdField = new JTextField(20);
		newKwdField.addActionListener(e->{
			im.getKeywords().add(newKwdField.getText());
			newKwdField.setText(null);
		});
		bottom.add(newKwdField);
		final JButton saveButton = new JButton("Save");
		bottom.add(saveButton);
		final JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(e->System.exit(0));
		bottom.add(quitButton);
		
		jf.add(BorderLayout.SOUTH, bottom);

		jf.setSize(600, 500);
		jf.setLocation(200, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

}
