package Domain;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Email implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int email_id;

	private String subject;
	private String message;
	private String department;
	@ManyToOne
	private Usr receiver;
	@ManyToOne
	private Usr sender;

	public Usr getReceiver() {
		return receiver;
	}

	public void setReceiver(Usr receiver) {
		this.receiver = receiver;
	}

	public Usr getSender() {
		return sender;
	}

	public void setSender(Usr sender) {
		this.sender = sender;
	}


	private int priority;
	
	private int opened;
	@Basic(optional = false)
	@Column(name = "send_date", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date send_date;
	
	private Date edit_date;
	
	

	public int getEmail_id() {
		return email_id;
	}

	public void setEmail_id(int email_id) {
		this.email_id = email_id;
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

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getOpened() {
		return opened;
	}

	public void setOpened(int opened) {
		this.opened = opened;
	}

	public Date getSend_date() {
		return send_date;
	}

	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}

	public Date getEdit_date() {
		return edit_date;
	}

	public void setEdit_date(Date edit_date) {
		this.edit_date = edit_date;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
}


