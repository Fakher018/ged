package Service;

import java.util.List;

import javax.ejb.Local;

import Domain.Email;

@Local
public interface EmailServiceLocal {
	
	public Email getEmailById(Integer email_id);
	public void sendEmail(Email email);
	public void editEmail(Email email);
	public void delEmail(Email email);
	public List<Email> findAllEmailsSent(String sender_id);
	public List<Email> findAllEmailsReceived(int receiver_id);
	public void markEmailAsRead(Email email);
}
