package miniroulette.model.bet;

import java.util.LinkedList;

public class LabouchereBet extends GeneralBet {

    private LinkedList<Integer> listBetValues;
    private LinkedList<Integer> dummyList;
    public LabouchereBet(String betName, LinkedList<Integer> listBetValues) {
        super(betName, listBetValues.getFirst() + listBetValues.getLast());
        this.listBetValues = listBetValues;
        this.dummyList     = new LinkedList<>();
        this.setDummyList(this.listBetValues);
    }

    public LinkedList<Integer> getListBetValues() {return this.listBetValues;}

    public LinkedList<Integer> getDummyList() {return this.dummyList;}

    public void resetDummyList(){
        this.dummyList.clear();
        this.dummyList.addAll(this.listBetValues);
    }

    private void setDummyList(LinkedList<Integer> listBetValues){this.dummyList.addAll(listBetValues);}
}
