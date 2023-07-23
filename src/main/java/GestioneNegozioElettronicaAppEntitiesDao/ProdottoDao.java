package GestioneNegozioElettronicaAppEntitiesDao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import GestioneNegozioElettronicaAppEntities.Prodotto;

public class ProdottoDao {
	private final EntityManager em;
	private static final Logger log = LoggerFactory.getLogger(ProdottoDao.class);

	public ProdottoDao(EntityManager em) {
		this.em = em;
	}

	public void save(Prodotto prodotto) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(prodotto);
			transaction.commit();
			log.info(prodotto + " è stato salvato correttamente.");
		} catch (Exception e) {
			log.error("Errore durante il salvataggio di " + prodotto, e);
			transaction.rollback();
		}
	}

	public Prodotto getById(UUID id) {
		try {
			return em.find(Prodotto.class, id);
		} catch (Exception e) {
			log.error("Errore durante la ricerca del prodotto con ID: " + id, e);
			throw e;
		}
	}

	public void delete(UUID id) {
		EntityTransaction transaction = em.getTransaction();
		try {
			Prodotto utente = em.find(Prodotto.class, id);
			if (utente != null) {
				transaction.begin();
				em.remove(utente);
				transaction.commit();
				log.info(utente + " è stato eliminato.");
			} else {
				log.info("Il prodotto con ID " + id + " non è presente.");
			}
		} catch (Exception e) {
			log.error("Errore durante l'eliminazione del prodotto con ID: " + id, e);
			transaction.rollback();
		}
	}

	public void refresh(UUID id) {
		try {
			Prodotto utente = em.find(Prodotto.class, id);
			log.info("PRE REFRESH: " + utente);
			em.refresh(utente);
			log.info("POST REFRESH: " + utente);
		} catch (Exception e) {
			log.error("Errore durante l'operazione di refresh per il prodotto con ID: " + id, e);
			throw e;
		}
	}
}
