package GestioneNegozioElettronicaAppEntities;

import java.util.UUID;

import javax.persistence.Entity;
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
public abstract class Prodotto {
	@Id
	@GeneratedValue
	private UUID codiceProdotto;
	private String nome;
	private double prezzo;
	private int quantitaDisponibile;
	private CategoriaProdotto categoria;
	@ManyToOne
	private Ordine ordine;
	@OneToOne
	private Riparazione riparazione;

	public Prodotto(String nome, double prezzo, CategoriaProdotto categoria) {

		this.nome = nome;
		this.prezzo = prezzo;
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Prodotto [codiceProdotto=" + codiceProdotto + ", nome=" + nome + ", prezzo=" + prezzo
				+ ", quantitaDisponibile=" + quantitaDisponibile + ", categoria=" + categoria + ", ordine=" + ordine
				+ ", riparazione=" + riparazione + "]";
	}

}
