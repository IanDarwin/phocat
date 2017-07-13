package phocat.model;

import static org.junit.Assert.*;
import org.junit.Test;

public class ImageTest {

	@Test
	public void testImage() {
		Image im = new Image();
		im.setImagePath("/foo/bar/123");
		assertEquals("/foo/bar/123", im.getImagePath());
	}
}
