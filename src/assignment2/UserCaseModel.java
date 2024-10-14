/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.util.HashMap;

/**
 *
 * @author Alexandra
 */
public class UserCaseModel extends CasesModel {

    private int userCaseNumber;
    private double userCasePrice;
    private HashMap<Integer, Double> cases;
    private CasesModel c;

    public UserCaseModel() {

    }

    public void setUserCase(CasesModel c, int userCaseNumber) {
        this.c = c;
        this.userCaseNumber = userCaseNumber;
        this.userCasePrice = c.getPrice(userCaseNumber);
    }

    public int getUserCaseNumber() {
        return userCaseNumber;
    }

    public double getUserCasePrice() {
        return this.userCasePrice;
    }

    public void setUserCaseNumber(int userCaseNumber) {
        this.userCaseNumber = userCaseNumber;
        setUserCasePrice(c.getPrice(userCaseNumber));
    }

    public void setUserCasePrice(double userCasePrice) {
        this.userCasePrice = userCasePrice;
    }
}
