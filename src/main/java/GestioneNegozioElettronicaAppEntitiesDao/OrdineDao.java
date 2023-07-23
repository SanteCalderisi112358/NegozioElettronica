package GestioneNegozioElettronicaAppEntitiesDao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import GestioneNegozioElettronicaAppEntities.Ordine;
import GestioneNegozioElettronicaAppEntities.Prodotto;

public class OrdineDao {
	private final EntityManager em;
	private static final Logger log = LoggerFactory.getLogger(ProdottoDao.class);

	public OrdineDao(EntityManager em) {
		this.em = em;
	}

	public void save(Ordine ordine) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			for (Prodotto prodotto : ordine.getProdottiOrdinati()) {
				em.persist(prodotto);
			}
			em.persist(ordine);
			transaction.commit();
			log.info(ordine + " è stato salvato correttamente.");
		} catch (Exception e) {
			log.error("Errore durante il salvataggio di " + ordine, e);
			transaction.rollback();
		}
	}




	public Ordine getById(UUID id) {
		try {
			return em.find(Ordine.class, id);
		} catch (Exception e) {
			log.error("Errore durante la ricerca dell' ordine con ID: " + id, e);
			throw e;
		}
	}

	public void delete(UUID id) {
		EntityTransaction transaction = em.getTransaction();
		try {
			Ordine ordine = em.find(Ordine.class, id);
			if (ordine != null) {
				transaction.begin();
				em.remove(ordine);
				transaction.commit();
				log.info(ordine + " è stato eliminato.");
			} else {
				log.info("L'ordine con ID " + id + " non è presente.");
			}
		} catch (Exception e) {
			log.error("Errore durante l'eliminazione dell'ordine con ID: " + id, e);
			transaction.rollback();
		}
	}

	public void refresh(UUID id) {
		try {
			Ordine utente = em.find(Ordine.class, id);
			log.info("PRE REFRESH: " + utente);
			em.refresh(utente);
			log.info("POST REFRESH: " + utente);
		} catch (Exception e) {
			log.error("Errore durante l'operazione di refresh per l'ordine con ID: " + id, e);
			throw e;
		}
	}
}
