/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javafx.scene.image.Image;

/**
 *
 * @author Ronaldo
 */
public class Alkoholista extends GameObject
{
    private Image image=new Image("/img/zombie.png");
   
    @Override
    public Image getImage() 
    {
        return image;
    } 

    @Override
    public boolean canFall() 
    {
       return true;
    }
}
