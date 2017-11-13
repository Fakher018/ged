package Service;

import java.util.List;

import javax.ejb.Remote;

import Domain.Usr;

@Remote
public interface UsrServiceRemote {

	public List<Usr> findAllUsrsInDepartment(String department_name);

}
