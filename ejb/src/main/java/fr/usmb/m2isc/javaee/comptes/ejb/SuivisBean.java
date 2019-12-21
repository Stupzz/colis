package fr.usmb.m2isc.javaee.comptes.ejb;

import fr.usmb.m2isc.javaee.comptes.jpa.Suivis;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Remote
public class SuivisBean implements SuivisOperation {

	@PersistenceContext
	private EntityManager em;

	public SuivisBean() {
	}
	
	@Override
	public Suivis createTrack(Suivis suivis) {
		em.persist(suivis);
		return suivis;
	}
	


}
