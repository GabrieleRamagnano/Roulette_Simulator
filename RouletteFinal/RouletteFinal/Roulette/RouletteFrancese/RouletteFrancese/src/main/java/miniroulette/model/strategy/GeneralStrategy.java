package miniroulette.model.strategy;

import miniroulette.model.bet.BetOutside;
import miniroulette.model.combination.Combination;

public abstract class GeneralStrategy implements Strategy{


    /* method to set bet's value when player won or lost */
    @Override
    public void isWin(boolean win) {
        if(win)
            iWon();
        else
            iLost();
    }

    /* method to set bet's value when player won */
    protected abstract void iWon();

    /* method to set bet's value when player lost */
    protected abstract void iLost();

    public abstract Integer ifWon();

    @Override
    public abstract  Integer ifLost();

    /* method to select bet */
    public abstract BetOutside getBet();

    /* method to select a bet's type*/
    @Override
    public abstract void chooseBet(Combination combination);
}
