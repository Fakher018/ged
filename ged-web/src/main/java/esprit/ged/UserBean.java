package esprit.ged;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Domain.User;
import Service.UserServiceRemote;





@SessionScoped
@ManagedBean
public class UserBean {
	
	@EJB
	private UserServiceRemote usl;
	
	private User user = new User();
	private Boolean isLogged=false;
	private static User stUser;
	private static User conUser;
	public static int i=0;
	
	
	
	@PostConstruct
	public void initModel() {
		conUser = new User();
		isLogged = false;
	}
	
	public  User getconUser() {
		return conUser;
	}
	
	public  User getStUser() {
		return stUser;
	}
	
	public Boolean getIsLogged() {
		return isLogged;
	}

	public void setIsLogged(Boolean isLogged) {
		this.isLogged = isLogged;
	}
	public List<String> roles(){
		List<String> rls= new ArrayList<String> ();
		rls.add("RH");
		rls.add("Financial");
		rls.add("Admin");
		rls.add("IT");
		return rls;
	}

	public String doLogin(){
		
		
		String navTo="";
		User found = usl.authenticate(user.getLogin(),user.getPassword());
		if(i<3)
		{
		
		if (found != null) {
			conUser=found;
			user = found;
			isLogged = true;
			if (user.getRole().equals("Admin")) {
				navTo = "/pages/admin/manage?faces-redirect=true";
			}
			if (!user.getRole().equals("Admin")) {
				navTo = "/pages/user/success?faces-redirect=true";
			}

		} else {
			i++;
			FacesContext.getCurrentInstance().addMessage(
					"login_form:login_submit",
					new FacesMessage("Wrong Username or Password"));
		}
		}else{
			FacesContext.getCurrentInstance().addMessage(
					"login_form:login_submit",
					new FacesMessage("3 times wrong informations, access blocked for security reasons"));
		}
			
		return navTo;
	}
	
	public String doLogout() {
		String navigateTo = null;
		initModel();
		navigateTo = "/pages/commun/login?faces-redirect=true";
		return navigateTo;
	}
	
	public String addUser(){
		
		String navTo="";
		User found = usl.authenticate(user.getLogin(),user.getPassword());
		if(found!=null)
		{
			return navTo;
			
		}
		usl.createUser(user);
		return navTo="manage?faces-redirect=true";
	}
	
	public String updateUser(User x){
		
		usl.updateUser(x);
		return "manage?faces-redirect=true";
	}
	
	public void deleteUser(User c){
		
		usl.deleteUser(c);

	}
	
	public String goToEditUser(User user){
		
		stUser=user;
		return "editUser?faces-redirect=true";
		
	}
	
	public String goToMail(User user){
		
		stUser=user;
		return "Mail?faces-redirect=true";
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String goToAdd(){
		user = new User();
		return "addUser?faces-redirect=true";		
	}
	
	public String goToEdit(){
		return "editUser?faces-redirect=true";		
	}


}
