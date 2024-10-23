
package assignment2;

import java.util.HashMap;

/**
 * This class does the logic for setting, resetting and retrieving the user's
 * chosen case and its price in the game.
 *
 * @author Alexandra and Laina
 */
public class UserCaseModel extends CasesModel {

    private int userCaseNumber; //storage of the user's case number
    private double userCasePrice; //storage of the user's case price
    private HashMap<Integer, Double> cases; //array of all the cases
    private CasesModel c; //cases Model

    /*
    initilisation of the user case
     */
    public UserCaseModel() {

    }

    /*
    resets the user cases if the game is reset
     */
    public void reset() {
        userCaseNumber = 0;
        userCasePrice = 0.0;
    }

    /*
    sets the user case the first time
     */
    public void setUserCase(CasesModel c, int userCaseNumber) {
        this.c = c;
        this.userCaseNumber = userCaseNumber;
        this.userCasePrice = c.getPrice(userCaseNumber);
    }

    /*
    returns the current usercase numbers
     */
    public int getUserCaseNumber() {
        return userCaseNumber;
    }

    /*
    returns the price that is in the usercase number
     */
    public double getUserCasePrice() {
        return this.userCasePrice;
    }

    /*
    sets the user case number after the first time
     */
    public void setUserCaseNumber(int userCaseNumber) {
        this.userCaseNumber = userCaseNumber;
        setUserCasePrice(c.getPrice(userCaseNumber));
    }

    /*
    sets the case price sent from the user case number
     */
    private void setUserCasePrice(double userCasePrice) {
        this.userCasePrice = userCasePrice;
    }
}
