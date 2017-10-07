import java.util.Random;

public class MarkovChain {

    private double[][] transitionMatrix = new double[][]{
            {0.8, 0.2, 0.0, 0.0},
            {0.1, 0.8, 0.1, 0.0},
            {0.1, 0.0, 0.7, 0.2},
            {0.1, 0.0, 0.0, 0.9}
    };
    private double totalWalks = 0.0;
    private double gCount = 0.0;
    private double yCount = 0.0;
    private double oCount = 0.0;
    private double rCount = 0.0;

    public MarkovChain(){
        runRandomStart();
    }

    public MarkovChain(int startPosition){
        runKnownStart(startPosition);
    }

    private void runKnownStart(int startPosition){

    }

    private void runRandomStart(){
        Random random = new Random();
        int initial = random.nextInt(3);
    }

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
        } else {
            nextState = 3;
        }
        // Return the next walk location
        return nextState;
    }
}
