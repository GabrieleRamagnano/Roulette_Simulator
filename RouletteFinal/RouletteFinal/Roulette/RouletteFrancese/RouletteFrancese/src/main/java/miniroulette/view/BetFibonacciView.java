package miniroulette.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import miniroulette.controller.ViewObserver;
import miniroulette.model.combination.Combination;
import miniroulette.model.strategy.StrategyType;

public class BetFibonacciView implements View{

    @FXML
    private Button buttonClose;

    @FXML
    private ChoiceBox<String>  fieldBankroll;

    @FXML
    private TextField fieldBankrollLib;
    @FXML
    private ChoiceBox<String> choiceBox;


    private ViewObserver controller;

    private String[] comb = {"Red", "Black", "Even", "Odd", "Upper", "Lower", "Random"};
    private String[] comb2 = {"1", "2", "3", "5", "8", "13", "21"};

    private  int field;

    private Integer field2;

    @FXML
    void initialize() {

        choiceBox.getItems().addAll(comb);
        choiceBox.setValue("Red");

        fieldBankroll.getItems().addAll(comb2);
        fieldBankroll.setValue("1");

        buttonClose.setOnMouseClicked(mouseEvent -> {

            field = Integer.parseInt (fieldBankroll.getValue());
            try {
                field2 = Integer.parseInt(fieldBankrollLib.getCharacters().toString());
                String myComb = choiceBox.getValue().toUpperCase();
                this.getController().createPlayer(this.getController().getStrategyType(), field2, Combination.valueOf(myComb));
                buttonClose.getScene().getWindow().hide();
                this.getController().getView().showStrategyWindow();
            }catch(NumberFormatException ex){
                String myComb = choiceBox.getValue().toUpperCase();
                this.controller.createPlayer(this.getController().getStrategyType(), field, Combination.valueOf(myComb));
                buttonClose.getScene().getWindow().hide();
                this.getController().getView().showStrategyWindow();
            }catch (IllegalArgumentException ex) {
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

