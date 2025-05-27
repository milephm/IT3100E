package main.java.hust.soict.ict.javafx;

import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    @FXML
    private RadioButton eraser;

    @FXML
    private RadioButton pen;

    @FXML
    private ToggleGroup Tools;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if (!pen.isSelected() && !eraser.isSelected()) {
            return;
        }

        Color color;
        if (pen.isSelected()) {
            color = Color.BLACK;
        } else if (eraser.isSelected()) {
            color = Color.WHITE;
        } else {
            return;
        }

        Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }
}
