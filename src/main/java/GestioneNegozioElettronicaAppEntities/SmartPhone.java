package GestioneNegozioElettronicaAppEntities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import GestioneNegozioElettronicaAppEnum.CategoriaProdotto;
import GestioneNegozioElettronicaAppEnum.TagliaSmartPhone;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class SmartPhone extends Prodotto {
	@Enumerated(EnumType.STRING)
	private TagliaSmartPhone tagliaSmartphone;
	private long memoriaInterna;

	public SmartPhone(String nome, double prezzo, CategoriaProdotto categoria, int quantitaDisponibile,
			TagliaSmartPhone taglia, long memoriaInterna) {
		super(nome, prezzo, categoria, quantitaDisponibile);
		this.tagliaSmartphone = taglia;
		this.memoriaInterna = memoriaInterna;
	}
	@Override
	public String toString() {
		return "SmartPhone [taglia=" + tagliaSmartphone + ", memoriaInterna=" + memoriaInterna + "," + super.toString()
				+ "]";
	}


}
