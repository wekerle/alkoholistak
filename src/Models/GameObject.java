package Models;


import Helpers.Enums;
import java.util.ArrayList;
import javafx.scene.image.Image;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ronaldo
 */
public abstract class GameObject 
{
    protected GameSession gameSession=null;
    protected int fromX,toX,fromY,toY;

    public void setGameSession(GameSession gameSession) 
    {
        this.gameSession = gameSession;
    }

    public int getFromX() 
    {
        return fromX;
    }

    public void setFromX(int fromX) 
    {
        this.fromX = fromX;
    }

    public int getToX() 
    {
        return toX;
    }

    public void setToX(int toX) 
    {
        this.toX = toX;
    }

    public int getFromY() 
    {
        return fromY;
    }

    public void setFromY(int fromY) 
    {
        this.fromY = fromY;
    }

    public int getToY() 
    {
        return toY;
    }

    public void setToY(int toY) 
    {
        this.toY = toY;
    }
    
    public abstract Image getImage();
    public abstract boolean canFall();
    
    protected GameObject getNeighbor(Enums.GravitacioIranya gravitacioIrany,int i,int j)
    {       
        switch(gravitacioIrany)
        {
            case Fel:
                i--;
                break;
            case Le:
                i++;
                break;
            case Jobbra:
                j++;
                break;
            case Ballra:
                j--;
                break;
        }
        return gameSession.getGameObjectAt(i,j);
    }
    
    public int getNumberOfStepsI(Enums.GravitacioIranya gravitacioIranya, int iPos, int jPos) 
    {
        int tempI=iPos;
        int numberOfSteps=0;
        GameObject neighbor=null;
        
        switch(gravitacioIranya)
        {
            case Jobbra:
            case Ballra:
                break;
            case Fel:                 
                neighbor=getNeighbor(gravitacioIranya, tempI, jPos);
                while(neighbor instanceof Levego)
                {
                    tempI--;
                    numberOfSteps--;
                    neighbor=getNeighbor(gravitacioIranya, tempI, jPos);
                }
                break;
            case Le:
                neighbor=getNeighbor(gravitacioIranya, tempI, jPos);
                while(neighbor instanceof Levego)
                {
                    tempI++;
                    numberOfSteps++;
                    neighbor=getNeighbor(gravitacioIranya, tempI, jPos);
                }
                break;
        }
        return numberOfSteps;
    }

    public int getNumberOfStepsJ(Enums.GravitacioIranya gravitacioIranya, int iPos, int jPos)
    {
        int tempJ=jPos;
        int numberOfSteps=0;
        GameObject neighbor=null;
        
        switch(gravitacioIranya)
        {
            case Fel:
            case Le:
                break;
            case Jobbra:                 
                neighbor=getNeighbor(gravitacioIranya, iPos, tempJ);
                while(neighbor instanceof Levego)
                {
                    tempJ++;
                    numberOfSteps++;
                    neighbor=getNeighbor(gravitacioIranya, iPos, tempJ);
                }
                break;
            case Ballra:
                neighbor=getNeighbor(gravitacioIranya, iPos, tempJ);
                while(neighbor instanceof Levego)
                {
                    tempJ--;
                    numberOfSteps--;
                    neighbor=getNeighbor(gravitacioIranya, iPos, tempJ);
                }
                break;
        }
        return numberOfSteps;
    }

    public ArrayList<GameObject> getMainNeighbors(int i,int j)
    {
        ArrayList<GameObject> result=new ArrayList<GameObject>();
        
        return result;
    }
    
    public ArrayList<GameObject> getAllNeighbors()
    {
        ArrayList<GameObject> result=new ArrayList<GameObject>();
        
        return result;
    }
}
