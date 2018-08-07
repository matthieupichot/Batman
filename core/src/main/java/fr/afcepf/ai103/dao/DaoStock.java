package fr.afcepf.ai103.dao;


import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import fr.afcepf.ai103.data.Stock;


@Stateless
@Local
public class DaoStock implements IDaoStock {

	@PersistenceContext(unitName="core")
	private EntityManager entityManager;
	

	public DaoStock() {
		
	}


	@Override
	public Stock AjouterProduit(Stock s) throws Exception {
		
		try {
			entityManager.persist(s);
		}
		catch(Exception e) {
			throw new Exception("Impossible d'ajouter le produit");
		}
		return s;
	}
	
	@Override
	
	public List<Stock> getAllStock()
	{
		return entityManager.createNamedQuery("Stock.findAll",Stock.class).getResultList();
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
		
}

