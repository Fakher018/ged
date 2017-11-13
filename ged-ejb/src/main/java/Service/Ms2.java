package Service;

import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Session Bean implementation class Ms2
 */
@Stateless
@LocalBean
public class Ms2 implements Ms2Remote, Ms2Local {

    /**
     * Default constructor. 
     */
    public Ms2() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void sendMail(String fromMail, String username, String password, String toMail, String subject,
			String message) throws AddressException, MessagingException {
		Properties props=System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        
        
        props.put("mail.smtp.starttls.enable","true");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.socketFactory.port", "587");
                props.put("mail.smtp.socketFactory.fallback", "false");
                
                Session mailSession=Session.getDefaultInstance(props, null);
                mailSession.setDebug(true);
                
                Message mailMessage=new MimeMessage(mailSession);
               try
               {
                mailMessage.setFrom(new InternetAddress(fromMail));
                mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
                mailMessage.setContent(message,"text/html");
                mailMessage.setSubject(subject);
                
                Transport transport=mailSession.getTransport("smtp");
                transport.connect("smtp.gmail.com", username, password);
                transport.sendMessage(mailMessage, mailMessage.getAllRecipients());   
               }catch(Exception e){}
		
	}

}
