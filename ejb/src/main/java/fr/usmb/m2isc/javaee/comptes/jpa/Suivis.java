package fr.usmb.m2isc.javaee.comptes.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Suivis implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private String localisation;
	private Status status;

	@ManyToOne
	@JoinColumn(nullable=false)
	private Colis colis;

	public Suivis() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String location) {
		this.localisation = location;
	}


	public void setColis(Colis colis) {
		this.colis = colis;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Suivis{" +
				"id=" + id +
				", date=" + date +
				", location='" + localisation + '\'' +
				", status=" + status +
				'}';
	}
}
