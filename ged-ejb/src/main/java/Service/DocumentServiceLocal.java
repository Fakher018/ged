package Service;

import java.util.List;

import javax.ejb.Local;

import Domain.Document;
import Domain.Rating;


@Local
public interface DocumentServiceLocal {

	public void add(Document doc);
	public void updateDoc(Document doc);
	public List<Document> getDocument();
	public void ajouterDocument(Document document);
	public void removeEmployee(int idDcument);
	//List<Document> findByTitre(String titre);
	public Rating nbrR(int id);
	public void update(Rating r);
	public void addPostt(Rating r ) ;

}
