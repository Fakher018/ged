package Service;

import java.util.List;

import javax.ejb.Remote;

import Domain.Reclamation;

@Remote
public interface ReclamationServicesRemote {
	public void addRec(Reclamation rec);
	public void editRec(Reclamation rec);
	public void delRec(int id);
	public List<Reclamation> findAllRec();
	public Long countTreated();
    public Long countUntreated();
    public Long countInProgress();
    public Long countTreatedByMonth(int i);
}
