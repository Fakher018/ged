package Domain;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usr
 *
 */
@Entity

public class Usr implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String role;
	private String phone;
	//Association*
	@OneToMany(mappedBy="usr",cascade={CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.EAGER)
	private List<Reclamation> ListReclam;
	
	@OneToMany(mappedBy="sender")
	private List<Email> email_sender;
	
	@OneToMany(mappedBy="receiver")
	private List<Email> email_receiver;
	
	public String getEmailAndName() {
		String res = "";
		if (email == null) {
			if (firstName == null && lastName == null) return "User " + idUser;
		} else {
			res = email;
			if (firstName == null && lastName == null) return res;
			res += " - ";
		}
		if (firstName != null) res += firstName + " ";
		if (lastName != null) res += lastName;
		return res;
	}

	public List<Email> getEmail_receiver() {
		return email_receiver;
	}
	public void setEmail_receiver(List<Email> email_receiver) {
		this.email_receiver = email_receiver;
	}
	public List<Reclamation> getListReclam() {
		return ListReclam;
	}
	public void setListReclam(List<Reclamation> listReclam) {
		ListReclam = listReclam;
	}

	private static final long serialVersionUID = 1L;
	


	public Usr() {
		super();
	}   
	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
   
}
