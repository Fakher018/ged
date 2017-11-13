package Domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_document")
public class Document implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private User users;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idDocument;
	
	public Integer getIdDocument() {
		return idDocument;
	}


	public void setIdDocument(Integer idDocument) {
		this.idDocument = idDocument;
	}


	private String Type;
	private String Titre1;
	private String Titre2;
	private String Body;
	private String Footer;
	private Date Entry_Date;
	private byte[] picture;
	
	
	
	
	
	
	public Document(String type, String titre1) {
		this.Type = type;
		this.Titre1 = titre1;
	}


	public Document() {
		super();
	}


	


	public User getUsers() {
		return users;
	}


	public void setUsers(User users) {
		this.users = users;
	}


	public String getType() {
		return Type;
	}


	public void setType(String type) {
		Type = type;
	}


	public String getTitre1() {
		return Titre1;
	}


	public void setTitre1(String titre1) {
		Titre1 = titre1;
	}


	public String getTitre2() {
		return Titre2;
	}


	public void setTitre2(String titre2) {
		Titre2 = titre2;
	}


	public String getBody() {
		return Body;
	}


	public void setBody(String body) {
		Body = body;
	}


	public String getFooter() {
		return Footer;
	}


	public void setFooter(String footer) {
		Footer = footer;
	}


	public Date getEntry_Date() {
		return Entry_Date;
	}


	public void setEntry_Date(Date entry_Date) {
		Entry_Date = entry_Date;
	}


	public byte[] getPicture() {
		return picture;
	}


	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
//	
//	public User getUsers() {
//		return users;
//	}
//
//	public void setUsers(User users) {
//		this.users = users;
//	}




	}
	
	

