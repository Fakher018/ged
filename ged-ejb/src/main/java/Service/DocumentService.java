package Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Domain.Archive;
import Domain.Documents;
@Stateless
public class DocumentService implements IDocumentServiceLocal,IDocumentServiceRemote {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Documents> findAllDocuments() {
		return em.createQuery("select d from Documents d", Documents.class).getResultList();
	}

	@Override
	public Documents findbyIdDocuments(Integer id) {
	
		Documents d = new Documents();
		
		try{
		
		List<Documents> Doc = em.createQuery("select d from Documents d where d.Id=:i",Documents.class).setParameter("i", id).getResultList();
		d.setId(id);
		d.setTitre1(Doc.get(0).getTitre1());
		d.setTitre2(Doc.get(0).getTitre2());
		d.setBody(Doc.get(0).getBody());
		d.setFooter(Doc.get(0).getFooter());
		d.setPicture(Doc.get(0).getPicture());

		return d;
		}
		catch(Exception e){
			
			System.out.print("sdqsdsqdsqd");
			return null ;
			
		}
	
		
		
		
		
		
	}



	
}
