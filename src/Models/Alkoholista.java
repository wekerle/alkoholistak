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
        switch(gravitacioIrany)
        {
            case Fel:
                break;
            case Le:
                
                break;
            case Jobbra:
                break;
            case Ballra:
                break;
        }
    }

    @Override
    public void getCurrentX() 
    {
       
    }

    @Override
    public void getPreviusX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Image getImage() 
    {
        return image;
    }
    
}
