/**
 * 
 */

import java.util.ArrayDeque; // add(), poll(), & peek() methods
import java.util.PriorityQueue;
import java.util.Queue;
import javafx.application.Application;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Stage;
import java.lang.Math;
import java.math.BigDecimal;

public class MainScreen extends Application {
    static double epsilon = 0.000000000000001;

    static Queue<Double> mainQueue = new ArrayDeque<>();
    String currentInput = "";

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Label title = new Label("Queue:");
        title.setFont(new Font("Terminess Nerd Font", 50));
        title.setTextFill(Color.WHITE);

        Label output = new Label("?");
        output.setFont(new Font("Terminess Nerd Font", 40));
        output.setTextFill(Color.WHITE);
        output.setText(returnQueuekAsString(mainQueue));

        Label input = new Label("Input:");
        input.setFont(new Font("Terminess Nerd Font", 40));
        input.setTextFill(Color.WHITE);
        // output.setText();

        VBox root = new VBox(10);
        root.setStyle("-fx-background-color: black;");
        root.getChildren().addAll(title, output, input);

        // StackPane root = new StackPane(output);
        Scene scene = new Scene(root, 500, 500);

        scene.setOnKeyPressed(e -> {
                if(e.getCode() == KeyCode.C) {
                    // System.out.println("The 'c' key has been pressed"); // Clearing the screen
                    mainQueue.clear();
                } else if(e.getCode() == KeyCode.EQUALS && e.isShiftDown()) { // Basic operations
                    // System.out.println("The plus key has been pressed");
                    addQueue();
                } else if(e.getCode() == KeyCode.MINUS) {
                    // System.out.println("The minus key has been pressed");
                    subQueue();
                } else if(e.getCode() == KeyCode.DIGIT8 && e.isShiftDown()) {
                    // System.out.println("The astrisk key has been pressed");
                    mulQueue();
                } else if(e.getCode() == KeyCode.SLASH) {
                    // System.out.println("The slash key has been pressed");
                    divQueue();
                } else if(e.getCode() == KeyCode.DIGIT6 && e.isShiftDown()) {
                    // System.out.println("The carrot key has been pressed");
                    expoQueue();
                } else if(e.getCode() == KeyCode.Q) {
                    // System.out.println("The 'q' key has been pressed"); // Clearing the screen
                    sqrtQueue();
                } else if (e.getCode() == KeyCode.M  && e.isShiftDown()) {
                    System.out.println("The 'M' key has been pressed");
                    findMaxQueue();
                } else if ((e.getCode() == KeyCode.M)) {
                    System.out.println("The 'm' key has been pressed");
                    findMinQueue();
                }else if(e.getText().matches("\\.")) { // Decimals and number
                    if(currentInput.contains(".")) {
                        // System.out.println("The decimal is already present");
                    }else {
                        currentInput += e.getText();
                        input.setText("Input: " + currentInput);
                    }
                } else if(e.getText().matches("[0-9]")) {
                    currentInput += e.getText();
                    input.setText("Input: " + currentInput);
                } else if(e.getCode() == KeyCode.ENTER) { // Push (Enter) the new input
                    mainQueue.add(Double.valueOf(currentInput));
                    currentInput = "";
                    input.setText("Input: ");
                }

                output.setText(returnQueuekAsString(mainQueue));
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
            returnString += "   " + currentElement + "\n";
        }

        returnString += ">>>";

        return returnString;
    }

    static void addQueue() {
        double result = mainQueue.poll();
        
        while(!mainQueue.isEmpty()) {
            result += mainQueue.poll();
        }

        mainQueue.add(result);
    }

    static void subQueue() {
        double result = mainQueue.poll();
        
        while(!mainQueue.isEmpty()) {
            result -= mainQueue.poll();
        }

        mainQueue.add(result);
    }

    static void mulQueue() {
        double result = mainQueue.poll();
        
        while(!mainQueue.isEmpty()) {
            result *= mainQueue.poll();
        }

        mainQueue.add(result);
    }

    static void divQueue() {
        double result = mainQueue.poll();
        
        while(!mainQueue.isEmpty()) {
            result /= mainQueue.poll();
        }

        mainQueue.add(result);
    }

    static void expoQueue() {
        double result = mainQueue.poll();

        while(!mainQueue.isEmpty()) {
            result = Math.pow(result, mainQueue.poll());
        }

        mainQueue.add(result);
    }

    static void sqrtQueue() {
        double result = Math.sqrt(mainQueue.peek());

        mainQueue.clear();
        mainQueue.add(result);
    }

    static void findMinQueue() {
        double result = mainQueue.poll();

        while(!mainQueue.isEmpty()) {
            double contender = mainQueue.poll();
            if(contender < result) result = contender;
        }

        mainQueue.add(result);
    }

    static void findMaxQueue() {
        double result = mainQueue.poll();

        while(!mainQueue.isEmpty()) {
            double contender = mainQueue.poll();
            if(contender > result) result = contender;
        }

        mainQueue.add(result);
    }
}
