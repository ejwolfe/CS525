import java.io.IOException;
import java.util.Random;
import java.io.PrintWriter;
import java.io.FileWriter;

public class MarkovChain {

    private double[][] transitionMatrix = new double[][]{
            {0.8, 0.2, 0.0, 0.0},
            {0.1, 0.8, 0.1, 0.0},
            {0.1, 0.0, 0.7, 0.2},
            {0.1, 0.0, 0.0, 0.9}
    };
    private double totalWalks = 1.0;
    private double gCount = 0.0;
    private double yCount = 0.0;
    private double oCount = 0.0;
    private double rCount = 0.0;
    private String fileName;

    /*
    * Constructor that will run a walk with a random initial state
    */
    public MarkovChain(int numberOfSteps, String fileName){
        this.fileName = fileName;
        Random random = new Random();
        int initial = random.nextInt(3);
        run(initial, numberOfSteps);
    }

    /*
    * Constructor that will run a walk with a known initial state
    */
    public MarkovChain(int startPosition, int numberOfSteps, String fileName){
        this.fileName = fileName;
        run(startPosition, numberOfSteps);
    }

    /*
    * Function for going through the steps and recording the ratio of times reached a state
     */
    private void run(int startPosition, int numberOfSteps){
        double[] gArray = new double[numberOfSteps];
        double[] yArray = new double[numberOfSteps];
        double[] oArray = new double[numberOfSteps];
        double[] rArray = new double[numberOfSteps];
        for(int i = 0; i < numberOfSteps; i++, totalWalks++){
            startPosition = walk(startPosition);
            switch (startPosition){
                case 0:
                    gCount++;
                    break;
                case 1:
                    yCount++;
                    break;
                case 2:
                    oCount++;
                    break;
                case 3:
                    rCount++;
                    break;
            }
            gArray[i] = gCount / totalWalks;
            yArray[i] = yCount / totalWalks;
            oArray[i] = oCount / totalWalks;
            rArray[i] = rCount / totalWalks;
        }
        printToCSV(gArray, yArray, oArray, rArray);
    }

    /*
    * Function for deciding where the next walk will be
     */
    private int walk(int currentState){
        // Variable for return
        int nextState = 0;
        // Random number from figuring out where to walk to next
        Random random = new Random();
        double nextProbability = random.nextDouble();
        // Switch case values
        double case0 = transitionMatrix[currentState][0];
        double case1 = transitionMatrix[currentState][1] + transitionMatrix[currentState][0];
        double case2 = transitionMatrix[currentState][2] + transitionMatrix[currentState][0] + transitionMatrix[currentState][1];
        double case3 = transitionMatrix[currentState][3] + transitionMatrix[currentState][0] + transitionMatrix[currentState][3] + transitionMatrix[currentState][2];
        // Check where to walk next
        if (nextProbability > 0 && nextProbability <= case0){
            nextState = 0;
        } else if (nextProbability > case0 && nextProbability <= case1) {
            nextState = 1;
        } else if (nextProbability > case1 && nextProbability <= case2) {
            nextState = 2;
        } else if (nextProbability > case2 && nextProbability <= case3) {
            nextState = 3;
        } else {
            System.out.println("There was an error");
            System.exit(1);
        }
        // Return the next walk location
        return nextState;
    }

    /*
    * Function for printing the results of the walk to a csv file
     */
    private void printToCSV(double[] array0, double[] array1, double[] array2, double[] array3){
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < array0.length; j++) {
                    switch (i){
                        case 0:
                            printWriter.printf("%.2f,", array0[j]);
                            break;
                        case 1:
                            printWriter.printf("%.2f,", array1[j]);
                            break;
                        case 2:
                            printWriter.printf("%.2f,", array2[j]);
                            break;
                        case 3:
                            printWriter.printf("%.2f,", array3[j]);
                            break;
                    }
                }
                printWriter.println();
            }
            printWriter.close();
            fileWriter.close();
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
