package GestioneNegozioElettronicaAppEntities;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import GestioneNegozioElettronicaAppEnum.MetodoPagamento;
import GestioneNegozioElettronicaAppEnum.StatoRiparazione;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Riparazione {
	@Id
	@GeneratedValue
	private UUID id;
	private MetodoPagamento metodoPagamento;
	private LocalDate inizioPeriodoRiparazione;
	private LocalDate finePeriodoPagamento;
	private StatoRiparazione statoRiparazione;
	@OneToOne
	private Prodotto prodottoInRiparazione;

	public Riparazione(UUID id, MetodoPagamento metodoPagamento, LocalDate inizioPeriodoRiparazione,
			LocalDate finePeriodoPagamento, StatoRiparazione statoRiparazione, Prodotto prodottoInRiparazione) {

		this.id = id;
		this.metodoPagamento = metodoPagamento;
		this.inizioPeriodoRiparazione = inizioPeriodoRiparazione;
		this.finePeriodoPagamento = finePeriodoPagamento;
		this.statoRiparazione = statoRiparazione;
		this.prodottoInRiparazione = prodottoInRiparazione;
	}

	@Override
	public String toString() {
		return "Riparazione [id=" + id + ", metodoPagamento=" + metodoPagamento + ", inizioPeriodoRiparazione="
				+ inizioPeriodoRiparazione + ", finePeriodoPagamento=" + finePeriodoPagamento + ", statoRiparazione="
				+ statoRiparazione + ", prodottoInRiparazione=" + prodottoInRiparazione + "]";
	}

}
