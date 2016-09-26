/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author tibor.wekerle
 */
public class NextStepSimulateModel {
    private int numberOfStepsI,numberOfStepsJ,i,j;

    public int getNumberOfStepsI() 
    {
        return numberOfStepsI;
    }

    public int getNumberOfStepsJ() 
    {
        return numberOfStepsJ;
    }

    public int getI() 
    {
        return i;
    }

    public int getJ() 
    {
        return j;
    }
    
    public NextStepSimulateModel(int i,int j,int numberOfStepsI,int numberOfStepsJ)
    {
        this.i=i;
        this.j=j;
        this.numberOfStepsI=numberOfStepsI;
        this.numberOfStepsJ=numberOfStepsJ;
    }
}
