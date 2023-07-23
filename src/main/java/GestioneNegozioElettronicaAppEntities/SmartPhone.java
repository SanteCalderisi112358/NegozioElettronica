package GestioneNegozioElettronicaAppEntities;

import javax.persistence.Entity;

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
	private TagliaSmartPhone taglia;
	private long memoriaInterna;
	public SmartPhone(String nome, double prezzo, CategoriaProdotto categoria, TagliaSmartPhone taglia,
			long memoriaInterna) {
		super(nome, prezzo, categoria);
		this.taglia = taglia;
		this.memoriaInterna = memoriaInterna;
	}
	@Override
	public String toString() {
		return "SmartPhone [taglia=" + taglia + ", memoriaInterna=" + memoriaInterna + "," + super.toString() + "]";
	}

}
