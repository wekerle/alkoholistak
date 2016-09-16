/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alkoholistak;

import Models.LevelModel;
import ViewModels.LevelView;

/**
 *
 * @author Ronaldo
 */
public class Converter 
{
    public LevelView levelToLevelView(LevelModel level)
    {
        LevelView levelView=new LevelView(level);
        return levelView;        
    }
}
