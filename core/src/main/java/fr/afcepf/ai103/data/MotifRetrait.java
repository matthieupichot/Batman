package fr.afcepf.ai103.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the motif_retrait database table.
 * 
 */
@Entity
@Table(name="motif_retrait")
@NamedQuery(name="MotifRetrait.findAll", query="SELECT m FROM MotifRetrait m")
public class MotifRetrait implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_motif_retrait;

	private String libelle_retrait;

	//bi-directional many-to-one association to Annonce
	@OneToMany(mappedBy="motifRetrait")
	private List<Annonce> annonces;

	public MotifRetrait() {
	}

	public int getId_motif_retrait() {
		return this.id_motif_retrait;
	}

	public void setId_motif_retrait(int id_motif_retrait) {
		this.id_motif_retrait = id_motif_retrait;
	}

	public String getLibelle_retrait() {
		return this.libelle_retrait;
	}

	public void setLibelle_retrait(String libelle_retrait) {
		this.libelle_retrait = libelle_retrait;
	}

	public List<Annonce> getAnnonces() {
		return this.annonces;
	}

	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}

	public Annonce addAnnonce(Annonce annonce) {
		getAnnonces().add(annonce);
		annonce.setMotifRetrait(this);

		return annonce;
	}

	public Annonce removeAnnonce(Annonce annonce) {
		getAnnonces().remove(annonce);
		annonce.setMotifRetrait(null);

		return annonce;
	}

}