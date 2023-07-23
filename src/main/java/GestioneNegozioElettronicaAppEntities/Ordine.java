package GestioneNegozioElettronicaAppEntities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import GestioneNegozioElettronicaAppEnum.MetodoPagamento;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Ordine {
	@Id
	@GeneratedValue
	private UUID id;
	@Enumerated(EnumType.STRING)
	private MetodoPagamento metodoPagamento;
	private LocalDate dataAcquisto;
	@OneToMany(mappedBy = "ordine")
	private List<Prodotto> prodottiOrdinati = new ArrayList<Prodotto>();
	@ManyToOne
	private Cliente cliente;

	public Ordine(UUID id, MetodoPagamento metodoPagamento, LocalDate dataAcquisto, List<Prodotto> prodottiOrdinati,
			Cliente cliente) {
		super();
		this.id = id;
		this.metodoPagamento = metodoPagamento;
		this.dataAcquisto = dataAcquisto;
		this.prodottiOrdinati = prodottiOrdinati;
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Ordine [id=" + id + ", metodoPagamento=" + metodoPagamento + ", dataAcquisto=" + dataAcquisto
				+ ", prodottiOrdinati=" + prodottiOrdinati + ", cliente=" + cliente + "]";
	}

}
