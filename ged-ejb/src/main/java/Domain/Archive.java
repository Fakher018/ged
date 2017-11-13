package Domain;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Archive
 *
 */
@Entity
public class Archive implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	@ManyToOne
	@JoinColumn(name = "folder_fk")
	private Folder folder;
	private String version;
	private Date Date_archive ;
	
	@ManyToOne
	@JoinColumn(name = "document_fk")
	private Documents documents; 
	private static final long serialVersionUID = 1L;

	public Archive() {
		
		super();
		Date_archive = new Date();
	}   
	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}   
	public Folder getFolder() {
		return this.folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}   


	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Date getDate_archive() {
		return Date_archive;
	}
	public void setDate_archive(Date Date_archive) {
		this.Date_archive = Date_archive;
	}   

	public Documents getDocuments() {
		return documents;
	}
	public void setDocuments(Documents documents) {
		this.documents = documents;
	}
   
}
