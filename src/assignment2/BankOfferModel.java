package assignment2;

import java.util.Collection;
import java.util.Scanner;

/**
 *
 * @author Laina and Alexandra
 */
public class BankOfferModel 
{    
    //Calculates bank offer at the end of each round, the bank offer being half the average of remaing value in cases 
    public int calculateOffer(double[] remainingValues)
    {
        int sum = 0;
        int size = 0;
        for(double values : remainingValues)
        {
            sum += values;
            if(values != 0){
                size++;
            }
        }
        if(sum == 0){
            return 0;
        }else if(size == 0){
            return 0;
        }
        int offer = (sum/size) * 1/2;
        return offer;
    }
    
    //Asks player if they want to accept the bank offer
    public boolean dealOrNoDeal(int offer, Scanner scan){
        System.out.println("Do you accept the bankers offer (y or n): ");
        String response = scan.nextLine();
        if(response.equalsIgnoreCase("y"))
        {
            System.out.println("Congratulations, you have accepted the Banks offer of $" + offer);
            return false;
        } else //if any key is selected other than 'y' we have assumed that the player wants to continue with the game
        {
            System.out.println("You have declined the banks offer, continue game");
            return true;
        }
    }
}


