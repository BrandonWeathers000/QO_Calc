/**
 * TODO:
 * - Add multiple queues
 * - Fix rounding errors with special BigDecimal class
 */

import java.lang.Math;
import java.util.*;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class MainScreen extends Application {
    String currentInput = "";

    // The list of instances of the MathHandler
    int currentIndex = 0;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        MathHandler[] mathHandlerArray = new MathHandler[2];
        mathHandlerArray[0] = new MathHandler();
        mathHandlerArray[1] = new MathHandler();

        // Queue 0 label and its output
        Label queue0Label = new Label("Master queue");
        queue0Label.setFont(new Font("Terminess Nerd Font", 40));
        queue0Label.setTextFill(Color.WHITE);
        queue0Label.setUnderline(true);

        Label queue0Output = new Label("?");
        queue0Output.setFont(new Font("Terminess Nerd Font", 40));
        queue0Output.setTextFill(Color.WHITE);
        queue0Output.setText(returnQueuekAsString(mathHandlerArray[0].mainQueue));

        // Queue 1 label and its output
        Label queue1Label = new Label("Sub-queue one");
        queue1Label.setFont(new Font("Terminess Nerd Font", 40));
        queue1Label.setTextFill(Color.WHITE);
        queue1Label.setUnderline(true);

        Label queue1Output = new Label("?");
        queue1Output.setFont(new Font("Terminess Nerd Font", 40));
        queue1Output.setTextFill(Color.WHITE);
        queue1Output.setText(returnQueuekAsString(mathHandlerArray[1].mainQueue));

        GridPane mainGrid = new GridPane();
        mainGrid.setHgap(30.0);
        mainGrid.setVgap(30.0);
        mainGrid.add(queue0Label, 0, 0);
        mainGrid.add(queue1Label, 1, 0);
        mainGrid.add(queue0Output, 0, 1);
        mainGrid.add(queue1Output, 1, 1);

        // Seperator line between queues and input
        Line myLine = new Line();
        myLine.setStartX(0.0);
        myLine.setStartY(0.0);
        myLine.setEndX(1000.0);
        myLine.setEndY(0.0);
        myLine.setStyle("-fx-stroke: white;");

        Label input = new Label("\nInput:");
        input.setFont(new Font("Terminess Nerd Font", 40));
        input.setTextFill(Color.WHITE);

        VBox root = new VBox();
        root.setStyle("-fx-background-color: black;");
        root.getChildren().addAll(mainGrid, myLine, input);

        Scene scene = new Scene(root, 500, 500);

        scene.setOnKeyPressed(e -> {

                if((e.getCode() == KeyCode.EQUALS && e.isShiftDown()) || (e.getCode() == KeyCode.ADD)) mathHandlerArray[currentIndex].addQueue();
                if((e.getCode() == KeyCode.MINUS) || (e.getCode() == KeyCode.SUBTRACT)) mathHandlerArray[currentIndex].subQueue();
				if((e.getCode() == KeyCode.DIGIT8 && e.isShiftDown()) || (e.getCode() == KeyCode.MULTIPLY)) mathHandlerArray[currentIndex].mulQueue();
				if((e.getCode() == KeyCode.SLASH) || (e.getCode() == KeyCode.DIVIDE)) mathHandlerArray[currentIndex].divQueue();
				if(e.getCode() == KeyCode.DIGIT6 && e.isShiftDown() && e.isControlDown()) mathHandlerArray[currentIndex].expoQueueLeftToRight();
				else if(e.getCode() == KeyCode.DIGIT6 && e.isShiftDown()) mathHandlerArray[currentIndex].expoQueueTopToBottom();
				if(e.getCode() == KeyCode.Q) mathHandlerArray[currentIndex].sqrtQueue();
				if (e.getCode() == KeyCode.M  && e.isShiftDown()) mathHandlerArray[currentIndex].findMaxQueue();
				if ((e.getCode() == KeyCode.M)) mathHandlerArray[currentIndex].findMinQueue();

				if(e.getText().matches("\\.")) { // Decimals and number
                    if(currentInput.contains(".")) {
                    }else {
                        currentInput += e.getText();
                        input.setText("\nInput: " + currentInput);
                    }
                } else if(e.getText().matches("[0-9]")) {
                    currentInput += e.getText();
                    input.setText("\nInput: " + currentInput);
                }

                if(e.getCode() == KeyCode.BACK_SPACE) {
                    if(!currentInput.isEmpty()) {
                        currentInput = currentInput.substring(currentIndex, currentInput.length() - 1);
                        input.setText("\nInput: " + currentInput);
                    }
                }

                if(e.getCode() == KeyCode.ENTER) { // Press (Enter) the new input
                    mathHandlerArray[currentIndex].mainQueue.add(Double.valueOf(currentInput));
                    currentInput = "";
                    input.setText("\nInput: ");
                }

                if(e.getCode() == KeyCode.C) {
                    mathHandlerArray[currentIndex].mainQueue.clear();
                    // currentInput = "";
                    input.setText("\nInput: ");
                }

                queue0Output.setText(returnQueuekAsString(mathHandlerArray[0].mainQueue));
                queue1Output.setText(returnQueuekAsString(mathHandlerArray[1].mainQueue)); // For some reason, this copies over the MathHandler from the 0th index

                if(e.getCode() == KeyCode.H) {
                    currentIndex--;
                } else if(e.getCode() == KeyCode.L) {
                    currentIndex++;
                }
            });


        // Possibly helps
        stage.setScene(scene);
        stage.show();

        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }

    static String returnQueuekAsString(Queue<Double> inputQueue) {
        String returnString = "";

        for(Double currentElement : inputQueue) {
            returnString += "     " + currentElement + "\n";
        }

        returnString += "  >>>";

        return returnString;
    }
}
