package esprit.ged;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Domain.Reclamation;
import Domain.User;
import Service.ReclamationServicesLocal;


@ManagedBean
@ViewScoped
public class reclamBean {
@EJB
private ReclamationServicesLocal rsl;
private Reclamation rec = new Reclamation();
private User user= new User();
private boolean isTreated=false;
private boolean inProgress=true;
private boolean formDisp=false;

public Reclamation getRec() {
	return rec;
}

public void setRec(Reclamation rec) {
	this.rec = rec;
}

public String doEdit(){
	rec.setReclamDate(new Date());
	user.setCin("09192735");
    rec.setUsr(user);
	rsl.editRec(rec);
	formDisp=false;
	return "";
}

public List<Reclamation>getAllReclam(){
	return rsl.findAllRec();
}
public List<Reclamation>getMyReclamation(){
	user.setCin("09192735");
 return rsl.findRecByUser(user); 
}


public String doInProgress(){
	rec.setDateTrait(new Date());
	rec.setStatuts("In Progress");
	rsl.editRec(rec);
	isTreated=true;
	inProgress=false;
	return"";
}

	public String doDelete(Reclamation rec){
		rsl.delRec(rec.getId());
		System.out.println(rec.getId());
		formDisp=false;
		System.out.println("here!!!!!!!");
		return "CrudUser?faces-redirect=true";
	}
	

	public String doTreated(){
		rec.setDateSol(new Date());
		rec.setDateTrait(new Date());
		rec.setStatuts("Treated");
		rsl.editRec(rec);
		
		isTreated=false;
		inProgress=false;
		return"";
}
public String doSave(){
    rec.setReclamDate(new Date());
    rec.setStatuts("Not Treated");
    user.setCin("09192735");
    rec.setUsr(user);
	rsl.addRec(rec);
	formDisp=false;
	return"";
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public boolean isTreated() {
	return isTreated;
}

public void setTreated(boolean isTreated) {
	this.isTreated = isTreated;
}

public boolean isInProgress() {
	return inProgress;
}

public void setInProgress(boolean inProgress) {
	this.inProgress = inProgress;
}

public boolean isFormDisp() {
	return formDisp;
}

public void setFormDisp(boolean formDisp) {
	this.formDisp = formDisp;
}



}


