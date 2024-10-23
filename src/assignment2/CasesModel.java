package assignment2;

import java.util.HashMap;
import java.util.Random;

/**
 * This class models the cases. It assigns random values to numbered cases, and
 * manages the state of those. It provides methods for retrieving the case
 * values and resetting
 *
 * @author Alexandra and Laina
 */
class CasesModel {

    Random rand = new Random();
    //Initialising cases
    //Temp array to keep track of unused cases during assignment of money to cases
    private int[] number = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};

    //array of prices corsponding to the 26 cases
    private double[] price = new double[]{0.01, 1, 5, 10, 25, 50, 75, 100, 200, 300, 400, 500, 750, 1000, 5000, 10000, 25000, 50000, 75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000};

    //array to keep track of which prizes have not yet been asssigned to cases
    private int[] indexNotUsed;

    //Array to track remaining unopned cases values
    private double[] pricesRemaining = new double[26];

    //HashMap to store case numbers and their corresponging prize
    private HashMap<Integer, Double> cases = new HashMap<>();

    //Returns the map of cases and their assigned monetary calues
    public HashMap<Integer, Double> getCases() {
        if (cases != null) {
            return cases;
        }
        return null;
    }

    //Assigning prize money to cases
    public void createCases() {
        indexNotUsed = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        for (int i = 0; i < number.length; i++) {
            int j = rand.nextInt(indexNotUsed.length);
            int chosen = indexNotUsed[j];
            removeInt(j);
            cases.put(number[i], price[chosen]);
        }
    }

    //for temporary array during assignment of money to cases
    private void removeInt(int j) {
        int[] temp = new int[indexNotUsed.length - 1];
        int index = 0;
        for (int i = 0; i < indexNotUsed.length; i++) {
            if (i != j) {
                temp[index] = indexNotUsed[i];
                index++;
            }
        }
        indexNotUsed = temp;
    }

    //Resets cases by clearing case assignments and reassigning new random prizes
    public void resetCases() {
        cases.clear();
        createCases();
    }

    //Get methods
    public double getPrice(int caseNumber) {
        return cases.get(caseNumber);
    }

    public double[] getAmounts() {
        return price;
    }

    public void setPricesRemaining(double[] price) {
        System.arraycopy(price, 0, pricesRemaining, 0, 26);
    }

    public double[] getRemaining() {
        return pricesRemaining;
    }
}
