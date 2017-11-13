package Domain;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Documents
 *
 */
@Entity
public class Documents implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	private String Type;
	private String Titre1;
	private String Titre2;
	@Column(columnDefinition = "TEXT")
	private String Body;
	private String Footer;
	private Date Entry_Date;
	private byte[] picture;
	
	private static final long serialVersionUID = 1L;

	public Documents() {
		super();
	}   
	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}   
	public String getType() {
		return this.Type;
	}

	public void setType(String Type) {
		this.Type = Type;
	}   
	public String getTitre1() {
		return this.Titre1;
	}

	public void setTitre1(String Titre1) {
		this.Titre1 = Titre1;
	}   
	public String getTitre2() {
		return this.Titre2;
	}

	public void setTitre2(String Titre2) {
		this.Titre2 = Titre2;
	}   
	public String getBody() {
		return this.Body;
	}

	public void setBody(String Body) {
		this.Body = Body;
	}   
	public Date getEntry_Date() {
		return this.Entry_Date;
	}

	public void setEntry_Date(Date Entry_Date) {
		this.Entry_Date = Entry_Date;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	public String getFooter() {
		return Footer;
	}
	public void setFooter(String footer) {
		Footer = footer;
	}
   
}
