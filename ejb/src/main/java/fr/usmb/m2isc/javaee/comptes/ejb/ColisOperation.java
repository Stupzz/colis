package fr.usmb.m2isc.javaee.comptes.ejb;

import fr.usmb.m2isc.javaee.comptes.jpa.Colis;

import java.util.List;

public interface ColisOperation {

	Colis createColis(Colis colis);

	Colis getColis(int number);

	List<Colis> getAllColis();

	void updateColis(Colis colis);

	void delivrer(Colis colis);


}
