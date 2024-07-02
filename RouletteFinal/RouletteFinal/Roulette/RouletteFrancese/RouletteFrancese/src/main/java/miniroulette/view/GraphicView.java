package miniroulette.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import miniroulette.controller.ViewObserver;
import miniroulette.model.player.Player;
import miniroulette.model.player.StrategicPlayer;
import miniroulette.model.table.Number;

import java.util.ArrayList;
import java.util.List;


public class GraphicView implements View {

    @FXML
    private LineChart <Number,Number> graficoResult;

    @FXML
    private TableView<StrategicPlayer> tableResult;

    @FXML
    private TableColumn<StrategicPlayer, Integer> id;
    @FXML
    private TableColumn<StrategicPlayer, String> strategy;

    @FXML
    private TableColumn<StrategicPlayer, Integer> betInitial;

    @FXML
    private TableColumn<StrategicPlayer, Integer> bet;
    @FXML
    private TableColumn<StrategicPlayer, String> comb;
    @FXML
    private TableColumn<StrategicPlayer, Double> bankroll;
    @FXML
    private TableColumn<StrategicPlayer, Double> balance;
    @FXML
    private TableColumn<StrategicPlayer, Integer> launches;

    @FXML
    private Button button;

    @FXML
    private Button buttonClose;

    private int count = 0;

    private Stage stage;

    XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
    List<XYChart.Series> listSeries = new ArrayList<>();

    private ObservableList<StrategicPlayer> listObs = FXCollections.observableArrayList();

    private ViewObserver controller;

    @FXML
    public void populationGraphic() {
        buttonClose.setVisible(false);

        for (Player player : this.getController().getPlayerList()) {
            listObs.add(new StrategicPlayer(
                    player.getId(),
                    player.getStrategy().toString(),
                    player.getStrategy().getBet().getBetStartValue(),
                    player.getStrategy().getBet().getBetValue(),
                    player.getStrategy().getBet().getBetComb().getComb().toString(),
                    player.getBankroll().getBankrollValue(),
                    player.getBankroll().getBankrollValue() -
                            player.getBankroll().getStartBankroll(),
                    player.getBalance().size()));

        }

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        strategy.setCellValueFactory(new PropertyValueFactory<>("strategy"));
        betInitial.setCellValueFactory(new PropertyValueFactory<>("betInitial"));
        bet.setCellValueFactory(new PropertyValueFactory<>("bet"));
        comb.setCellValueFactory(new PropertyValueFactory<>("comb"));
        bankroll.setCellValueFactory(new PropertyValueFactory<>("bankroll"));
        balance.setCellValueFactory(new PropertyValueFactory<>("balance"));
        launches.setCellValueFactory(new PropertyValueFactory<>("launches"));

        tableResult.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableResult.setItems(listObs);


        graficoResult.lookup(".chart-plot-background").setStyle("-fx-background-color: transparent");
        button.setOnMouseClicked(mouseEvent -> {

            button.setVisible(false);
            buttonClose.setVisible(true);

            graficoResult.getData().clear();
            for (Player p : this.getController().getPlayerList()) {
                this.listSeries.add(new XYChart.Series());

            }

            this.count = 0;
            for (Player p : this.getController().getPlayerList()) {
                this.count++;
                var prova = count - 1;
                this.listSeries.get(prova).setName(p.getStrategy().toString() + p.getId());
                for (int i = 1; i <= p.getBalance().size(); i++) {

                    this.listSeries.get(prova).getData().add(new XYChart.Data(i, p.getBalance().get(i - 1).intValue()));
                }
            }

            for (XYChart.Series s : listSeries) {
                graficoResult.getData().add(s);
            }
        });

        buttonClose.setOnMouseClicked(mouseEvent -> {
           this.stage.close();
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

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}

