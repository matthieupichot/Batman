package fr.afcepf.ai103.test;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import fr.afcepf.ai103.dao.DaoCategorie;
import fr.afcepf.ai103.dao.DaoProduit;
import fr.afcepf.ai103.dao.DaoSousCategorie;
import fr.afcepf.ai103.data.Categorie;
import fr.afcepf.ai103.data.Produit;
import fr.afcepf.ai103.data.SousCategorie;


public class DaoTest 
{
//	@Test
//	public void monTest()
//	{
//		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("core");
		
//		DaoSousCategorie daosouscategorie = new DaoSousCategorie();
//		daosouscategorie.setEntityManager(emf.createEntityManager());
//		daosouscategorie.getEntityManager().getTransaction().begin(); // connection BDD
//		List<SousCategorie> souscategories = daosouscategorie.getSousCategoriebyIDCategorie(1);
//		for (SousCategorie souscategorie : souscategories)
//		{ 
//			System.out.println(souscategorie.toString());
//		}
	
//		DaoProduit daoproduit = new DaoProduit();
//		daoproduit.setEntityManager(emf.createEntityManager());
//		daoproduit.getEntityManager().getTransaction().begin(); // connection BDD
//		List<Produit> produits = daoproduit.GetProduitbyIDSousCategorie(16);
//		for (Produit produit : produits)
//		{ 
//			System.out.println(produit.toString());
//		}
//						
//	}
}
