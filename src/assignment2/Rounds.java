
package assignment2;

/**
 * This function manages the game's round progression, tracking how many cases need to be opened per round
 * advancing to the next round, and resetting the rounds when needed
 * 
 * @author Alexandra and Laina
 */
public class Rounds 
{
    private int currentRound; //round number
    private int remainingCasesThisRound; //remaining cases that round
    private int[] casesToOpen;
    
    public Rounds(int totalCases) 
    {
        this.currentRound = 1; // Starting from round 1
        this.casesToOpen = new int[] {6, 5, 4, 3, 2, 2, 1, 1}; //Initial array to show how many cases are open per round
        this.remainingCasesThisRound  = casesToOpen[0]; //round 1 cases to be removed
    }
    
    //returns the amount of cases to be opened that round
    public int casesToOpenPerRound()
    {
       if(currentRound - 1 <casesToOpen.length)
       {
           return casesToOpen[currentRound];
       }
       return 0; 
    }
    
    //Going to next round
    public boolean nextRound()
    {
        // Check if the current round is over
        if (remainingCasesThisRound == 0 && currentRound < casesToOpen.length) 
        {
            currentRound++;
            remainingCasesThisRound = casesToOpen[currentRound - 1]; // Set remaining cases for the new round
            return true;
        }
        return false;
    }
    
    //updates the remaining cases by reducing it by 1
    public void updateRemainingCases() 
    {
        if (remainingCasesThisRound  > 0) 
        {
            remainingCasesThisRound--;
        }
    }
    
    //rounds reset method for a new game
    public void reset()
    {
        currentRound = 1;
        casesToOpen = new int[]{6, 5, 4, 3, 2, 2, 1, 1};
        remainingCasesThisRound = casesToOpen[0];
    }
    
    
    //Get methods
    public int getCurrentRound()
    {
        return currentRound;
    }
    
    public int getRemainingCasesThisRound()
    {
        return remainingCasesThisRound ;
    }
    public int getTotalRounds()
    {
        return casesToOpen.length;
    }
}


