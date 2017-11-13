package Service;

import java.util.List;

import javax.ejb.Remote;

import Domain.Archive;
import Domain.Folder;
@Remote
public interface IFolderServiceRemote {

	public void AddFolder(Folder folder);
	public List<Archive> findAllDocumentsInArchiveByFolder(String Name,String Type) ;
	public List<Folder> findAllFolder() ;
	public void editFolder(Folder f);
}
