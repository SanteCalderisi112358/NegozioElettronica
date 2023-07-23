package GestioneNegozioElettronicaAppEntities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import GestioneNegozioElettronicaAppEnum.CategoriaProdotto;
import GestioneNegozioElettronicaAppEnum.TipoLaptot;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Laptop extends Prodotto {
	@Enumerated(EnumType.STRING)
	private TipoLaptot tipoLaptot;
	private double dimensioneSchermo;

	public Laptop(String nome, double prezzo, CategoriaProdotto categoria, int quantitaDisponibile, TipoLaptot tipo,
			double dimensioneSchermo) {
		super(nome, prezzo, categoria, quantitaDisponibile);
		this.tipoLaptot = tipo;
		this.dimensioneSchermo = dimensioneSchermo;
	}

	@Override
	public String toString() {
		return "Laptop [tipo=" + tipoLaptot + ", dimensioneSchermo=" + dimensioneSchermo + ", " + super.toString()
				+ "]";
	}



}
