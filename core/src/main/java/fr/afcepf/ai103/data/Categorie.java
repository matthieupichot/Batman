package fr.afcepf.ai103.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categorie database table.
 * 
 */
@Entity
@NamedQuery(name="Categorie.findAll", query="SELECT c FROM Categorie c")
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_cat;

	private String libelle_cat;

	//bi-directional many-to-one association to SousCategorie
	@OneToMany(mappedBy="categorie")
	private List<SousCategorie> sousCategories;

	public Categorie() {
	}

	public int getId_cat() {
		return this.id_cat;
	}

	public void setId_cat(int id_cat) {
		this.id_cat = id_cat;
	}

	public String getLibelle_cat() {
		return this.libelle_cat;
	}

	public void setLibelle_cat(String libelle_cat) {
		this.libelle_cat = libelle_cat;
	}

	public List<SousCategorie> getSousCategories() {
		return this.sousCategories;
	}

	public void setSousCategories(List<SousCategorie> sousCategories) {
		this.sousCategories = sousCategories;
	}

	public SousCategorie addSousCategory(SousCategorie sousCategory) {
		getSousCategories().add(sousCategory);
		sousCategory.setCategorie(this);

		return sousCategory;
	}

	public SousCategorie removeSousCategory(SousCategorie sousCategory) {
		getSousCategories().remove(sousCategory);
		sousCategory.setCategorie(null);

		return sousCategory;
	}

}