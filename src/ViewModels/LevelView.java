/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

import Models.LevelModel;
import javafx.animation.RotateTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

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
        
        int i=0,j=0;
        for(i=0;i<height;i++)
        {
            for(j=0;j<width;j++)
            {
                //# -fal
                //a -alkololista
                //b -nem alkoholista
                //c -vas lada
                //d -fa lada
                //e -bomba
                //f -tuskek
                switch(matrix[i][j])
                {
                    case '#':
                        Image imageWall=new Image("/img/wall.png");
                        ImageView imageViewWall = new ImageView();
                        imageViewWall.setImage(imageWall);
                        grid.add(imageViewWall,j,i);
                        break;
                    case 'a':
                        Image imageZombie=new Image("/img/zombie.png");
                        ImageView imageViewZombie = new ImageView();
                        imageViewZombie.setImage(imageZombie);
                        grid.add(imageViewZombie,j,i);
                        break;
                    case 'b':
                        Image imagePeople=new Image("/img/people.png");
                        ImageView imageViewPeople = new ImageView();
                        imageViewPeople.setImage(imagePeople);
                        grid.add(imageViewPeople,j,i);
                        break;
                    case 'c':
                        Image imageMetalBox=new Image("/img/metalBox.jpg");
                        ImageView imageViewMetalBox = new ImageView();
                        imageViewMetalBox.setImage(imageMetalBox);
                        grid.add(imageViewMetalBox,j,i);
                        break;
                    case 'd':
                        Image imageWoodBox=new Image("/img/woodBox.png");
                        ImageView imageViewWoodBox = new ImageView();
                        imageViewWoodBox.setImage(imageWoodBox);
                        grid.add(imageViewWoodBox,j,i);
                        break;
                    case 'e':
                        Image imageBomb=new Image("/img/bomb.png");
                        ImageView imageViewBomb = new ImageView();
                        imageViewBomb.setImage(imageBomb);
                        grid.add(imageViewBomb,j,i);
                        break;
                    case 'f':
                        Image imageSpikes=new Image("/img/spikes.png");
                        ImageView imageViewSpikes = new ImageView();
                        imageViewSpikes.setImage(imageSpikes);
                        grid.add(imageViewSpikes,j,i);
                        break;
                }
            }
        }
        Image imageRotLeft=new Image("/img/rotLeft.png");
        Button buttonRotLeft=new Button();
        buttonRotLeft.setGraphic(new ImageView(imageRotLeft));
        
        Image imageRotRight=new Image("/img/rotRight.png");
        Button buttonRotRight=new Button();
        buttonRotRight.setGraphic(new ImageView(imageRotRight));
        
        buttonRotRight.setOnMouseClicked(new EventHandler<MouseEvent>()
        {

            @Override
            public void handle(MouseEvent event) {
                RotateTransition rt = new RotateTransition(Duration.millis(3000), LevelView.this.grid);
                rt.setFromAngle(0);
                rt.setToAngle(360);
                rt.setCycleCount(2);
                rt.setAutoReverse(true);

                rt.play();
            }
        });
        
        buttonRotLeft.setOnMouseClicked(new EventHandler<MouseEvent>()
        {

            @Override
            public void handle(MouseEvent event) {
               LevelView.this.grid.setRotate(-90);
            }
        });
        
        HBox hb= new HBox();
        hb.getChildren().add(buttonRotLeft);
        hb.getChildren().add(buttonRotRight);
        
        hb.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        this.add(grid,0,0);
        this.add(hb,0,1);

    }
}
