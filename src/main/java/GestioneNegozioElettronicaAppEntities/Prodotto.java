package GestioneNegozioElettronicaAppEntities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import GestioneNegozioElettronicaAppEnum.CategoriaProdotto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Prodotto {
	@Id
	@GeneratedValue
	private UUID codiceProdotto;
	private String nome;
	private double prezzo;
	private int quantitaDisponibile;
	@Enumerated(EnumType.STRING)
	private CategoriaProdotto categoria;
	@ManyToOne
	private Ordine ordine;
	@OneToOne
	private Riparazione riparazione;

	public Prodotto(String nome, double prezzo, CategoriaProdotto categoria, int quantitaDisponibile) {

		this.nome = nome;
		this.prezzo = prezzo;
		this.categoria = categoria;
		this.quantitaDisponibile = quantitaDisponibile;
	}

	@Override
	public String toString() {
		return "Prodotto [codiceProdotto=" + codiceProdotto + ", nome=" + nome + ", prezzo=" + prezzo
				+ ", quantitaDisponibile=" + quantitaDisponibile + ", categoria=" + categoria + ", ordine=" + ordine
				+ ", riparazione=" + riparazione + "]";
	}

}
