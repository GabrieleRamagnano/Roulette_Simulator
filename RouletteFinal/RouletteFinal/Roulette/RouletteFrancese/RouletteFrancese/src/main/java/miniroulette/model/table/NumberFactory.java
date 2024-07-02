package miniroulette.model.table;

import miniroulette.model.combination.Combination;

public class NumberFactory {
	
	/* dichiarazione dei campi della classe */
    private   int firstNumber;
	private   int red;
	private   int black;
	private Combination[] color;
	private Combination evenOdd;
	private Combination upperLower;
	
	/* costruttore della classe */
	public NumberFactory(){
		
		this.color = new Combination[] {Combination.RED, 
									    Combination.BLACK};
	}
	
	/* metodo per la generazione e "ricerca" di "caselle" */
	public Number boxGenerator(int extraction) {
	   setBox(); 
	   while (isNumber(extraction)) {
		    changeColor(this.firstNumber);
		    nextNumber();
		}
		
	    return isBox(this.firstNumber);
	}
	
	/* metodo per riavviare il calcolo della casella */
	private void setBox() {
		this.firstNumber = 1;
		this.red         = Combination.RED.ordinal();
		this.black       = Combination.BLACK.ordinal();
	}
	
	/* metodo per controllare se il numero è stato raggiunto */
	private boolean isNumber(int extraction) {
		return this.firstNumber < extraction;
	}
	
	/* metodo per avanzare al numero successivo */
	private void nextNumber() {
		this.firstNumber++;
	}
	
	/* metodo per creare la "casella" richiesta */
	private Number isBox(int number) {
		
		this.evenOdd 	  = isEven(this.firstNumber);
	    this.upperLower   = isUpper(this.firstNumber);
		return new Number(number,
				            color[this.red],
		   		 		    evenOdd,
		   		 		    upperLower);
	}
	
	
	/* metodo per verificare se un numero è pari */
	private Combination isEven(int number) {
		if (number % 2 == 0)
			return evenOdd = Combination.EVEN;
		else 
			return evenOdd = Combination.ODD;
	}
	
	/* metodo per verificare se un numero è alto o basso */
	private Combination isUpper(int number) {
		if (number <= 18)
			return upperLower = Combination.UPPER;
		else 
			return upperLower = Combination.LOWER;
	}

	
	/* metodo per cambiare colore */
	private void changeColor(int number) {
		  if ( number != 10 && number != 18 && number != 28) {
			  
			  int tmp      = this.red;
			  this.red     = this.black;
			  this.black   = tmp;  
		  }	
	}
			
}
	


