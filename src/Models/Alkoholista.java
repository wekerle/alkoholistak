/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Helpers.Enums;
import javafx.scene.image.Image;

/**
 *
 * @author Ronaldo
 */
public class Alkoholista extends GameObject
{
    private Image image=new Image("/img/zombie.png");
   
    @Override
    public void simulateNextStep(Enums.GravitacioIranya gravitacioIrany) 
    {
        GameObject neighBor=null;
       // int neighborX=x,neighborY=y;
       // while(true)
       // {
           // neighBor=getNeighbor(gravitacioIrany,neighborX,neighborY);
            if(neighBor!=null)
            {
                return;
            }
            
            switch(gravitacioIrany)
            {
                case Fel:
                    //neighborX++;
                    break;
                case Le:
                   // neighborX--;
                    break;
                case Jobbra:
                   // neighborY++;
                    break;
                case Ballra:
                   // neighborY--;
                    break;
            }
       // }
    }

    @Override
    public int getCurrentX() 
    {
       return 0;
    }

    @Override
    public Image getImage() 
    {
        return image;
    }

    @Override
    public int getCurrentY() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
