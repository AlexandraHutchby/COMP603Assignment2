package assignment2;

/**
 *
 * @author Laina and Alexandra
 */
public class Rounds 
{
    private int currentRound;
    private int remainingCasesThisRound;
    private int[] casesToOpen;
    
    public Rounds(int totalCases) 
    {
        this.currentRound = 1; // Starting from round 1
        this.casesToOpen = new int[] {6, 5, 4, 3, 2, 2, 1, 1}; //Initial array to show how many cases are open per round
        this.remainingCasesThisRound  = casesToOpen[0];
    }
    
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


