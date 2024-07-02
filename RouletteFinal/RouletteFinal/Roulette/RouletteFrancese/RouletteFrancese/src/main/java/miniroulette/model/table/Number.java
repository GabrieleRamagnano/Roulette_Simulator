package miniroulette.model.table;

import miniroulette.model.combination.Combination;

public class Number {
	
	/* campi della classe */
	private final int number;
	private final Combination color;
	private final Combination evenOdd;
	private final Combination upperLower;
		
	/* definiamo il costruttore */
	public Number(int number,
				  Combination color,
				  Combination evenOdd,
				  Combination upperLower) {
		
		this.number 	= number;
		this.color  	= color;
		this.evenOdd 	= evenOdd;
		this.upperLower = upperLower;
		
	}

	/* metodo che restituisce il valore numerico del numero estratto */
	public int getNumber() {
		return number;
	}
	
	/* metodo che restituisce il colore del numero estratto */
	public int getColor() {
		return color.ordinal();
	}
	
	/* metodo che restituisce la partità/disparità del numero estratto */
	public int getEvenOdd() {
		return evenOdd.ordinal();
	}
	
	/* metodo che restituisce la parte alta/bassa del numero estratto */
	public int getUpperLower() {
		return upperLower.ordinal();
	}

}
