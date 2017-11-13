package Service;

import java.util.List;

import javax.ejb.Local;

import Domain.Documents;
@Local
public interface IDocumentServiceLocal {
	public List<Documents> findAllDocuments() ;
	public Documents findbyIdDocuments(Integer id) ;
	
}
