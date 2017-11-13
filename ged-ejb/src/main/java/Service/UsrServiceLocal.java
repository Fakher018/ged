package Service;

import java.util.List;

import javax.ejb.Local;

import Domain.Usr;

@Local
public interface UsrServiceLocal {

	public List<Usr> findAllUsrsInDepartment(String department_name);

	public Usr findUsrById(Integer usr_id);
}
