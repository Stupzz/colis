package fr.usmb.m2isc.javaee.comptes.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@NamedQueries ({
	@NamedQuery(name="all", query="SELECT c FROM Colis c"),
})
@Entity
public class Colis implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private double poids;
	private String origine;
	private String destination;

	@OneToMany(
			targetEntity= Suivis.class,
			cascade=ALL,
			mappedBy="colis",
			orphanRemoval=true,
			fetch = FetchType.EAGER)
	private List<Suivis> suivis = new ArrayList();
	private boolean delivrer;

	
	public Colis() {
	}


	public Colis(int id, double poids) {
		super();
		this.id = id;
		this.poids = poids;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double weight) {
		this.poids = weight;
	}

	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String source) {
		this.origine = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public List<Suivis> getSuivis() {
		return suivis;
	}

	public void setSuivis(List<Suivis> suivis) {
		this.suivis = suivis;
	}

	public boolean isDelivrer() {
		return delivrer;
	}

	public void setDelivrer(boolean delivrer) {
		this.delivrer = delivrer;
	}

	@Override
	public String toString() {

		return "Votre colis à : " +
				" Pour N° : " + id + " | " +
				" Pour poids : " + poids + " | " +
				" Pour origine : " + origine + " | " +
				" Pour destination : " + destination + " | " +
				" Et comme état de livraison : " + delivrer;
	}
}
