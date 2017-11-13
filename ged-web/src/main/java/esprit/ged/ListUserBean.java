package esprit.ged;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Domain.User;
import Service.UserServiceRemote;





@SessionScoped
@ManagedBean
public class ListUserBean {
	
	@EJB
	private UserServiceRemote usl;
	private String searchName="";
	private  List<User> listUser= new ArrayList<User>();
	public List<User> listUserTest= new ArrayList<User>();
	

	
	public List<User> init(){
		
		listUser = usl.findAllUsers();
		if(searchName.equals(""))
		{
		return listUser;
		}else
		{
			return listUserTest;
		}
	}
	
	
	public String getSearchName() {
		return searchName;
	}


	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}


	public String search(){
		String test="";
		listUserTest.clear();
		
		listUser = usl.findAllUsers();
		for (User user : listUser) {
			test=user.getCin()+user.getLogin()+user.getMail()+user.getNomUser()+user.getPassword()+user.getPrenomUser()+user.getRole();
			if (test.contains(searchName)) {
				listUserTest.add(user);	
			}
		}
		return "/pages/admin/manage?faces-redirect=true";
	}
	
	

	public UserServiceRemote getusl() {
		return usl;
	}

	public void setusl(UserServiceRemote usl) {
		this.usl = usl;
	}

	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> ListUser) {
		this.listUser = ListUser;
	}	
	
	

}
