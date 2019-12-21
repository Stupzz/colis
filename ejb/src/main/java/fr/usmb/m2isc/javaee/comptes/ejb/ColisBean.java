package fr.usmb.m2isc.javaee.comptes.ejb;

import fr.usmb.m2isc.javaee.comptes.jpa.Colis;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Remote
public class ColisBean implements ColisOperation {

	@PersistenceContext
	private EntityManager em;
	
	public ColisBean() {
	}
	
	@Override
	public Colis createColis(Colis colis) {
		em.persist(colis);
		return colis;
	}
	
	@Override
	public Colis getColis(int id) {
		return em.find(Colis.class, id);
	}

	@Override
	public List<Colis> getAllColis() {
		Query req = em.createNamedQuery("all");
		return req.getResultList();
	}

	@Override
	public void updateColis(Colis colis){
		em.merge(colis);
	}

	@Override
	public void delivrer(Colis colis){
		colis.setDelivrer(true);
		em.merge(colis);

	}


}
