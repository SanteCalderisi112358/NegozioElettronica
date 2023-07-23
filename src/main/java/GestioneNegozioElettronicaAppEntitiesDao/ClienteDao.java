package GestioneNegozioElettronicaAppEntitiesDao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import GestioneNegozioElettronicaAppEntities.Cliente;

public class ClienteDao {
	private final EntityManager em;
	private static final Logger log = LoggerFactory.getLogger(ProdottoDao.class);

	public ClienteDao(EntityManager em) {
		this.em = em;
	}

	public void save(Cliente cliente) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(cliente);
			transaction.commit();
			log.info(cliente + " è stato salvato correttamente.");
		} catch (Exception e) {
			log.error("Errore durante il salvataggio di " + cliente, e);
			transaction.rollback();
		}
	}

	public Cliente getById(UUID id) {
		try {
			return em.find(Cliente.class, id);
		} catch (Exception e) {
			log.error("Errore durante la ricerca del cliente con ID: " + id, e);
			throw e;
		}
	}

	public void delete(UUID id) {
		EntityTransaction transaction = em.getTransaction();
		try {
			Cliente utente = em.find(Cliente.class, id);
			if (utente != null) {
				transaction.begin();
				em.remove(utente);
				transaction.commit();
				log.info(utente + " è stato eliminato.");
			} else {
				log.info("Il cliente con ID " + id + " non è presente.");
			}
		} catch (Exception e) {
			log.error("Errore durante l'eliminazione del prodotto con ID: " + id, e);
			transaction.rollback();
		}
	}

	public void refresh(UUID id) {
		try {
			Cliente utente = em.find(Cliente.class, id);
			log.info("PRE REFRESH: " + utente);
			em.refresh(utente);
			log.info("POST REFRESH: " + utente);
		} catch (Exception e) {
			log.error("Errore durante l'operazione di refresh per il cliente con ID: " + id, e);
			throw e;
		}
	}
}
