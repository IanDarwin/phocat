package phocat.model;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.metawidget.inspector.annotation.UiComesAfter;
import org.metawidget.inspector.annotation.UiReadOnly;
import org.metawidget.inspector.annotation.UiSection;

@Entity
public class Image implements Serializable {

	private static final long serialVersionUID = 7803852963878358639L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	// N.B. MetaWidget ONLY supports accessor annotation, not field.
	private String imagePath;
	private List<String> keywords = new ArrayList<>();
	private Date created;
	private Date modified;
	
	/** The image path, relative to the top-level Pictures directory */
	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	@UiReadOnly
	@UiComesAfter("imagePath")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	/** The keywords - really why we're here */
	@UiComesAfter("id")
	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	
	@UiSection("Metadata")
	
	/** The creation date if known */
	@UiComesAfter("keywords")
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	/** The modification time of the image file */
	@UiComesAfter("created")
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
}
