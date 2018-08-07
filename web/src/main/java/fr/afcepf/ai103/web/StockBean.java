package fr.afcepf.ai103.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import fr.afcepf.ai103.dao.IDaoCategorie;
import fr.afcepf.ai103.dao.IDaoProduit;
import fr.afcepf.ai103.dao.IDaoSousCategorie;
import fr.afcepf.ai103.dao.IDaoStock;
import fr.afcepf.ai103.data.Produit;
import fr.afcepf.ai103.data.SousCategorie;
import fr.afcepf.ai103.data.Stock;
import fr.afcepf.ai103.data.Utilisateur;
import fr.afcepf.ai103.data.Categorie;


@ManagedBean
@SessionScoped
public class StockBean {
	
	@EJB
	private IDaoStock daostock;
	
	@EJB
	private IDaoCategorie categorie;
	
	@EJB
	private IDaoSousCategorie sous_categorie;
	
	@EJB
	private IDaoProduit produit;
		
	private List<Categorie> categories;
	
	private List<SousCategorie> sous_categories;
	
	private List<Produit> produits;
		
	private Date date_peremption;
	
	private Integer duree_ext_stock ;
		
	private Double prix;
	
	private Double qte_initiale;
				 
	private int id_cat;

	private String libelle_cat;
	
	private int id_sous_cat;

	private String libelle_sous_cat;
		
	private int id_prod;


	public StockBean() {
		
			
	}  
	
	@PostConstruct
	public void init()
	{
		categories = categorie.getAllCategorie();
		
	}
		
	public void AjoutProduitDansStock() throws Exception 
	
	{
		 Stock stock = new Stock();
		 stock.getUtilisateur().setId_user(1);
		 stock.getProduit().setId_prod(id_prod);
		 stock.setDate_peremption(date_peremption);
		 stock.setDuree_ext_stock(duree_ext_stock);
		 stock.setPrix(prix);
		 stock.setQte_initiale(qte_initiale);
		 stock.setDate_ajout(new Date()); 
		 
		 daostock.AjouterProduit(stock);	 
				 
	}
	
	public void ChargementSousCategories (ValueChangeEvent e)
	
	{
		
		id_cat = (int) e.getNewValue();
		sous_categories = sous_categorie.getSousCategoriebyIDCategorie(id_cat);
		
		if (produits !=null)
			
		{
			produits.clear();
		}
		
	}
	
	public void ChargementLibelle (ValueChangeEvent e)
	
	{
	
		id_sous_cat = (int) e.getNewValue();
		produits = produit.GetProduitbyIDSousCategorie(id_sous_cat);
	
	}
		
	public Date getDate_peremption() {
		return date_peremption;
	}

	public void setDate_peremption(Date date_peremption) {
		this.date_peremption = date_peremption;
	}
	
	public IDaoStock getDaostock() {
		return daostock;
	}

	public void setDaostock(IDaoStock daostock) {
		this.daostock = daostock;
	}


	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public IDaoCategorie getCategorie() {
		return categorie;
	}

	public void setCategorie(IDaoCategorie categorie) {
		this.categorie = categorie;
	}

	public List<SousCategorie> getSous_categories() {
		return sous_categories;
	}

	public void setSous_categories(List<SousCategorie> sous_categories) {
		this.sous_categories = sous_categories;
	}

	public IDaoSousCategorie getSous_categorie() {
		return sous_categorie;
	}

	public void setSous_categorie(IDaoSousCategorie sous_categorie) {
		this.sous_categorie = sous_categorie;
	}

	public int getId_cat() {
		return id_cat;
	}

	public void setId_cat(int id_cat) {
		this.id_cat = id_cat;
	}

	public String getLibelle_cat() {
		return libelle_cat;
	}

	public void setLibelle_cat(String libelle_cat) {
		this.libelle_cat = libelle_cat;
	}

	public int getId_sous_cat() {
		return id_sous_cat;
	}

	public void setId_sous_cat(int id_sous_cat) {
		this.id_sous_cat = id_sous_cat;
	}

	public String getLibelle_sous_cat() {
		return libelle_sous_cat;
	}

	public void setLibelle_sous_cat(String libelle_sous_cat) {
		this.libelle_sous_cat = libelle_sous_cat;
	}

	public IDaoProduit getProduit() {
		return produit;
	}

	public void setProduit(IDaoProduit produit) {
		this.produit = produit;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public int getId_prod() {
		return id_prod;
	}

	public void setId_prod(int id_prod) {
		this.id_prod = id_prod;
	}

	public Integer getDuree_ext_stock() {
		return duree_ext_stock;
	}

	public void setDuree_ext_stock(Integer duree_ext_stock) {
		this.duree_ext_stock = duree_ext_stock;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Double getQte_initiale() {
		return qte_initiale;
	}

	public void setQte_initiale(Double qte_initiale) {
		this.qte_initiale = qte_initiale;
	}
	 
	
}
