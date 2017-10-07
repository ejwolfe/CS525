/**
 * Created by Eric Wolfe on 10/7/17.
 */

import java.util.Random;

public class Pi {

    public Pi(int numberofPoints){
        run(numberofPoints);
    }

    private void run(int numberOfPoints){
        Random random = new Random();
        double result, numberOfSuccesses = 0.0;
        for(int i = 0; i < numberOfPoints; i++){
            double x = random.nextDouble();
            double y = random.nextDouble();
            result = calculateCircle(x, y);
            if (result < 1.0){
                numberOfSuccesses++;
            }
        }
        printResults(numberOfSuccesses, numberOfPoints);
    }

    private void printResults(double result, int numberOfPoints){
        System.out.printf("The number of accepted points: %.0f\n", result);
        System.out.printf("Approximate value of pi: %.5f\n", 4*(result/ (double)numberOfPoints));
    }

    private double calculateCircle(double x, double y){
        x = x * x;
        y = y * y;
        return (x + y);
    }
}
