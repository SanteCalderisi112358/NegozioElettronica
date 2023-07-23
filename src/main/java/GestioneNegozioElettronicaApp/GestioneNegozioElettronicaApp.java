package GestioneNegozioElettronicaApp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import GestioneNegozioElettronicaAppUtil.JpaUtil;

public class GestioneNegozioElettronicaApp {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();

		em.close();
		emf.close();

	}

}
