package Models;


import Helpers.Enums;
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
    protected int iPos,jPos;

    public void setGameSession(GameSession gameSession) 
    {
        this.gameSession = gameSession;
    }

    public void setIPos(int i) 
    {
        this.iPos = i;
    }

    public void setJPos(int j) 
    {
        this.jPos = j;
    }
    
    public abstract void simulateNextStep(Enums.GravitacioIranya gravitacioIrany);
    public abstract int getCurrentX();
    public abstract int getCurrentY();
    public abstract Image getImage();
    
    protected GameObject getNeighbor(Enums.GravitacioIranya gravitacioIrany,int x,int y)
    {       
        switch(gravitacioIrany)
        {
            case Fel:
                x++;
                break;
            case Le:
                x--;
                break;
            case Jobbra:
                y++;
                break;
            case Ballra:
                y--;
                break;
        }
        return gameSession.getGameObjectAt(x,y);
    }
    
    public int getNextI(Enums.GravitacioIranya gravitacioIranya) 
    {
        int nextI=-1;
        int tempI=iPos;
        GameObject neighbor=null;
        while(nextI==-1)
        {            
            switch(gravitacioIranya)
            {
                case Jobbra:
                    nextI=iPos;
                    break;
                case Ballra:
                     nextI=iPos;
                    break;
                case Fel:                 
                    neighbor=getNeighbor(gravitacioIranya, tempI, jPos);
                    if(neighbor instanceof Levego)
                    {
                        tempI++;
                    }else
                    {
                        nextI=tempI+1;
                    }
                    break;
                case Le:
                    neighbor=getNeighbor(gravitacioIranya, tempI, jPos);
                    if(neighbor instanceof Levego)
                    {
                        tempI--;
                    }else
                    {
                        nextI=tempI-1;
                    }
                    break;
            }
        }
        return nextI;
    }

    public int getNextJ(Enums.GravitacioIranya gravitacioIranya)
    {
        int nextJ=-1;
        int tempJ=jPos;
        GameObject neighbor=null;
        while(nextJ==-1)
        {            
            switch(gravitacioIranya)
            {
                case Fel:
                    nextJ=jPos;
                    break;
                case Le:
                     nextJ=jPos;
                    break;
                case Jobbra:                 
                    neighbor=getNeighbor(gravitacioIranya, iPos, tempJ);
                    if(neighbor instanceof Levego)
                    {
                        tempJ++;                       
                    }else
                    {
                       nextJ=tempJ+1;
                    }
                    break;
                case Ballra:
                    neighbor=getNeighbor(gravitacioIranya, iPos, tempJ);
                    if(neighbor instanceof Levego)
                    {
                        tempJ--;
                        nextJ=tempJ;
                    }else
                    {
                        nextJ=tempJ-1;
                    }
                    break;
            }
        }
        return nextJ;
    }
}
