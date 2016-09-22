package Models;


import Helpers.Enums;
import Models.GameSession;
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
    private int x,y;

    public void setGameSession(GameSession gameSession) 
    {
        this.gameSession = gameSession;
    }

    public void setX(int x) 
    {
        this.x = x;
    }

    public void setY(int y) 
    {
        this.y = y;
    }
    
    public abstract void simulateNextStep(Enums.GravitacioIranya gravitacioIrany);
    public abstract void getCurrentX();
    public abstract void getPreviusX();
    public abstract Image getImage();
    
    protected GameObject getNeighbor(Enums.GravitacioIranya gravitacioIrany)
    {
        int neighborX=x,neighborY=y;
        
        switch(gravitacioIrany)
        {
            case Fel:
                neighborX++;
                break;
            case Le:
                neighborX--;
                break;
            case Jobbra:
                neighborY++;
                break;
            case Ballra:
                neighborY--;
                break;
        }
        return gameSession.getGameObjectAt(neighborX,neighborY);
    }
}
