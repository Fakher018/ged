package Service;

import javax.ejb.Remote;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

@Remote
public interface Ms2Remote {
	
	public void sendMail(String fromMail,String username,String password,
            String toMail,String subject,String message) throws AddressException, MessagingException;

}
