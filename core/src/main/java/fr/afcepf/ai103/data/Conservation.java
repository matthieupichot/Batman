package fr.afcepf.ai103.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the conservation database table.
 * 
 */
@Entity
@NamedQuery(name="Conservation.findAll", query="SELECT c FROM Conservation c")
public class Conservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_conserv;

	private int duree_ext_conserv;

	private String type;

	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="conservation")
	private List<Produit> produits;

	public Conservation() {
	}

	public int getId_conserv() {
		return this.id_conserv;
	}

	public void setId_conserv(int id_conserv) {
		this.id_conserv = id_conserv;
	}

	public int getDuree_ext_conserv() {
		return this.duree_ext_conserv;
	}

	public void setDuree_ext_conserv(int duree_ext_conserv) {
		this.duree_ext_conserv = duree_ext_conserv;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Produit addProduit(Produit produit) {
		getProduits().add(produit);
		produit.setConservation(this);

		return produit;
	}

	public Produit removeProduit(Produit produit) {
		getProduits().remove(produit);
		produit.setConservation(null);

		return produit;
	}

}