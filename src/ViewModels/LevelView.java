/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

import Models.LevelModel;
import java.util.ArrayList;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
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
    private RotateTransition rt = new RotateTransition(Duration.millis(1000), LevelView.this.grid);
    private int fromAngel = 0;
    private int toAngel = 0;
    private ArrayList<ImageView> gravityNodes=new ArrayList<ImageView>();
    private char[][] matrix=null;
    
    public LevelView(LevelModel level)
    {
        this.level=level;
        this.matrix=level.getMatrix();
        populateContent();
    }
    
    private void populateContent()
    {
        grid.getChildren().clear();
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
                        gravityNodes.add(imageViewZombie);
                        break;
                    case 'b':
                        Image imagePeople=new Image("/img/people.png");
                        ImageView imageViewPeople = new ImageView();
                        imageViewPeople.setImage(imagePeople);
                        
                        grid.add(imageViewPeople,j,i);
                        gravityNodes.add(imageViewPeople);
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
                fromAngel=toAngel;
                toAngel+=90;
                rt.setFromAngle(fromAngel);
                rt.setToAngle(toAngel);
                rt.setCycleCount(1);
                rt.play();
            }
        });
        
        buttonRotLeft.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event) {
                rotateLeft();
                fromAngel=toAngel;
                toAngel-=90;
                rt.setFromAngle(fromAngel);
                rt.setToAngle(toAngel);
                rt.setCycleCount(1);
                rt.play();
            }
        });
        
        HBox hb= new HBox();
        hb.getChildren().add(buttonRotLeft);
        hb.getChildren().add(buttonRotRight);
        
        hb.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        this.add(grid,0,0);
        this.add(hb,0,1);
       // grid.getChildren().
        rt.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                
               // populateContent();
                for(ImageView imageNode:gravityNodes)
                {
                    /*TranslateTransition tt = new TranslateTransition(Duration.millis(2000), imageNode);
                    tt.setFromX(imageNode.getX());
                    tt.setToX(imageNode.getX()+100);
                    tt.setCycleCount(4);
                    tt.setAutoReverse(true);

                    tt.play(); */
                    
                    TranslateTransition tt = new TranslateTransition(Duration.millis(2000), imageNode);
                    double fromX=imageNode.getX();
                    double toX=fromX+50;
                    tt.setFromX(fromX);
                    tt.setToX(toX);
                    tt.setCycleCount(4);
                    tt.setAutoReverse(true);
                    tt.play(); 
                }             
            }
        });

    }
    
    private void rotateLeft()
    {
        int oldHeight=matrix.length;
        int oldWidth=matrix[0].length;
        char[][] newMatrix= new char[oldWidth][oldHeight];
        
        for(int i=0;i<oldHeight;i++)
        {
            for(int j=0;j<oldWidth;j++)
            {
                //newMatrix[i][j]=matrix[j][oldWidth-i-1];
            }
        }
       // matrix=newMatrix;
    }
    
    private void rotateRight()
    {
        
    }
}
