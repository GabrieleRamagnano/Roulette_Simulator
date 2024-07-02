package miniroulette.view;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import miniroulette.controller.ViewObserver;


public class TitlePageView implements View {

    @FXML
    private ImageView buttonStart;
    private ViewObserver controller;

    @FXML
    void initialize() {

        buttonStart.setOnMouseClicked(mouseEvent -> {
            buttonStart.getScene().getWindow().hide();
            this.getController().setTable();
            this.getController().getView().showIntroductionWindow();
        });
    }

    public void setController(ViewObserver controller) {
        this.controller = controller;
    }

    @Override
    public ViewObserver getController() {
        return this.controller;
    }


}