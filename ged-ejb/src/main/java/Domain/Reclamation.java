package Domain;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reclamation
 *
 */
@Entity

public class Reclamation implements Serializable {

	   


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String subject;
	private String message;

	private Date reclamDate;
	
	private Date dateTrait;
	
	private Date dateSol;
	private String statuts;
	//Association*
		@ManyToOne
		private User usr;
	private static final long serialVersionUID = 1L;
	
	

	public Reclamation() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}   
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}   
	public Date getReclamDate() {
		return this.reclamDate;
	}

	public void setReclamDate(Date reclamDate) {
		this.reclamDate = reclamDate;
	}   
	public Date getDateTrait() {
		return this.dateTrait;
	}

	public void setDateTrait(Date dateTrait) {
		this.dateTrait = dateTrait;
	}   
	public Date getDateSol() {
		return this.dateSol;
	}

	public void setDateSol(Date dateSol) {
		this.dateSol = dateSol;
	}   
	public String getStatuts() {
		return this.statuts;
	}

	public void setStatuts(String statuts) {
		this.statuts = statuts;
	}
	public User getUsr() {
		return usr;
	}
	public void setUsr(User usr) {
		this.usr = usr;
	}   
}
