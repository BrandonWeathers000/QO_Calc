import java.lang.Math;
import java.math.BigDecimal;
import java.util.ArrayDeque; // add(), poll(), & peek() methods
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
            result = Math.log(mainQueue.poll()) / Math.log(result);
        }

        mainQueue.add(result);
    }

    void logQueueBaseE() {
        Queue<Double> resultQueue = new ArrayDeque<>();

        while(!mainQueue.isEmpty()) {
            resultQueue.add(Math.log(mainQueue.poll()));
        }

        mainQueue.clear();
        mainQueue = resultQueue;
    }
        
    void logQueueBase10() {
        Queue<Double> resultQueue = new ArrayDeque<>();

        while(!mainQueue.isEmpty()) {
            resultQueue.add(Math.log10(mainQueue.poll()));
        }

        mainQueue.clear();
        mainQueue = resultQueue;
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

    void findMean() {
        int queueLength = mainQueue.size();
        double result = mainQueue.poll() + mainQueue.poll();

        while(!mainQueue.isEmpty()) {
            result += mainQueue.poll();
        }

        result /= queueLength;

        mainQueue.add(result);
    }

    void findGeoMean() {
        int queueLength = mainQueue.size();
        double result = mainQueue.poll() * mainQueue.poll();

        while(!mainQueue.isEmpty()) {
            result *= mainQueue.poll();
        }

        result = Math.pow(result, 1.0/queueLength);

        mainQueue.add(result);
    }

    void findMedian() {
        Double result = 0.0;
        ArrayList<Double> newList = new ArrayList<>();

        while(!mainQueue.isEmpty()) {
            newList.add(mainQueue.poll());
        }

        if(newList.size() % 2 == 0) {
            result = newList.get((newList.size()/2) - 1) + newList.get(newList.size()/2);
            result /= 2;
        }else {
            result = newList.get(newList.size()/2);
        }

        mainQueue.add(result);
    }

    void findMode() {
        int orginialQueueSize = mainQueue.size();
        Double[] nums = new Double[mainQueue.size()];

        for(int index = 0; index < orginialQueueSize; index++) {
            nums[index] = mainQueue.poll();
        }

        Arrays.sort(nums);

        int maxCount = 1;
        int currentCount = 1;

        Set<Double> modes = new HashSet<>();
        modes.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {

            if (nums[i].equals(nums[i - 1])) {
                currentCount++;
            } else {
                currentCount = 1;
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                modes.clear();
                modes.add(nums[i]);
            }
            else if (currentCount == maxCount) {
                modes.add(nums[i]);
            }
        }

        mainQueue.clear();
        mainQueue = new ArrayDeque<>(modes);
    }

    void findStandardDeviation() {
        int originialQueueLength = mainQueue.size();
        Queue<Double> copyQueue = new ArrayDeque<>(mainQueue);

        // Calculating sum
        double avg = 0.0;
        while(!mainQueue.isEmpty()) {
            avg += mainQueue.poll();
        }
        avg /= originialQueueLength;

        // Calculating the squares of the differences
        double sum = 0.0;
        while(!copyQueue.isEmpty()) {
            double intermediateValue = copyQueue.poll() - avg;
            intermediateValue *= intermediateValue;
            sum += intermediateValue;
        }

        mainQueue.clear();
        mainQueue.add(Math.pow(sum/originialQueueLength, 0.5));
    }
 }
