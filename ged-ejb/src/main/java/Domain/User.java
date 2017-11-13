package Domain;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class User implements Serializable {

	   
	@Id
	private String cin;
	
	private String login;
	private String password;
	private String nomUser;
	private String prenomUser;
	private String role;
	private String mail;
	private String tel;
	
	@OneToMany(mappedBy="usr",cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	private List<Reclamation> ListReclam;
	
	private static final long serialVersionUID = 1L;
	
	public User() {
		super();
	}   
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public String getPrenomUser() {
		return prenomUser;
	}
	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}


	   
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNomUser() {
		return this.nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
   
}