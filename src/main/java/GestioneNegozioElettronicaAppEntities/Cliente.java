package GestioneNegozioElettronicaAppEntities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import GestioneNegozioElettronicaAppEnum.MetodoPagamento;
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
	private String numeroTelefono;
	@Enumerated(EnumType.STRING)
	private MetodoPagamento metodoPagamentoPreferito;
	@OneToMany(mappedBy = "cliente")
	private List<Ordine> ordiniEffettuati = new ArrayList<Ordine>();

	public Cliente(String nome, String cognome, String indirizzo, MetodoPagamento metodoPagamentoPreferito,
			String numeroTelefono) {


		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.metodoPagamentoPreferito = metodoPagamentoPreferito;
		this.numeroTelefono = numeroTelefono;

	}


	@Override
	public String toString() {
		return "Cliente [Nome=" + nome + ", Cognome=" + cognome + ", indirizzo=" + indirizzo
				+ "]";
	}

}