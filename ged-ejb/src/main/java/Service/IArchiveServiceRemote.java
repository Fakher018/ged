package Service;

import java.util.List;


import javax.ejb.Remote;

import Domain.Archive;



@Remote
public interface IArchiveServiceRemote {


	public void AddToArchive(Archive archive);
	public void removeFromArchive(int id);
	public List<Archive> findAllDocumentsInArchive() ;
	public List<Archive> findByTitre(String titre) ;

}
