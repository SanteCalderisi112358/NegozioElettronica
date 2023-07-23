package GestioneNegozioElettronicaApp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.github.javafaker.Faker;

import GestioneNegozioElettronicaAppEntities.Cliente;
import GestioneNegozioElettronicaAppEntities.Laptop;
import GestioneNegozioElettronicaAppEntities.Ordine;
import GestioneNegozioElettronicaAppEntities.Prodotto;
import GestioneNegozioElettronicaAppEntities.SmartPhone;
import GestioneNegozioElettronicaAppEntitiesDao.ClienteDao;
import GestioneNegozioElettronicaAppEntitiesDao.OrdineDao;
import GestioneNegozioElettronicaAppEntitiesDao.ProdottoDao;
import GestioneNegozioElettronicaAppEntitiesDao.RiparazioneDao;
import GestioneNegozioElettronicaAppEnum.CategoriaProdotto;
import GestioneNegozioElettronicaAppEnum.MetodoPagamento;
import GestioneNegozioElettronicaAppEnum.TagliaSmartPhone;
import GestioneNegozioElettronicaAppEnum.TipoLaptot;
import GestioneNegozioElettronicaAppUtil.JpaUtil;

public class GestioneNegozioElettronicaApp {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		Faker f = new Faker(Locale.ITALIAN);
		/* INIZIALIZZAZIONE DAO */
		ClienteDao clienteDao = new ClienteDao(em);
		ProdottoDao prodottoDao = new ProdottoDao(em);
		OrdineDao ordineDao = new OrdineDao(em);
		RiparazioneDao riparazioneDao = new RiparazioneDao(em);

		/* INIZIALIZZAZIONE 3 SMARTPHONE, 3 LAPTOT E 4 PRODOTTI SALVATAGGIO */
		SmartPhone smartPhone01 = new SmartPhone("Honor 90", 549.90, CategoriaProdotto.TELEFONIA,
				5, TagliaSmartPhone.MEDIO, 512);
		SmartPhone smartPhone02 = new SmartPhone("Galaxy Note20 5G", 329.00, CategoriaProdotto.TELEFONIA,
				7, TagliaSmartPhone.GRANDE, 256);
		SmartPhone smartPhone03 = new SmartPhone("XIAOMI REDMI 12C DUAL SIM", 101.00, CategoriaProdotto.TELEFONIA,
				3, TagliaSmartPhone.MEDIO, 128);
		Laptop laptot01 = new Laptop("HP 15S-FQ5022NL", 599.00, CategoriaProdotto.INFORMATICA, 4, TipoLaptot.ULTRABOOK,
				15.6);
		Laptop laptot02 = new Laptop("LENOVO V15 82KB00N4IX", 369.00, CategoriaProdotto.INFORMATICA, 4,
				TipoLaptot.CONVERTIBLE, 15.6);
		Laptop laptot03 = new Laptop("HP 250 G9 N4500", 299.99, CategoriaProdotto.INFORMATICA, 5, TipoLaptot.GAMING,
				15.6);
		Prodotto prodotto01 = new Prodotto("DYSON Gen5 Detect scopa elettrica senza filo, Senza sacco, 752 W", 949.01,
				CategoriaProdotto.ELETTRODOMESTICI, 3);
		Prodotto prodotto02 = new Prodotto("LG F2WV5S8S0E.ABWQPIS LAVATRICE SLIM", 474.99,
				CategoriaProdotto.ELETTRODOMESTICI, 5);
		Prodotto prodotto03 = new Prodotto("AEG SCB818E8TS FRIGORIFERO INCASSO ", 781.14,
				CategoriaProdotto.ELETTRODOMESTICI, 7);
		Prodotto prodotto04 = new Prodotto("WHIRLPOOL ART 66102 FRIGORIFERO INCASSO", 480.59,
				CategoriaProdotto.ELETTRODOMESTICI, 8);
		Prodotto prodotto05 = new Prodotto("ELECTROLUX ERS3DF18S, FRIGORIFERO INCASSO", 608.59,
				CategoriaProdotto.ELETTRODOMESTICI, 12);
		Prodotto prodotto06 = new Prodotto("DJI ACCESSORIO DRONE DJI FOCUS", 937.74, CategoriaProdotto.ACCESSORI, 5);
		Prodotto prodotto07 = new Prodotto("GOPRO ACCESSORI GOPRO DISPLAY MOD", 44.54,
				CategoriaProdotto.ELETTRODOMESTICI, 7);
		Prodotto prodotto08 = new Prodotto("GOPRO ACCESSORI ACTION CAMERA GOPRO DUAL HERO", 103.94,
				CategoriaProdotto.ELETTRODOMESTICI, 9);
		Prodotto prodotto09 = new Prodotto("GOPRO ACTION CAMERA GOPRO HERO8 BLACK", 188.99,
				CategoriaProdotto.ELETTRODOMESTICI, 4);
		Prodotto prodotto10 = new Prodotto("NILOX ACTION CAMERA NILOX DUAL S ", 103.99,
				CategoriaProdotto.ELETTRODOMESTICI, 6);


