package miniroulette.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import miniroulette.controller.ViewObserver;

public class RulePageView implements View{
    @FXML
    private Button buttonNext;
    private ViewObserver controller;

    @FXML
    void initialize() {
        buttonNext.setOnMouseClicked(mouseEvent -> {
            buttonNext.getScene().getWindow().hide();
            this.getController().getView().showBankrollAndLaunchesWindow();
        });


    }


    @Override
    public void setController(ViewObserver controller) {
        this.controller = controller;
    }

    @Override
    public ViewObserver getController() {
        return this.controller;
    }
}
