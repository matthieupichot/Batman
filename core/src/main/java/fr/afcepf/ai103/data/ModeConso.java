package fr.afcepf.ai103.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mode_conso database table.
 * 
 */
@Entity
@Table(name="mode_conso")
@NamedQuery(name="ModeConso.findAll", query="SELECT m FROM ModeConso m")
public class ModeConso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_mode;

	private String libelle_mode;

	//bi-directional many-to-one association to Consommation
	@OneToMany(mappedBy="modeConso")
	private List<Consommation> consommations;

	public ModeConso() {
	}

	public int getId_mode() {
		return this.id_mode;
	}

	public void setId_mode(int id_mode) {
		this.id_mode = id_mode;
	}

	public String getLibelle_mode() {
		return this.libelle_mode;
	}

	public void setLibelle_mode(String libelle_mode) {
		this.libelle_mode = libelle_mode;
	}

	public List<Consommation> getConsommations() {
		return this.consommations;
	}

	public void setConsommations(List<Consommation> consommations) {
		this.consommations = consommations;
	}

	public Consommation addConsommation(Consommation consommation) {
		getConsommations().add(consommation);
		consommation.setModeConso(this);

		return consommation;
	}

	public Consommation removeConsommation(Consommation consommation) {
		getConsommations().remove(consommation);
		consommation.setModeConso(null);

		return consommation;
	}

}