		List<Prodotto> prodottiDaSalvareNelDB = new ArrayList<Prodotto>();
		prodottiDaSalvareNelDB.add(prodotto01);
		prodottiDaSalvareNelDB.add(prodotto02);
		prodottiDaSalvareNelDB.add(prodotto03);
		prodottiDaSalvareNelDB.add(prodotto04);
		prodottiDaSalvareNelDB.add(prodotto05);
		prodottiDaSalvareNelDB.add(prodotto06);
		prodottiDaSalvareNelDB.add(prodotto07);
		prodottiDaSalvareNelDB.add(prodotto08);
		prodottiDaSalvareNelDB.add(prodotto09);
		prodottiDaSalvareNelDB.add(prodotto10);
		prodottiDaSalvareNelDB.add(smartPhone01);
		prodottiDaSalvareNelDB.add(smartPhone02);
		prodottiDaSalvareNelDB.add(smartPhone03);
		prodottiDaSalvareNelDB.add(laptot01);
		prodottiDaSalvareNelDB.add(laptot02);
		prodottiDaSalvareNelDB.add(laptot03);

		// prodottiDaSalvareNelDB.forEach(prodotto -> prodottoDao.save(prodotto));

		/* CREAZIONE CLIENTI E SALVATAGGIO */
		Cliente cliente01 = new Cliente("Sante", "Calderisi", "Via Sandro Pertini, 26 - Vieste(FG)",
				MetodoPagamento.CARTA_DI_CREDITO, "34672837");
		clienteDao.save(cliente01);

		// System.out.println(clienteDao.getById(UUID.fromString("0480c9ff-01c7-4ebe-ae03-d6c70c6e3b14")));
//		List<Cliente> listaClienti = new ArrayList<Cliente>();
//
//		Supplier<Cliente> clienteSupplier = () -> {
//			Random random = new Random();
//			MetodoPagamento[] metodiPagamento = MetodoPagamento.values();
//			MetodoPagamento metodoPagamentoCasuale = metodiPagamento[random.nextInt(metodiPagamento.length)];
//
//			return new Cliente(f.name().firstName(), f.name().lastName(), f.address().fullAddress(),
//					metodoPagamentoCasuale);
//		};
//
//		for (int i = 0; i < 10; i++) {
//			listaClienti.add(clienteSupplier.get());
//		}
//
//		listaClienti.forEach(cliente -> clienteDao.save(cliente));
		/* ORDINI EFFETTUATI E SALVATAGGIO */
		List<Prodotto> prodottiOrdinati = new ArrayList<>();
		prodottiOrdinati.add(prodotto01);
		prodottiOrdinati.add(prodotto04);
		prodottiOrdinati.add(smartPhone02);

		// Passa la lista dei prodotti ordinati corretta nel costruttore dell'ordine
		Ordine ordine01 = new Ordine(MetodoPagamento.CARTA_DI_CREDITO, LocalDate.now(), prodottiOrdinati, cliente01);
		// ordineDao.save(ordine01);
		em.close();
		emf.close();

	}

}
