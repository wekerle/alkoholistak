/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alkoholistak;

import Models.LevelModel;
import java.util.ArrayList;


//loveercase es trim a similarty setbe
//test similarity
/**
 *
 * @author Ronaldo
 */
public class DataCollector
{
    private ArrayList<LevelModel> levels=new ArrayList<LevelModel>();
    
    public DataCollector()
    {
        constructLevels();
        //# -fal
        //a -alkololista
        //b -nem alkoholista
    }
    
    private void constructLevels()
    {
        // nivelul 1
        char[][] matrix1={
            {'a','a','a'},
            {'a','a','a'},
            {'a','a','a'},
            {'a','a','a'},
        };
        LevelModel level1=new LevelModel(matrix1, 1, 1);
        levels.add(level1);
        char[][] matrix2={
            {'a','a','a'},
            {'a','a','a'},
            {'a','a','a'},
            {'a','a','a'},
        };
        LevelModel level2=new LevelModel(matrix2, 2, 2);
        levels.add(level2);
        char[][] matrix3={
            {'a','a','a'},
            {'a','a','a'},
            {'a','a','a'},
            {'a','a','a'},
        };
        LevelModel level3=new LevelModel(matrix3, 3, 3);
        levels.add(level3);
    }
    
    public ArrayList<LevelModel>  getLevels()
    {
        return levels;
    }
    
}
