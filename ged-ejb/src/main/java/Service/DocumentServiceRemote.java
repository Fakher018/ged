package Service;

import java.util.List;

import Domain.Document;

public interface DocumentServiceRemote {

	public void addDoc(Document doc);
	public void removeEmployee(int idDcument);
	public void updateDco(Document doc);
	public List<Document> getDocument();
	public void ajouterDocument(Document document);
	
}
