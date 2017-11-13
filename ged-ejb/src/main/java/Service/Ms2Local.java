package Service;

import javax.ejb.Local;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

@Local
public interface Ms2Local {
	
	public void sendMail(String fromMail,String username,String password,
            String toMail,String subject,String message) throws AddressException, MessagingException;

}
