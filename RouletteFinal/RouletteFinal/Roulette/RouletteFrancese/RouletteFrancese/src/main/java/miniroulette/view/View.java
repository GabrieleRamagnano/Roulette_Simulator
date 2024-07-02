package miniroulette.view;

import miniroulette.controller.ViewObserver;

public interface View {

    public void setController(ViewObserver controller);
    public ViewObserver getController();
}
