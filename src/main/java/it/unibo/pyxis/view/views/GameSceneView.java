package it.unibo.pyxis.view.views;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.*;
public class GameSceneView extends AbstractJavaFXView {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private AnchorPane gamePane;

    @FXML
    private Canvas canvas;

    @FXML
    private Label livesText, currentLives, scoreText, currentScore, levelText, currentLevel;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(BLACK);
        System.out.println("color set to black");
        gc.fillRect(50, 50, 100, 100);
        System.out.println("draw rectangle");
    }
}
