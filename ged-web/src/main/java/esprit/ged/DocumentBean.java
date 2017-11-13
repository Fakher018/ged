package esprit.ged;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.event.FileUploadEvent;

import Domain.Document;
import Domain.Rating;
import Service.DocumentServiceLocal;


@ManagedBean
public class DocumentBean {
	private int id;

	private Document document;
	private static Document stDocument;
	private String Type;
	private String Titre1;
	private boolean formDisplayed;
	private int documentIdToBeUpdated;
	
private DocumentServiceLocal docService;	
private String titre;
private int rating;

private List<Rating> ratings;

public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}

@EJB
private DocumentServiceLocal rsl;

private static List<Document> Searchedarchives;
 

private List<Document> ListDoc= new ArrayList<>();


//public List<Document>getDocuments(){
	//return rsl.findAllDoc();
//}
	


public String addDocument(){
	stDocument= new Document();
	return "AddDoc?faces-redirect=true";
}


public String getTitre() {
	return titre;
}


public void setTitre(String titre) {
	this.titre = titre;
}


public String save(){
	
	rsl.ajouterDocument(stDocument);
	return "/views/ListDoc?faces-redirect=true";
	
}


public void handleFileUpload(FileUploadEvent event) {
	byte[] picture = event.getFile().getContents();
	document.setPicture(picture);
}




public int getRating() {
	return rating;
}


public void setRating(int rating) {
	this.rating = rating;
}


public  Document getStDocument() {
	return stDocument;
}





public  void setStDocument(Document stDocument) {
	DocumentBean.stDocument = stDocument;
}





public Document getDocument() {
	return document;
}
public void setDocument(Document document) {
	this.document = document;
}
public void supprimer(int idDocument ){
	rsl.removeEmployee(idDocument);
	System.out.println("employe"+idDocument+"est supprimé");
	
}
public String modifier(Document doc){
	
	String navigateTo="null";
	stDocument = doc;
	
//	this.setDocumentIdToBeUpdated(doc.getIdDocument());
	navigateTo = "AddDoc?faces-redirect=true";
	return navigateTo;
	
}

public int getDocumentIdToBeUpdated() {
	return documentIdToBeUpdated;
}
public void setDocumentIdToBeUpdated(int documentIdToBeUpdated) {
	this.documentIdToBeUpdated = documentIdToBeUpdated;
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


public List<Document> getListDoc() {
	System.out.println("sa7a frer");
	return rsl.getDocument();
}


public void setListDoc(List<Document> listDoc) {
	ListDoc = listDoc;
}

//public List<Document> searchDocumentsTitreInArchive() {

	//Searchedarchives = docService.findByTitre(titre);
	//try {
		
		//FacesContext.getCurrentInstance().getExternalContext().redirect("/ged-web/Pages/Archive/ListSearched.jsf");
	//} catch (IOException e) {
		/// TODO Auto-generated catch block
		//e.printStackTrace();
	//}
	//return null;

//}


	
public String doSaveR(){
	String res =null;
	if (rating == 5 ) 
	{
		int nbr=rsl.nbrR(id).getNbrStar(); 
		rsl.update(new Rating(id,nbr+1,id));
	}
	return res;
}
	
	
		
		
	
	




}









