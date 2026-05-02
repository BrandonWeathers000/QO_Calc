/**
 * Fix rounding errors with BigDecimal class
 */

import java.lang.Math;
import java.math.BigDecimal;
import java.util.ArrayDeque; // add(), poll(), & peek() methods
import java.util.ArrayList;
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

public class MainScreen extends Application {
    String currentInput = "";

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        // The instance of the MathHandler 
        MathHandler M = new MathHandler();

        Label title = new Label("Queue:");
        title.setFont(new Font("Terminess Nerd Font", 50));
        title.setTextFill(Color.WHITE);

        Label output = new Label("?");
        output.setFont(new Font("Terminess Nerd Font", 40));
        output.setTextFill(Color.WHITE);
        output.setText(returnQueuekAsString(M.mainQueue));

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
                    M.mainQueue.clear();
                    currentInput = "";
                    input.setText("Input: ");
                } else if((e.getCode() == KeyCode.EQUALS && e.isShiftDown()) || (e.getCode() == KeyCode.ADD)) { // Basic operations
                    M.addQueue();
                } else if((e.getCode() == KeyCode.MINUS) || (e.getCode() == KeyCode.SUBTRACT)) {
                    M.subQueue();
                } else if((e.getCode() == KeyCode.DIGIT8 && e.isShiftDown()) || (e.getCode() == KeyCode.MULTIPLY)) {
                    M.mulQueue();
                } else if((e.getCode() == KeyCode.SLASH) || (e.getCode() == KeyCode.DIVIDE)) {
                    M.divQueue();
                } else if(e.getCode() == KeyCode.DIGIT6 && e.isShiftDown()) {
                    M.expoQueue();
                } else if(e.getCode() == KeyCode.Q) {
                    M.sqrtQueue();
                } else if (e.getCode() == KeyCode.M  && e.isShiftDown()) {
                    M.findMaxQueue();
                } else if ((e.getCode() == KeyCode.M)) {
                    M.findMinQueue();
                }else if(e.getText().matches("\\.")) { // Decimals and number
                    if(currentInput.contains(".")) {
                    }else {
                        currentInput += e.getText();
                        input.setText("Input: " + currentInput);
                    }
                } else if(e.getText().matches("[0-9]")) {
                    currentInput += e.getText();
                    input.setText("Input: " + currentInput);
                } else if(e.getCode() == KeyCode.ENTER) { // Push (Enter) the new input
                    M.mainQueue.add(Double.valueOf(currentInput));
                    currentInput = "";
                    input.setText("Input: ");
                }

                output.setText(returnQueuekAsString(M.mainQueue));
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

    // static void addQueue() {
    //     double result = M.mainQueue.poll();
        
    //     while(!M.mainQueue.isEmpty()) {
    //         result += M.mainQueue.poll();
    //     }

    //     M.mainQueue.add(result);
    // }

    // static void subQueue() {
    //     double result = M.mainQueue.poll();
        
    //     while(!M.mainQueue.isEmpty()) {
    //         result -= M.mainQueue.poll();
    //     }

    //     M.mainQueue.add(result);
    // }

    // static void mulQueue() {
    //     double result = M.mainQueue.poll();
        
    //     while(!M.mainQueue.isEmpty()) {
    //         result *= M.mainQueue.poll();
    //     }

    //     M.mainQueue.add(result);
    // }

    // static void divQueue() {
    //     double result = M.mainQueue.poll();
        
    //     while(!M.mainQueue.isEmpty()) {
    //         result /= M.mainQueue.poll();
    //     }

    //     M.mainQueue.add(result);
    // }

    // static void expoQueue() {
    //     ArrayList<Double> numberList = new ArrayList<>();

    //     while(!M.mainQueue.isEmpty()) {
    //         numberList.add(M.mainQueue.poll());
    //     }

    //     Double result = Math.pow(numberList.get(numberList.size() - 2), numberList.get(numberList.size() - 1));
    //     numberList.remove(numberList.size() - 1);
    //     numberList.remove(numberList.size() - 1);

    //     while(!numberList.isEmpty()) {
    //         result = Math.pow(numberList.get(numberList.size() - 1), result);
    //         numberList.remove(numberList.size() - 1);
    //     }

    //     M.mainQueue.add(result);
    // }

    // static void sqrtQueue() {
    //     double result = Math.sqrt(M.mainQueue.peek());

    //     M.mainQueue.clear();
    //     M.mainQueue.add(result);
    // }

    // static void findMinQueue() {
    //     double result = M.mainQueue.poll();

    //     while(!M.mainQueue.isEmpty()) {
    //         double contender = M.mainQueue.poll();
    //         if(contender < result) result = contender;
    //     }

    //     M.mainQueue.add(result);
    // }

    // static void findMaxQueue() {
    //     double result = M.mainQueue.poll();

    //     while(!M.mainQueue.isEmpty()) {
    //         double contender = M.mainQueue.poll();
    //         if(contender > result) result = contender;
    //     }

    //     M.mainQueue.add(result);
    // }
}
