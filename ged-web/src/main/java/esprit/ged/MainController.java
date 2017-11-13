package esprit.ged;






import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Service.Ms2Local;




/**
 *
 * @author 
 */

@SessionScoped
@ManagedBean(name = "mailgctr")
public class MainController  {
	
	
	@EJB
    private Ms2Local msl;
	
	

    /**
	 * 
	 */

	private String fromMail;
    private String username;
    private String password;
    private String toMail;
    private String subject;
    private String message;
    
    public String send(){
    	
    	try {
			msl.sendMail(fromMail, username, password, toMail, subject, message);
		} catch (Exception e) {
		
		}
        return "/pages/manage?faces-redirect=true";
    }

    public String getFromMail() {
        return fromMail;
    }

    public void setFromMail(String fromMail) {
        this.fromMail = fromMail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToMail() {
        return toMail;
    }

    public void setToMail(String toMail) {
        this.toMail = toMail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    


     


}
