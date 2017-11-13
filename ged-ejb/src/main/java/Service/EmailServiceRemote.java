package Service;


import java.util.List;

import javax.ejb.Remote;

import Domain.Email;

@Remote
public interface EmailServiceRemote {
	
	public Email getEmailById(Integer email_id);
	public void sendEmail(Email email);
	public void editEmail(Email email);
	public void delEmail(Email email);
	public List<Email> findAllEmailsSent(String sender_id);
	public List<Email> findAllEmailsReceived(int receiver_id);
	public void markEmailAsRead(Email email);
	

}
