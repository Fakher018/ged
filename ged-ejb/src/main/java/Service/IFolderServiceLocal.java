package Service;

import java.util.List;

import javax.ejb.Local;

import Domain.Archive;
import Domain.Folder;
@Local
public interface IFolderServiceLocal {

	public void AddFolder(Folder folder);
	public List<Archive> findAllDocumentsInArchiveByFolder(String Name,String Type) ;
	public List<Folder> findAllFolder() ;
	public void editFolder(Folder f);
}
