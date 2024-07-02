package miniroulette.view;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import miniroulette.controller.ViewObserver;
import miniroulette.model.strategy.StrategyType;

import java.util.Optional;

public class CheckStrategyView implements View {

    @FXML
    private Group labouchere;

    @FXML
    private Group alembert;

    @FXML
    private Group antiMartingale;

    @FXML
    private Button buttonStart;

    @FXML
    private Button buttonTorna;

    @FXML
    private Group contrAlembert;

    @FXML
    private Group contrLabouchere;

    @FXML
    private Group fibonacci;

    @FXML
    private Group fisher;

    @FXML
    private Group martingale;

    @FXML
    private Group paroli;

    private ViewObserver controller;



    @FXML
    void initialize() {
        buttonTorna.setOnMouseClicked(mouseEvent -> {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Tutte le strategie verranno eliminate");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                // ... user chose OK
                this.getController().deleteStrategy();
                buttonTorna.getScene().getWindow().hide();
                this.getController().getView().showBankrollAndLaunchesWindow();
            }

        });

        buttonStart.setOnMouseClicked(mouseEvent -> {
            buttonStart.getScene().getWindow().hide();
            this.getController().simulation();
            this.getController().getView().showGraphic();

        });

        martingale.setOnMouseClicked(mouseEvent -> {
            martingale.getScene().getWindow().hide();
            this.getController().setStrategyType(StrategyType.MARTINGALE);
            this.getController().getView().showBetWindow();

        });

        labouchere.setOnMouseClicked(mouseEvent -> {
            labouchere.getScene().getWindow().hide();
            this.getController().setStrategyType(StrategyType.LABOUCHERE);
            this.getController().getView().showBetWindowLab();

        });

        alembert.setOnMouseClicked(mouseEvent -> {
            alembert.getScene().getWindow().hide();
            this.getController().setStrategyType(StrategyType.ALEMBERT);
            this.getController().getView().showBetWindow();

        });

        antiMartingale.setOnMouseClicked(mouseEvent -> {
            antiMartingale.getScene().getWindow().hide();
            this.getController().setStrategyType(StrategyType.ANTIMARTINGALE);
            this.getController().getView().showBetWindow();

        });

        contrAlembert.setOnMouseClicked(mouseEvent -> {
            contrAlembert.getScene().getWindow().hide();
            this.getController().setStrategyType(StrategyType.CONTRALEMBERT);
            this.getController().getView().showBetWindow();

        });

        contrLabouchere.setOnMouseClicked(mouseEvent -> {
            contrLabouchere.getScene().getWindow().hide();
            this.getController().setStrategyType(StrategyType.CONTRLABOUCHERE);
            this.getController().getView().showBetWindowLab();

        });

        fibonacci.setOnMouseClicked(mouseEvent -> {
            fibonacci.getScene().getWindow().hide();
            this.getController().setStrategyType(StrategyType.FIBONACCI);
            this.getController().getView().showBetWindowFib();

        });

        fisher.setOnMouseClicked(mouseEvent -> {
            fisher.getScene().getWindow().hide();
            this.getController().setStrategyType(StrategyType.FISHER);
            this.getController().getView().showBetWindow();

        });

        paroli.setOnMouseClicked(mouseEvent -> {
            paroli.getScene().getWindow().hide();
            this.getController().setStrategyType(StrategyType.PAROLI);
            this.getController().getView().showBetWindow();

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
