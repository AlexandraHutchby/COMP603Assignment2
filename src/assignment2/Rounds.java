package assignment2;

/**
 *
 * @author Laina and Alexandra
 */
public class Rounds 
{
    public int[] casesToOpenPerRound(int totalCases)
    {
        int remainingCases = totalCases - 1; //Number of cases after player has chosen
        int[] casesToOpen = {6, 5, 4, 3, 2, 1, 1, 1}; //Initial array to show how many cases are open per round
        
        int roundsCount= casesToOpen.length; //Number of rounds determined by the length of the casesToOpen array.
        int[] rounds = new int[roundsCount]; //Array to store the actual number of cases to open in each round.
        
        
        //Loop through each round to determine how many cases should be opened.
        for(int i = 0; i < roundsCount; i++)
        {
            if(remainingCases > 1)
            {
                rounds[i] = casesToOpen[i];
                remainingCases -= casesToOpen[i];
            } else
            {
                rounds[i] = 0;
            }
        }
        return rounds; //Returns array of cases to be opened per round
    }
    
}


