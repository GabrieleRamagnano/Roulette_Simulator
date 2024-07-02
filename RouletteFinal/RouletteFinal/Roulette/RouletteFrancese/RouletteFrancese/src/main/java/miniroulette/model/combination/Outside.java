package miniroulette.model.combination;

public class Outside implements OutsideComb{
	
	/* dichiarazione dei campi della classe */
	final private static Integer MULTIPLIER = 1;   /* valore moltiplicativo della puntata */
	private Combination combination;	
	
	public Outside(Combination outsideComb) {
		this.combination = outsideComb;				
	}
	
	@Override
	/* metodo per modificare la puntata minima */
	public Integer increaseBet(int value) {
		// TODO Auto-generated method stub
		return value * MULTIPLIER;
	}

	@Override
	/* metodo chiamato in caso di uscita del numero zero */
	public int isZero(int value) {
		// TODO Auto-generated method stub
		    return value / 2;		
	}
	
	@Override
	/* metodo per restituire il tipo di combinazione scelta */
	public Combination getComb() {
		return this.combination;
	}
	
	public String toString() {
		return getComb().toString();
		
	}
}
