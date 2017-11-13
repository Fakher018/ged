package Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Domain.Archive;

import Domain.Folder;

@Stateless
public class FolderService implements IFolderServiceLocal,IFolderServiceRemote {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void AddFolder(Folder folder) {
		em.persist(folder);
		
	}

	@Override
	public List<Archive> findAllDocumentsInArchiveByFolder(String Name,String Type) {
	
			
			return em.createQuery("select a from Archive a inner join a.folder f where f.Name like :Name and f.Type like :Type ", Archive.class)
					.setParameter("Name", "%"+Name+"%").setParameter("Type", "%"+Type+"%").getResultList();
		
		
	}

	@Override
	public List<Folder> findAllFolder() {
		return em.createQuery("select d from Folder d", Folder.class).getResultList();
	}

	@Override
	public void editFolder(Folder f) {
		em.merge(f);
		
	}

}
