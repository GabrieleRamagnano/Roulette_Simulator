package miniroulette.model.table;

import miniroulette.model.player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TableManager {
		
		private static final int NUMBERS = 37;
		private NumberFactory number;
		private HashMap<Integer, List<Player>> mappingOutside;
		private List<Number> numbersList;

		public TableManager() {
	        this.mappingOutside = new HashMap<>();
	        this.number         = new NumberFactory();
	        this.numbersList    = new ArrayList<>();
	        
		}
	
	    /* metodo per il mapping delle combinazioni esterne */
		public void buildOutside() {
			
			for(int comb = 0; comb < 6; comb++)
			   mappingOutside.put(comb, new ArrayList<>());	
		}
		
		/* metodo per la costruzione delle caselle del tabellone */
		public void buildNumbers() {
			for (int n = 1; n < NUMBERS; n++) 
			  numbersList.add(this.number.boxGenerator(n));
		}

        /* metodo per restituire il numero richiesto */
        public Number getNumber(int number) {
        	for (Number b: numbersList)
        		if (b.getNumber() == number) 
        			return b;
			return null;
         }
        
        /* metodo che restituisce tutte le combinazioni esterne */
        public HashMap<Integer, List<Player>> getMappingOutside(){
        	return this.mappingOutside;
        }
	    
}
