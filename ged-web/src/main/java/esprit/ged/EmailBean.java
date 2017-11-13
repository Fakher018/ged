package esprit.ged;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import Domain.Email;
import Domain.Usr;
import Service.EmailServiceLocal;
import Service.UsrServiceLocal;

@ManagedBean
@ViewScoped
public class EmailBean {

	private static final int AUTHENTICATED_USER_ID = 1;

	@EJB
	private EmailServiceLocal emailServiceLocal;	

	@EJB
	private UsrServiceLocal usrServiceLocal;

	private Email email = new Email();
	private Email receivedEmail;

	private String selectedDepartment = "NONE";
	private Integer selectedReceiverId;
	private boolean priorityHigh;

	private boolean isInbox = true;
	private List<Email> listReceivedEmails;

	public List<SelectItem> getDepartments() {
	    List<SelectItem> retVal = new ArrayList<SelectItem>();

	    retVal.add(new SelectItem("Financial"));
	    retVal.add(new SelectItem("RH"));
	    retVal.add(new SelectItem("Administration"));
	    retVal.add(new SelectItem("Reception"));

	    return retVal;
	}

	public List<SelectItem> getReceivers() {
	    List<SelectItem> retVal = new ArrayList<SelectItem>();

	    if (!"NONE".equals(selectedDepartment)) {
		    List<Usr> usrInDepartment = usrServiceLocal.findAllUsrsInDepartment(selectedDepartment);
		    for (Usr usr : usrInDepartment) {
		    	retVal.add(new SelectItem(usr.getIdUser(), usr.getEmailAndName()));
		    }
	    }

	    return retVal;
	}

	public List<Email> getListReceivedEmails() {
		if (listReceivedEmails == null) {
			listReceivedEmails = emailServiceLocal.findAllEmailsReceived(AUTHENTICATED_USER_ID);
		}
		return listReceivedEmails;
	}

	@PostConstruct
	public void init() {
		FacesContext facesCtx = FacesContext.getCurrentInstance();
		String viewId = facesCtx.getViewRoot().getViewId();

		String dir = facesCtx.getExternalContext().getRequestParameterMap().get("dir");
		if ("Outbox".equals(dir)) {
			isInbox = false;
		}

		String email_id_str = facesCtx.getExternalContext().getRequestParameterMap().get("email_id");
		if (email_id_str != null && ("/Template/Email.xhtml".equals(viewId) || "/Template/Send.xhtml".equals(viewId))) {
			Integer email_id = Integer.valueOf(email_id_str);
			email = emailServiceLocal.getEmailById(email_id);

			if (isInbox && "/Template/Email.xhtml".equals(viewId)) {
				emailServiceLocal.markEmailAsRead(email);
			}

			if ("/Template/Send.xhtml".equals(viewId)) {
				receivedEmail = email;
				email = new Email();
				email.setSubject("RE: " + receivedEmail.getSubject());
				selectedDepartment = receivedEmail.getSender().getRole();
				selectedReceiverId = receivedEmail.getSender().getIdUser();
			}
		}

	}

	public String doSendEmail(){
		Usr sender = usrServiceLocal.findUsrById(AUTHENTICATED_USER_ID);
		email.setSender(sender);

		email.setDepartment(selectedDepartment);
		Usr receiver = usrServiceLocal.findUsrById(selectedReceiverId);
		email.setReceiver(receiver);

		email.setPriority(priorityHigh ? 1 : 0);

		emailServiceLocal.sendEmail(email);
		return "/Template/Sent?faces-redirect=true";
	}

	public void doDeleteEmail(Email email){
		emailServiceLocal.delEmail(email);
		for(Iterator<Email> it = listReceivedEmails.iterator(); it.hasNext();) {
			if (email.getEmail_id() == it.next().getEmail_id()) {
				it.remove();
				break;
			}
		}
	}

	public String getSelectedDepartment() {
	    return selectedDepartment;
	}

	public void setSelectedDepartment(String newDepartment) {
	    selectedDepartment = newDepartment;
	}

	public Integer getSelectedReceiverId() {
		return selectedReceiverId;
	}

	public void setSelectedReceiverId(Integer selectedReceiverId) {
		this.selectedReceiverId = selectedReceiverId;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public boolean isPriorityHigh() {
		return priorityHigh;
	}

	public void setPriorityHigh(boolean priorityHigh) {
		this.priorityHigh = priorityHigh;
	}

	public Email getReceivedEmail() {
		return receivedEmail;
	}

	public boolean isInbox() {
		return isInbox;
	}
}