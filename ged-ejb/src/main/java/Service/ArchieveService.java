package Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Domain.Archive;



@Stateless
public class ArchieveService implements IArchiveServiceLocal,IArchiveServiceRemote {

	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void AddToArchive(Archive archive) {
		em.merge(archive);
	}

	@Override
	public void removeFromArchive(int id) {
		Archive a = new Archive();
		a.setId(id);
		em.remove(em.merge(a));
	}

	@Override
	public List<Archive> findAllDocumentsInArchive() {
		return em.createQuery("select a from Archive a", Archive.class)
			.getResultList();
	}

	@Override
	public List<Archive> findByTitre(String titre) {
		
		return em.createQuery("select a from Archive a inner join a.documents d where d.Titre1 like :titre ", Archive.class)
				.setParameter("titre", "%"+titre+"%").getResultList();
	}
	
	
	
	

	
	
}
