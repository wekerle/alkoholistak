/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author tibor.wekerle
 */
public class AplicationModel {
    private ArrayList<LevelModel> levels=new ArrayList<LevelModel>();
    private int currentLevel=1;

    public ArrayList<LevelModel> getLevels() 
    {
        return levels;
    }

    public void setLevels(ArrayList<LevelModel> levels) 
    {
        this.levels = levels;
    }

    public LevelModel getLevelById(int levelId) 
    {
        for(LevelModel level:levels)
        {
            if(level.getLevelId()==levelId)
            {
                return level;
            }
        }
        return null;
    }
    
}
