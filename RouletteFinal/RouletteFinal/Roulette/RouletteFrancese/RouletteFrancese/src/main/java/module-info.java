module sample.roulettefrancese {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    

    opens sample.roulettefrancese to javafx.fxml;
    exports sample.roulettefrancese;
    exports miniroulette.controller;
    opens miniroulette.controller to javafx.fxml;
    exports miniroulette.view;
    opens miniroulette.view to javafx.fxml;
    exports miniroulette.model.player;
    opens miniroulette.model.player to javafx.fxml;
}