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
        //b -vas lada
    }
    
    private void constructLevels()
    {
        char[][] matrix1={
            {'#','#','#','#','#','#'},
            {'#',' ',' ',' ',' ','#'},
            {'#','a',' ',' ','b','#'},
            {'#','#','#','#','#','#'},
        };
        LevelModel level1=new LevelModel(matrix1, 1, 1);
        levels.add(level1);
        
        char[][] matrix2={
            {'#','#','#','#','#','#'},
            {'#',' ',' ',' ',' ','#'},
            {'#',' ',' ','#',' ','#'},
            {'#',' ',' ','#',' ','#'},
            {'#','b',' ','#','a','#'},
            {'#','#','#','#','#','#'},
        };
        LevelModel level2=new LevelModel(matrix2, 2, 2);
        levels.add(level2);
        
        char[][] matrix3={
            {'#','#','#','#','#','#'},
            {'#','#',' ',' ','b','#'},
            {'#',' ',' ','#','#','#'},
            {'#',' ',' ',' ',' ','#'},
            {'#','#',' ','#','a','#'},
            {'#','#','#','#','#','#'},
        };
        LevelModel level3=new LevelModel(matrix3, 3, 3);
        levels.add(level3);
        
        char[][] matrix4={
            {' ','#','#','#','#','#','#',' '},
            {'#','#',' ',' ',' ',' ','#','#'},
            {' ',' ',' ',' ',' ',' ','#','#'},
            {'#',' ',' ',' ',' ','b','#','#'},
            {'#',' ',' ',' ',' ','#','#','#'},
            {'#','b',' ',' ',' ',' ','#','#'},
            {'#','#',' ',' ',' ','a','#','#'},
            {' ','#','#','#','#','#','#','#'},
        };
        LevelModel level4=new LevelModel(matrix4, 4, 4);
        levels.add(level4);
        
        char[][] matrix5={
            {'#','#','#','#','#','#','#','#'},
            {'#',' ',' ',' ',' ',' ',' ',' '},
            {'#',' ',' ',' ',' ','a','#',' '},
            {'#',' ',' ',' ',' ','#',' ',' '},
            {' ',' ',' ',' ',' ',' ','#','#'},
            {' ','b',' ',' ',' ',' ',' ','#'},
            {' ','#',' ',' ',' ',' ',' ','#'},
            {'#','#','#','#','#','#','#','#'},
        };
        LevelModel level5=new LevelModel(matrix5, 5, 5);
        levels.add(level5);
        
        char[][] matrix6={
            {' ','#','#','#','#','#','#',' '},
            {'#','a',' ',' ',' ',' ','c','#'},
            {'#','#',' ','#','#',' ','#','#'},
            {'#',' ',' ','b','#',' ',' ','#'},
            {'#',' ',' ','#',' ',' ',' ','#'},
            {'#','#',' ','#','#',' ','#','#'},
            {' ','#',' ',' ',' ',' ','#',' '},
            {' ','#','#','#','#','#','#',' '},
        };
        LevelModel level6=new LevelModel(matrix6, 6, 6);
        levels.add(level6);
        
        char[][] matrix7={
            {'#','#','#','#','#','#','#','#'},
            {'#',' ',' ',' ',' ',' ',' ','#'},
            {'#','a','#','c','#',' ',' ','#'},
            {'#','#','#','#','#','#',' ','#'},
            {' ',' ',' ',' ',' ',' ',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ','#'},
            {'#','b',' ',' ',' ',' ',' ','#'},
            {'#','#','#','#','#','#','#','#'},
        };
        LevelModel level7=new LevelModel(matrix7, 7, 7);
        levels.add(level7);
    }
    
    public ArrayList<LevelModel>  getLevels()
    {
        return levels;
    }
    
}
