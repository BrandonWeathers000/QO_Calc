import java.lang.Math;
import java.math.BigDecimal;
import java.util.ArrayDeque; // add(), poll(), & peek() methods
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

class MathHandler {
    Queue<Double> mainQueue = new ArrayDeque<>(); // Cannot be static
    
    void addQueue() {
        double result = mainQueue.poll();
        
        while(!mainQueue.isEmpty()) {
            result += mainQueue.poll();
        }

        mainQueue.add(result);
    }

    void subQueue() {
        double result = mainQueue.poll();
        
        while(!mainQueue.isEmpty()) {
            result -= mainQueue.poll();
        }

        mainQueue.add(result);
    }

    void mulQueue() {
        double result = mainQueue.poll();
        
        while(!mainQueue.isEmpty()) {
            result *= mainQueue.poll();
        }

        mainQueue.add(result);
    }

    void divQueue() {
        double result = mainQueue.poll();
        
        while(!mainQueue.isEmpty()) {
            result /= mainQueue.poll();
        }

        mainQueue.add(result);
    }

    void expoQueueTopToBottom() {
        ArrayList<Double> numberList = new ArrayList<>();

        while(!mainQueue.isEmpty()) {
            numberList.add(mainQueue.poll());
        }

        Double result = Math.pow(numberList.get(numberList.size() - 2), numberList.get(numberList.size() - 1));
        numberList.remove(numberList.size() - 1);
        numberList.remove(numberList.size() - 1);

        while(!numberList.isEmpty()) {
            result = Math.pow(numberList.get(numberList.size() - 1), result);
            numberList.remove(numberList.size() - 1);
        }

        mainQueue.add(result);
    }

    void expoQueueLeftToRight() {
        double result = mainQueue.poll();
        double exponent = mainQueue.poll();

        while(!mainQueue.isEmpty()) {
            exponent *= mainQueue.poll();
        }

        mainQueue.clear();
        mainQueue.add(Math.pow(result, exponent));
    }

    void logQueue() {
        double result = mainQueue.poll();

        while(!mainQueue.isEmpty()) {
            result = customLog(result, mainQueue.poll());
        }

        mainQueue.add(result);
    }

    private static double customLog(double base, double logNumber) {
        return Math.log(logNumber) / Math.log(base);
    }

    void sqrtQueue() {
        Queue<Double> resultQueue = new ArrayDeque<>();

        while(!mainQueue.isEmpty()) {
            resultQueue.add(Math.sqrt(mainQueue.poll()));
        }

        mainQueue.clear();
        mainQueue = resultQueue;
    }

    void customSqrtQueue() {
        Stack<Double> newStack = new Stack<>();

        while(!mainQueue.isEmpty()) {
            newStack.push(mainQueue.poll());
        }

        mainQueue.add(newStack.pop());

        while(!newStack.isEmpty()) {
            mainQueue.add(1.0/newStack.pop());
        }

        expoQueueLeftToRight();
    }

    void findMinQueue() {
        double result = mainQueue.poll();

        while(!mainQueue.isEmpty()) {
            double contender = mainQueue.poll();
            if(contender < result) result = contender;
        }

        mainQueue.add(result);
    }

    void findMaxQueue() {
        double result = mainQueue.poll();

        while(!mainQueue.isEmpty()) {
            double contender = mainQueue.poll();
            if(contender > result) result = contender;
        }

        mainQueue.add(result);
    }
}
