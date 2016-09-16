/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

import Models.LevelModel;
import javafx.scene.layout.GridPane;

/**
 *
 * @author tibor.wekerle
 */
public class LevelView extends GridPane{
    private LevelModel level=null;
    private GridPane grid=new GridPane();
    
    public LevelView(LevelModel level)
    {
        this.level=level;
        populateContent();
    }
    
    private void populateContent()
    {
        char[][] matrix=level.getMatrix();
        int height=matrix.length;
        int width=matrix[0].length;
        
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
                switch(matrix[i][j])
                {
                    case '#':
                        break;
                    case 'a':
                        break;
                    case 'b':
                        break;
                }
            }
        }
    }
}
