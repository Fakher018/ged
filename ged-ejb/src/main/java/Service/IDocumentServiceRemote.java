package Service;

import java.util.List;

import javax.ejb.Remote;

import Domain.Documents;
@Remote
public interface IDocumentServiceRemote {
	public List<Documents> findAllDocuments() ;
	public Documents findbyIdDocuments(Integer id) ;
	
}
