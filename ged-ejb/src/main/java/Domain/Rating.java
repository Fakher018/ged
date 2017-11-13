package Domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Rating implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private int idDocument;
	private int nbrStar;
	@OneToOne Document document;
	public Rating (int id,int rating,int idDocument){
		this.id=id;
		this.idDocument=idDocument;
		nbrStar=rating;
	}
	public Rating()
	{
	}
	public int getId() {
		return id;
	}
	public int getIdDocument() {
		return idDocument;	
	}
	public void setIdDocument(int idDocument) {
		this.idDocument = idDocument;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getNbrStar() {
		return nbrStar;
	}
	public void setNbrStar(int nbrStar) {
		this.nbrStar = nbrStar;
	}
	
}

