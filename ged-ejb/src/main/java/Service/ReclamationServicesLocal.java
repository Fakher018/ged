package Service;

import java.util.List;

import javax.ejb.Local;

import Domain.Reclamation;
import Domain.User;

@Local
public interface ReclamationServicesLocal {

		public void addRec(Reclamation rec);
		public void editRec(Reclamation rec);
		public void delRec(int id);
		public List<Reclamation> findAllRec();
		public List<Reclamation> findRecByUser(User user);
		  public Long countTreated();
		    public Long countUntreated();
		    public Long countInProgress();
		    public Long countTreatedByMonth(int i);


}

