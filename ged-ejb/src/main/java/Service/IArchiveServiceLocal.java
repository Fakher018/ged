package Service;

import java.util.List;

import javax.ejb.Local;

import Domain.Archive;
@Local
public interface IArchiveServiceLocal {

	
	public void AddToArchive(Archive archive);
	public void removeFromArchive(int id);
	public List<Archive> findAllDocumentsInArchive() ;
	public List<Archive> findByTitre(String titre) ;
	
}
