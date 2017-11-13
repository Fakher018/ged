package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Domain.Usr;

/**
 * Session Bean implementation class UsrService
 */
@Stateless
@LocalBean
public class UsrService implements UsrServiceRemote, UsrServiceLocal {
	
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public UsrService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Usr> findAllUsrsInDepartment(String department_name) {
		return em.createQuery("select r from Usr r where r.role=?1", Usr.class)
				.setParameter(1, department_name).getResultList();
	}

	@Override
	public Usr findUsrById(Integer usr_id) {
		return em.find(Usr.class, usr_id);
	}

}
