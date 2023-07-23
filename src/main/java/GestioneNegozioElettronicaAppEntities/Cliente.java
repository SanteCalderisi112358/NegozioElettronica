package GestioneNegozioElettronicaAppEntities;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Cliente {
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String cognome;
	private String indirizzo;
	@OneToMany(mappedBy = "cliente")
	private List<Ordine> ordiniEffettuati;

	public Cliente(UUID id, String nome, String cognome, String indirizzo) {

		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;

	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", indirizzo=" + indirizzo
				+ ", ordiniEffettuati=" + ordiniEffettuati + "]";
	}

}
