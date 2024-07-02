package miniroulette.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import miniroulette.controller.ViewObserver;
import miniroulette.model.bankroll.Bankroll;

public class CheckBankrollView implements View{

    @FXML
    private Button buttonNext;

    @FXML
    private Button buttonTorna;

    @FXML
    private TextField fieldBankroll;


    @FXML
    private TextField fieldNumeroGiri;

    private ViewObserver controller;


    @FXML
    void initialize() {
        buttonTorna.setOnMouseClicked(mouseEvent -> {
            buttonTorna.getScene().getWindow().hide();
            this.getController().getView().showIntroductionWindow();
        });

        buttonNext.setOnMouseClicked(mouseEvent -> {

            try{
                var field = Double.parseDouble (fieldBankroll.getCharacters().toString());
                this.getController().setBankroll(field);

                var launches = Integer.parseInt(fieldNumeroGiri.getCharacters().toString());
                this.getController().setLauches(launches);
                buttonNext.getScene().getWindow().hide();
                this.getController().getView().showStrategyWindow();
            }catch(IllegalArgumentException ex){
                Alert alert = new Alert(Alert.AlertType.INFORMATION, ex.getMessage());
                alert.showAndWait();
            }

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
