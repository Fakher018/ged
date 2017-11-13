package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Domain.Reclamation;
import Domain.User;

/**
 * Session Bean implementation class ReclamationServices
 */
@Stateless
@LocalBean
public class ReclamationServices implements ReclamationServicesRemote, ReclamationServicesLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public ReclamationServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addRec(Reclamation rec) {
		em.merge(rec);
		
	}

	@Override
	public void editRec(Reclamation rec) {
		em.merge(rec);
	
		
	}

	@Override
	public void delRec(int id) {
		em.createQuery("delete from Reclamation r where r.id=?1").setParameter(1,id).executeUpdate();
	}

	@Override
	public List<Reclamation> findAllRec() {
		return em.createQuery("select r from Reclamation r", Reclamation.class).getResultList()
				;
	
	}

	

	@Override
	public List<Reclamation> findRecByUser(User user) {
		return em.createQuery("select r from Reclamation r where r.usr=?1", Reclamation.class).setParameter(1,user).getResultList();
		
	}

	@Override
	public Long countTreated() {
		TypedQuery<Long> query= em.createQuery("select count (r) from Reclamation r where r.statuts='Treated'", Long.class);
				return (Long)query.getSingleResult();
	}

	@Override
	public Long countUntreated() {
    	 TypedQuery<Long> query=em.createQuery("select count (r) from Reclamation r where r.statuts='Not Treated'", Long.class);
    	 return (Long)query.getSingleResult();
	}

	@Override
	public Long countInProgress() {
		TypedQuery<Long> query=em.createQuery("select count (r) from Reclamation r where r.statuts='In Progress'",Long.class);
		return (Long)query.getSingleResult();
		}

	@Override
	public Long countTreatedByMonth(int i) {
		TypedQuery<Long> query=em.createQuery("select count (r) from Reclamation r where MONTH(r.reclamDate)=?1",Long.class).setParameter(1,i);
		return (Long)query.getSingleResult();
		
	}

}