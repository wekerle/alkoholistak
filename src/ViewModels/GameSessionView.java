/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

import Models.GameObject;
import Models.GameSession;
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
public class GameSessionView extends GridPane{
    private GridPane grid=new GridPane();
    private RotateTransition rt = new RotateTransition(Duration.millis(500), GameSessionView.this.grid);
    private int fromAngel = 0;
    private int toAngel = 0;
    private GameSession gameSession=null;
    
    public GameSessionView(GameSession gameSession)
    {
        this.gameSession=gameSession;
        populateContent();
    }
    
    private void populateContent()
    {
        grid.getChildren().clear();
        int height=gameSession.getHeight();
        int width=gameSession.getWidth();
        
        int i=0,j=0;
        for(i=0;i<height;i++)
        {
            for(j=0;j<width;j++)
            {                
                ImageView imageView = new ImageView();
                GameObject gameObject=gameSession.getGameObjectAt(i, j);
                
                if(gameObject!=null)
                {
                    imageView.setImage(gameSession.getGameObjectAt(i, j).getImage());
                }
                
                grid.add(imageView,j,i);
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
              //  for(ImageView imageNode:gravityNodes)
               // {
                    /*TranslateTransition tt = new TranslateTransition(Duration.millis(2000), imageNode);
                    tt.setFromX(imageNode.getX());
                    tt.setToX(imageNode.getX()+100);
                    tt.setCycleCount(4);
                    tt.setAutoReverse(true);

                    tt.play(); */
                    
                  //  TranslateTransition tt = new TranslateTransition(Duration.millis(2000), imageNode);
                  //  double fromX=imageNode.getX();
                  //  double toX=fromX+50;
                  //  tt.setFromX(fromX);
                   // tt.setToX(toX);
                  //  tt.setCycleCount(4);
                  //  tt.setAutoReverse(true);
                  //  tt.play(); 
               // }             
            }
        });

    }
    
    private void rotateLeft()
    {
       // int oldHeight=matrix.length;
        //int oldWidth=matrix[0].length;
        //char[][] newMatrix= new char[oldWidth][oldHeight];
        
       // for(int i=0;i<oldHeight;i++)
       // {
          //  for(int j=0;j<oldWidth;j++)
          //  {
                //newMatrix[i][j]=matrix[j][oldWidth-i-1];
          //  }
      //  }
       // matrix=newMatrix;
    }
    
    private void rotateRight()
    {
        
    }
}
