package sample.roulettefrancese;

import javafx.application.Application;
import javafx.stage.Stage;
import miniroulette.controller.*;
import miniroulette.model.main.Model;
import miniroulette.model.main.RouletteGameModel;
import miniroulette.view.*;

public class RouletteApplication extends Application {

   @Override
    public void start(Stage stage) {
        Model model             = new RouletteGameModel();
        InstructionView view    = new InstructionView(stage);
        ViewObserver controller = new Controller(model);

        controller.setView(view);
        controller.getView().setController(controller);
        controller.getView().showSimulationRouletteWindow();
    }
    public static void main(String[] s){launch();}


}