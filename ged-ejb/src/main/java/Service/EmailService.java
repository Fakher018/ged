package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Domain.Email;

/**
 * Session Bean implementation class EmailService
 */
@Stateless
@LocalBean
public class EmailService implements EmailServiceRemote, EmailServiceLocal {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public EmailService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Email getEmailById(Integer email_id) {
		return em.find(Email.class, email_id);
	}

	@Override
	public void sendEmail(Email email) {
		em.merge(email);
	}

	@Override
	public void editEmail(Email email) {
		em.merge(email);
	}

	public void markEmailAsRead(Email email) {
		getEmailById(email.getEmail_id()).setOpened(1);
	}

	@Override
	public void delEmail(Email email) {
		em.remove(em.merge(email));
	}

	@Override
	public List<Email> findAllEmailsSent(String sender_id) {
		return em.createQuery("select r from Email r where r.sender_idUser=?1" ,Email.class)
				.setParameter(1, sender_id).getResultList();
	}

	@Override
	public List<Email> findAllEmailsReceived(int receiver_id) {
		return em.createQuery("select r from Email r where r.receiver.idUser=:x" ,Email.class)
				.setParameter("x", receiver_id).getResultList();
	}

}
