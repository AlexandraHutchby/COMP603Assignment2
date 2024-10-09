/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
/**
 *
 * @author Alexandra and Laina
 */

class CasesModel 
{
    Random rand = new Random();
    //Initialising cases
    private int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
    private double[] price = {0.01, 1, 5, 10, 25, 50, 75, 100, 200, 300, 400, 500, 750, 1000, 5000, 10000, 25000, 50000, 75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000};
    private int[] indexNotUsed = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}; //Temp array to keep track of unused cases during assignment of money to cases
    private double[] pricesRemaining = new double[26];
    public HashMap<Integer, Double> cases = new HashMap<>();
    
    //Assigning prize money to cases
    public void createCases()
    {
        for(int i = 0; i < number.length; i++)
        {
            int j = rand.nextInt(indexNotUsed.length);
            int chosen = indexNotUsed[j];  
            removeInt(j);
            cases.put(number[i], price[chosen]);
        }
    }
    
    //for temporary array during assignment of money to cases
    public void removeInt(int j)
    {
        int[] temp = new int[indexNotUsed.length-1];
        int index = 0;
        for(int i = 0; i < indexNotUsed.length; i++)
        {
            if(i != j)
            {
                temp[index] = indexNotUsed[i];
                index++;
            }
        }
        indexNotUsed = temp;
    }
    
    //Removing cases not used    
    public HashMap<Integer, Double> removeCase(int number)
    {
        cases.remove(number);
        return cases;
    }
    
    public HashMap<Integer, Double> chooseCase(Set caseNumber, Scanner scan)
    {
        while(true)
        {
            try 
            {
                System.out.println("Please eliminate a case: ");
                System.out.println(caseNumber);
                int caseEliminate = scan.nextInt();
                
                if(caseNumber.contains(caseEliminate))
                {
                    System.out.println("You eliminated case " + caseEliminate);
                    System.out.println("This has $" + cases.get(caseEliminate)); //Shows user what they missed out on
                    System.out.println();
                    cases = removeCase(caseEliminate);
                    return cases;
                } else
                {
                    System.out.println("This is not available case. Please try again: ");
                }
            } catch(InputMismatchException e) //when a wrong input is put in command line
            {
                System.out.println("Invalid input. Please enter a integer.");
                scan.next();
            }
        }
        
    }
    
    public double getPrice(int caseNumber){
        return cases.get(caseNumber);
    }
    
    public double[] getAmounts(){
        return price;
    }
    
    public void setPricesRemaining(double[] price){
        System.arraycopy(price, 0, pricesRemaining, 0, 26);
    }
    
    public double[] getRemaining(){
        return pricesRemaining;
    }
}
