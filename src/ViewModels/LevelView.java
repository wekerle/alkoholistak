/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

import Models.LevelModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        
        //Button buttonAdd=new Button();
        //buttonAdd.setGraphic(new ImageView(imageAdd));
        
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
                //# -fal
                //a -alkololista
                //b -nem alkoholista
                //b -vas lada
                switch(matrix[i][j])
                {
                    case '#':
                        Image imageWall=new Image("/img/wall.png");
                        ImageView iv1 = new ImageView();
                        iv1.setImage(imageWall);
                        grid.add(iv1,j,i);
                        break;
                    case 'a':
                        break;
                    case 'b':
                        break;
                }
            }
        }
        this.getChildren().add(grid); 
    }
}
