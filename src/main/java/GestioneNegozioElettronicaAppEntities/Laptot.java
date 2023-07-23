package GestioneNegozioElettronicaAppEntities;

import javax.persistence.Entity;

import GestioneNegozioElettronicaAppEnum.TipoLaptot;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Laptot extends Prodotto {
	private TipoLaptot tipo;
	private int dimensioneSchermo;
}
