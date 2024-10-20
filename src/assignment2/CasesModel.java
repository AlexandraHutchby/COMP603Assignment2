/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.util.Collection;
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
    private int[] number= new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};//Temp array to keep track of unused cases during assignment of money to cases
    private double[] price = new double[]{0.01, 1, 5, 10, 25, 50, 75, 100, 200, 300, 400, 500, 750, 1000, 5000, 10000, 25000, 50000, 75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000};
    private int[] indexNotUsed; 
    private double[] pricesRemaining = new double[26];
        
    private HashMap<Integer, Double> cases = new HashMap<>();
    
    public HashMap<Integer, Double> getCases(){
        if(cases != null){
            return cases;
        }
        return null;
    }
    
    //Assigning prize money to cases
    public void createCases()
    {
        indexNotUsed = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        for(int i = 0; i < number.length; i++)
        {
            int j = rand.nextInt(indexNotUsed.length);
            int chosen = indexNotUsed[j];  
            removeInt(j);
            cases.put(number[i], price[chosen]);
        }
    }
    
    //for temporary array during assignment of money to cases
    private void removeInt(int j)
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
    
    
    
    public void resetCases(){
        cases.clear();
        createCases();
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
