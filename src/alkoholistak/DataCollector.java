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
        //c -vas lada
        //d -fa lada
        //e -bomba
        //f -tuskek
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
        
        char[][] matrix8={
            {'#','#','#','#','#','#'},
            {'#',' ','#',' ','#','#'},
            {'#',' ',' ',' ','c','#'},
            {'#','c',' ',' ','#','#'},
            {'#','#',' ',' ',' ','#'},
            {'#','a',' ',' ','c','#'},
            {'#','#','c','#','b','#'},
            {'#','#','#','#','#','#'},
        };
        LevelModel level8=new LevelModel(matrix8, 8, 8);
        levels.add(level8);
        
        char[][] matrix9={
            {'#','#','#','#','#','#','#','#'},
            {'#',' ',' ','#','#',' ',' ','#'},
            {'#',' ',' ','d','d',' ','#','#'},
            {'#',' ',' ','d',' ',' ',' ','#'},
            {'#',' ',' ','d','d',' ',' ','#'},
            {'#',' ',' ','#','#',' ',' ','#'},
            {'#','b',' ','#','#','a','e','#'},
            {'#','#','#','#','#','#','#','#'},
        };
        LevelModel level9=new LevelModel(matrix9, 9, 9);
        levels.add(level9);
        
        char[][] matrix10={
            {'d','d','d','d','d','d','d','d'},
            {'d','d',' ','d','d','d','a','d'},
            {'d','e',' ',' ',' ','d','d','d'},
            {'d','d',' ',' ',' ',' ',' ','d'},
            {'d',' ',' ',' ',' ',' ','d','d'},
            {'d','d','d',' ',' ',' ','e','d'},
            {'d','b','d','d','d',' ','d','d'},
            {'d','d','d','d','d','d','d','d'},
        };
        LevelModel level10=new LevelModel(matrix10, 10, 10);
        levels.add(level10);
        
        char[][] matrix11={
            {'#','#','#','#','#','#','#','#'},
            {'#','b','c','#',' ','e',' ','#'},
            {'#','d','c','#',' ','#',' ','#'},
            {'#',' ','#',' ',' ','#',' ','#'},
            {'#',' ','#',' ','a','#',' ','#'},
            {'#',' ','#',' ','#','c','d','#'},
            {'#',' ','e',' ','#','c','b','#'},
            {'#','#','#','#','#','#','#','#'},
        };
        LevelModel level11=new LevelModel(matrix11, 11, 11);
        levels.add(level11);
        
        char[][] matrix12={
            {'d','d','d','d','d','d'},
            {'d','e',' ','d','d','d'},
            {'d','#',' ','d','a','d'},
            {'d','c',' ','d','d','d'},
            {'d','d','d',' ','c','d'},
            {'d','b','d',' ','#','d'},
            {'d','d','d',' ','e','d'},
            {'d','d','d','d','d','d'},
        };
        LevelModel level12=new LevelModel(matrix12, 12, 12);
        levels.add(level12);
        
        char[][] matrix13={
            {' ',' ','#','#','#','#',' ',' '},
            {' ','#',' ',' ',' ',' ','#',' '},
            {'#',' ','e','c','c','e','a','#'},
            {'#','d','d','#','#','d','d','#'},
            {'#','d','d','#','#','d','d','#'},
            {'#','b',' ',' ',' ',' ',' ','#'},
            {' ','#','e','c','c','e','#',' '},
            {' ',' ','#','#','#','#',' ',' '},
        };
        LevelModel level13=new LevelModel(matrix13, 13, 13);
        levels.add(level13);
        
        char[][] matrix14={
            {' ','#','#','#','#','#','#','#'},
            {' ','#',' ',' ','#',' ',' ','#'},
            {' ','#',' ',' ',' ',' ','f','#'},
            {' ','#',' ',' ',' ',' ','#','#'},
            {'#','#',' ',' ',' ',' ','#',' '},
            {'#',' ',' ',' ',' ',' ','#',' '},
            {'#','a',' ','#',' ','b','#',' '},
            {'#','#','#','#','#','#','#',' '},
        };
        LevelModel level14=new LevelModel(matrix14, 14, 14);
        levels.add(level14);
        
        char[][] matrix15={
            {'#','#','#',' ',' ','#','#','#'},
            {'#','c',' ','#','#',' ',' ','#'},
            {'#','#','a',' ',' ',' ','#','#'},
            {' ',' ','#',' ',' ','#',' ',' '},
            {' ',' ','#',' ',' ','#',' ',' '},
            {' ','#',' ',' ',' ','f','#',' '},
            {'#','c',' ','#','#','c','b','#'},
            {'#','#','#',' ',' ','#','#','#'},
        };
        LevelModel level15=new LevelModel(matrix15, 15, 15);
        levels.add(level15);
        
        char[][] matrix16={
            {'#','#','#','#','#','#','#','#'},
            {'#',' ',' ',' ',' ',' ','c','#'},
            {'#',' ',' ','#','#','d','d','#'},
            {'#',' ',' ','#','#',' ',' ','#'},
            {'#','e','a','#','#',' ',' ','#'},
            {'#','d','d','#','#',' ',' ','#'},
            {'#','c',' ',' ',' ','b','e','#'},
            {'#','#','#','#','#','#','#','#'},
        };
        LevelModel level16=new LevelModel(matrix16, 16, 16);
        levels.add(level16);
        
        char[][] matrix17={
            {'#','#','#','#','#','#','#','#'},
            {'#','b',' ','c','c','c','c','#'},
            {'#','c','c','c','c','c','c','#'},
            {'#','d','d','d','d','d','d','#'},
            {'#',' ','e',' ','f',' ','e','#'},
            {'#','d','d','d','d','d','d','#'},
            {'#','c','c','c','c','c','a','#'},
            {'#','#','#','#','#','#','#','#'},
        };
        LevelModel level17=new LevelModel(matrix17, 17, 17);
        levels.add(level17);
        
        char[][] matrix18={
            {'#','#','#','#','#','#','#','#'},
            {'#',' ',' ','#','#',' ',' ','#'},
            {'#',' ',' ','#','#',' ',' ','#'},
            {'#',' ',' ','b','b',' ','#','#'},
            {'#',' ',' ','#','#',' ',' ','#'},
            {'#',' ',' ','#','#',' ',' ','#'},
            {'#','b',' ','#','#',' ','a','#'},
            {'#','#','#','#','#','#','#','#'},
        };
        LevelModel level18=new LevelModel(matrix18, 18, 18);
        levels.add(level18);
        
        char[][] matrix19={
            {'#','#','#',' ','#','#','#','#'},
            {'#',' ',' ',' ','#',' ','e','#'},
            {'#',' ','#',' ','#',' ','c','#'},
            {'#',' ','#',' ','#',' ',' ','#'},
            {'#','a','#',' ','d','b','d','#'},
            {'#','#','#','#','#','#','#','#'},
        };
        LevelModel level19=new LevelModel(matrix19, 19, 19);
        levels.add(level19);
        
        char[][] matrix20={
            {'#','#','#','#','#','#','#','#'},
            {'#',' ',' ','c','c',' ',' ','#'},
            {' ',' ',' ','#','#',' ',' ',' '},
            {'#',' ','#','#','#','#',' ','#'},
            {'#',' ','#','#','#','#',' ','#'},
            {'#','c',' ','#','#',' ','c','#'},
            {'#','b',' ','#','#',' ','a','#'},
            {'#','#','#','#','#','#','#','#'},
        };
        LevelModel level20=new LevelModel(matrix20, 20, 20);
        levels.add(level20);
        
        char[][] matrix21={
            {'#','#','#','#','#','#','#','#'},
            {'#',' ',' ','#','#',' ','b','#'},
            {'#','f','c',' ','c','b','b','#'},
            {'#','#','#',' ','c','#','#','#'},
            {' ',' ','#',' ','#','#',' ',' '},
            {' ',' ','#',' ',' ','#',' ',' '},
            {' ',' ','#',' ','a','#',' ',' '},
            {' ',' ','#','#','#','#',' ',' '},
        };
        LevelModel level21=new LevelModel(matrix21, 21, 21);
        levels.add(level21);
        
        char[][] matrix22={
            {'#','#','#','#','#','#','#','#'},
            {'#','a',' ',' ',' ',' ',' ','#'},
            {'#','#',' ','#','#','#','#','#'},
            {'#',' ',' ',' ',' ',' ',' ','#'},
            {'#','b','c',' ',' ',' ',' ','#'},
            {'#','#','#','#','#',' ','#','#'},
            {'#','b','c',' ',' ',' ','b','#'},
            {'#','#','#','#','#','#','#','#'},
        };
        LevelModel level22=new LevelModel(matrix22, 22, 22);
        levels.add(level22);
        
        char[][] matrix23={
            {'#','#','#','#','#','#','#','#'},
            {'#',' ',' ',' ',' ',' ','a','#'},
            {'#',' ',' ',' ',' ',' ','#','#'},
            {'#',' ',' ',' ',' ',' ',' ','#'},
            {'#','c',' ',' ',' ',' ',' ','#'},
            {'#','#','c','c','c','c','c','#'},
            {'#','b','c','c','c','c','c','#'},
            {'#','#','#','#','#','#','#','#'},
        };
        LevelModel level23=new LevelModel(matrix23, 23, 23);
        levels.add(level23);
        
        char[][] matrix24={
            {' ',' ','d','d','d','d',' ',' '},
            {' ',' ','d','a','d','d',' ',' '},
            {'d','d','d','d','d','d','d','d'},
            {'d',' ','d',' ',' ',' ',' ','d'},
            {'d','e',' ',' ',' ','d','e','d'},
            {'d','d','d','d','d','d','d','d'},
            {' ',' ','d','d','b','d',' ',' '},
            {' ',' ','d','d','d','d',' ',' '},
        };
        LevelModel level24=new LevelModel(matrix24, 24, 24);
        levels.add(level24);
        
        char[][] matrix25={
            {'#','#','#','#','#','#','#','#'},
            {'#','a','c','c',' ',' ',' ','#'},
            {'#','#','#','#','#','#',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ','#'},
            {'#',' ','#','#','#','#','#','#'},
            {'#',' ',' ',' ',' ',' ',' ','#'},
            {'#','#',' ','#',' ','#','b','#'},
            {'#','#','#','#','#','#','#','#'},
        };
        LevelModel level25=new LevelModel(matrix25, 25, 25);
        levels.add(level25);
        
        char[][] matrix26={
            {'d','d','d','#','#','d','d','d'},
            {'d','a','d','d','d','d','b','d'},
            {'d','d','d','e','d','d','d','d'},
            {'d','d','d','d','d','e','d','d'},
            {'d','d','e','d','d','d','f','d'},
            {'d','d','d','d','e','d','d','d'},
            {'d','b','d','d','d','d','b','d'},
            {'d','d','d','#','#','d','d','d'},
        };
        LevelModel level26=new LevelModel(matrix26, 26, 26);
        levels.add(level26);
        
        char[][] matrix27={
            {'#','#','#','#','#','#','#','#'},
            {'#','a',' ',' ','#',' ',' ','#'},
            {'#','#','#',' ','#',' ',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ','#'},
            {'#',' ',' ','#',' ','f','f','#'},
            {'#',' ',' ','#',' ','#','#','#'},
            {'#',' ',' ','#','c','b','b','#'},
            {'#','#','#','#','#','#','#','#'},
        };
        LevelModel level27=new LevelModel(matrix27, 27, 27);
        levels.add(level27);
        
        char[][] matrix28={
            {'#','#','#','#','#','#','#','#'},
            {'#',' ','#',' ','#',' ','#','#'},
            {'#',' ','#',' ','#',' ','#','#'},
            {'#',' ',' ',' ',' ',' ',' ','#'},
            {'#','b',' ','c',' ','c',' ','#'},
            {'#','#',' ','#','f','#','b','#'},
            {'#','#',' ','#','c','#','b','#'},
            {'#','#','#','#','#','#','#','#'},
        };
        LevelModel level28=new LevelModel(matrix28, 28, 28);
        levels.add(level28);
        
        char[][] matrix29={
            {' ','#','#','#','#','#','#',' '},
            {'#','#',' ','a',' ',' ','#','#'},
            {'#','f',' ','#','#',' ','c','#'},
            {'#','#',' ',' ',' ',' ',' ','#'},
            {'#',' ',' ','f',' ',' ',' ','#'},
            {'#',' ',' ','#','#',' ','b','#'},
            {'#','#',' ','c',' ',' ','#','#'},
            {' ','#','#','#','#','#','#',' '},
        };
        LevelModel level29=new LevelModel(matrix29, 29, 29);
        levels.add(level29);
        
        char[][] matrix30={
            {' ',' ',' ',' ','#','#','#','#'},
            {' ',' ',' ',' ','#',' ','b','#'},
            {' ',' ',' ',' ','#',' ','#','#'},
            {' ',' ',' ',' ','#',' ',' ','#'},
            {'#','#','#','#','#','#',' ','#'},
            {'#','c','c',' ',' ',' ',' ','#'},
            {'#','a','c','f','#',' ','#','#'},
            {'#','#','#','#','#','#','#','#'},
        };
        LevelModel level30=new LevelModel(matrix30, 30, 30);
        levels.add(level30);
        
    }
    
    public ArrayList<LevelModel>  getLevels()
    {
        return levels;
    }
    
}
