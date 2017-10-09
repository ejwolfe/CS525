public class Main {

    public static void main(String[] args) {
        System.out.println("Starting tests: ");
        // Experiment 1
        new MarkovChain(0, 30, "test1.csv");
        System.out.print(":-");
        new MarkovChain(1, 30, "test2.csv");
        System.out.print("-");
        new MarkovChain(2, 30, "test3.csv");
        System.out.print("-");
        new MarkovChain(3, 30, "test4.csv");
        System.out.print("-");
        // Experiment 2
        new MarkovChain(100, "test5.csv");
        System.out.print("-");
        new MarkovChain(1000, "test6.csv");
        // Experiment 3
        System.out.print("-");
        new MarkovChain(1000, "test7.csv");
        System.out.print("-");
        new MarkovChain(1000, "test8.csv");
        System.out.print("-");
        new MarkovChain(1000, "test9.csv");
        System.out.print("-");
        new MarkovChain(1000, "test10.csv");
        System.out.print("-");
        new MarkovChain(1000, "test11.csv");
        System.out.print("-");
        new MarkovChain(1000, "test12.csv");
        System.out.print("-");
        new MarkovChain(1000, "test13.csv");
        System.out.print("-");
        new MarkovChain(1000, "test14.csv");
        System.out.print("-");
        new MarkovChain(1000, "test15.csv");
        System.out.print("-");
        new MarkovChain(1000, "test16.csv");
        System.out.print("-:\n Finished tests");
    }

}
