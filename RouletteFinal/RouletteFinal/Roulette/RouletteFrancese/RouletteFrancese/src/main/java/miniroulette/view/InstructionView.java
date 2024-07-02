package miniroulette.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import miniroulette.controller.ViewObserver;
import sample.roulettefrancese.*;
import java.io.IOException;
import sample.roulettefrancese.RouletteApplication;

public class InstructionView implements View {

    private ViewObserver controller;
    private Stage stage;
    private AnchorPane rootLayout;

    public InstructionView(Stage stage){
        this.stage = stage;
        this.stage.setTitle("RouletteSimulation!");
    }
    public void showSimulationRouletteWindow() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(RouletteApplication.class.getResource("hello-view.fxml"));
            rootLayout = loader.load();
            View titlePage = loader.getController();
            titlePage.setController(this.getController());
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void showIntroductionWindow() {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(RouletteApplication.class.getResource("next-controller.fxml"));
            rootLayout = loader.load();
            View rulePage =  loader.getController();
            rulePage.setController(this.getController());
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showBankrollAndLaunchesWindow() {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(RouletteApplication.class.getResource("check-bankroll-controller.fxml"));
            rootLayout = loader.load();
            View checkBankroll = loader.getController();
            checkBankroll.setController(this.getController());
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showStrategyWindow() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(RouletteApplication.class.getResource("check-strategy-controller.fxml"));
            rootLayout = loader.load();
            View checkStrategy = loader.getController();
            checkStrategy.setController(this.getController());
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void showBetWindow() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(RouletteApplication.class.getResource("puntata-controller.fxml"));
            rootLayout = loader.load();
            View bet = loader.getController();
            bet.setController(this.getController());
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showBetWindowFib() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(RouletteApplication.class.getResource("puntata_fib.fxml"));
            rootLayout = loader.load();
            View betFib = loader.getController();
            betFib.setController(this.getController());
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showBetWindowLab() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(RouletteApplication.class.getResource("puntata_lab.fxml"));
            rootLayout = loader.load();
            View betController = loader.getController();
            betController.setController(this.getController());
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void showGraphic() {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(RouletteApplication.class.getResource("grafico.fxml"));
            rootLayout = loader.load();
            GraphicView graphic = loader.getController();
            graphic.setController(this.getController());
            graphic.populationGraphic();
            graphic.setStage(this.stage);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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
