package GestioneNegozioElettronicaAppEntitiesDao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import GestioneNegozioElettronicaAppEntities.Riparazione;

public class RiparazioneDao {
	private final EntityManager em;
	private static final Logger log = LoggerFactory.getLogger(ProdottoDao.class);

	public RiparazioneDao(EntityManager em) {
		this.em = em;
	}

	public void save(Riparazione riparazione) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(riparazione);
			transaction.commit();
			log.info(riparazione + " è stato salvato correttamente.");
		} catch (Exception e) {
			log.error("Errore durante il salvataggio di " + riparazione, e);
			transaction.rollback();
		}
	}

	public Riparazione getById(UUID id) {
		try {
			return em.find(Riparazione.class, id);
		} catch (Exception e) {
			log.error("Errore durante la ricerca della riparazione con ID: " + id, e);
			throw e;
		}
	}

	public void delete(UUID id) {
		EntityTransaction transaction = em.getTransaction();
		try {
			Riparazione riparazione = em.find(Riparazione.class, id);
			if (riparazione != null) {
				transaction.begin();
				em.remove(riparazione);
				transaction.commit();
				log.info(riparazione + " è stato eliminato.");
			} else {
				log.info("La riparazione con ID " + id + " non è presente.");
			}
		} catch (Exception e) {
			log.error("Errore durante l'eliminazione della riparazione con ID: " + id, e);
			transaction.rollback();
		}
	}

	public void refresh(UUID id) {
		try {
			Riparazione utente = em.find(Riparazione.class, id);
			log.info("PRE REFRESH: " + utente);
			em.refresh(utente);
			log.info("POST REFRESH: " + utente);
		} catch (Exception e) {
			log.error("Errore durante l'operazione di refresh per la riparazione con ID: " + id, e);
			throw e;
		}
	}
}
