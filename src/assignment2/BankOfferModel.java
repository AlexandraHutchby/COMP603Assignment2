package assignment2;

import java.util.Scanner;

/**
 * This class represents the model responsible for calculating bankers offer. It
 * determines the offer based on the remaining values in the unopened cases
 *
 * @author Alexandra + Laina
 */
public class BankOfferModel {

    //Calculates bank offer at the end of each round, the bank offer being half the average of remaing value in cases 
    public int calculateOffer(double[] remainingValues) {
        int sum = 0;
        int size = 0;
        //looops through all remaining cases and add case values to sum
        for (double values : remainingValues) {
            sum += values;
            if (values != 0) {    //only counts non zero values(unopened cases)
                size++;
            }
        }
        //returns 0 is there are no values or all remaining cases have been opened
        if (sum == 0) {
            return 0;
        } else if (size == 0) {
            return 0;
        }
        //calulates offer as half the average sum of remaining cases
        int offer = (sum / size) / 2;
        return offer;
    }
}
