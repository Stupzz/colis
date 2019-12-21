package fr.usmb.m2isc.javaee.comptes.ejb;

import fr.usmb.m2isc.javaee.comptes.jpa.Suivis;

public interface SuivisOperation {

	Suivis createTrack(Suivis suivis);

}
