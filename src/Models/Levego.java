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
public class Levego extends GameObject
{
    @Override
    public void simulateNextStep(Enums.GravitacioIranya gravitacioIrany) 
    {
        
    }

    @Override
    public int getCurrentX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Image getImage() 
    {
        return null;
    }

    @Override
    public int getCurrentY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
