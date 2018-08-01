package fr.afcepf.ai103.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the motif_annulation database table.
 * 
 */
@Entity
@Table(name="motif_annulation")
@NamedQuery(name="MotifAnnulation.findAll", query="SELECT m FROM MotifAnnulation m")
public class MotifAnnulation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_motif_annul;

	private String libelle_annul;

	//bi-directional many-to-one association to Reponse
	@OneToMany(mappedBy="motifAnnulation")
	private List<Reponse> reponses;

	public MotifAnnulation() {
	}

	public int getId_motif_annul() {
		return this.id_motif_annul;
	}

	public void setId_motif_annul(int id_motif_annul) {
		this.id_motif_annul = id_motif_annul;
	}

	public String getLibelle_annul() {
		return this.libelle_annul;
	}

	public void setLibelle_annul(String libelle_annul) {
		this.libelle_annul = libelle_annul;
	}

	public List<Reponse> getReponses() {
		return this.reponses;
	}

	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	public Reponse addRepons(Reponse repons) {
		getReponses().add(repons);
		repons.setMotifAnnulation(this);

		return repons;
	}

	public Reponse removeRepons(Reponse repons) {
		getReponses().remove(repons);
		repons.setMotifAnnulation(null);

		return repons;
	}

}