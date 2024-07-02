package miniroulette.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import miniroulette.controller.ViewObserver;
import miniroulette.model.combination.Combination;
import miniroulette.model.strategy.StrategyType;

public class BetView implements View{

    @FXML
    private Button buttonClose;

    @FXML
    private TextField fieldBankroll;

    @FXML
    private ChoiceBox<String> choiceBox;

    private ViewObserver controller;

    private String[] comb = {"Red", "Black", "Even", "Odd", "Upper", "Lower", "Random"};

    @FXML
    void initialize() {

        choiceBox.getItems().addAll(comb);
        choiceBox.setValue("Red");

        buttonClose.setOnMouseClicked(mouseEvent -> {

            try{
                var field = Integer.parseInt (fieldBankroll.getCharacters().toString());
                String myComb = choiceBox.getValue().toUpperCase();
                this.getController().createPlayer(this.controller.getStrategyType(), field, Combination.valueOf(myComb));
                buttonClose.getScene().getWindow().hide();
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