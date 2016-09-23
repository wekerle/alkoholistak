/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

import Helpers.Enums;
import Models.Alkoholista;
import Models.Bomba;
import Models.GameObject;
import Models.GameSession;
import Models.NemAlkoholista;
import Models.Tuske;
import Models.VasLada;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
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
    private int fromAngel=0,toAngel = 0,height=0,width;
    private GameSession gameSession=null;
    Enums.GravitacioIranya gravitacioIranya=Enums.GravitacioIranya.Le;
    private HashMap<GameObject,ImageView> gameObjectImageViewMap=new HashMap<GameObject,ImageView>();
    private ArrayList<ImageView> gravityNodes=new ArrayList<ImageView>();
    
    public GameSessionView(GameSession gameSession)
    {
        this.gameSession=gameSession;
        populateContent();
    }
    
    private void populateContent()
    {
        grid.getChildren().clear();
        height=gameSession.getHeight();
        width=gameSession.getWidth();
        
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {                
                ImageView imageView = new ImageView();
                GameObject gameObject=gameSession.getGameObjectAt(i, j);
                
                if(gameObject!=null)
                {
                    imageView.setImage(gameSession.getGameObjectAt(i, j).getImage());
                    //csak test
                    if(gameObject instanceof Alkoholista || gameObject instanceof NemAlkoholista)
                    {
                        gravityNodes.add(imageView);
                    }
                }
                grid.add(imageView,j,i);
               // imageView.setX(i*50);
               // imageView.setY(j*50);
                gameObjectImageViewMap.put(gameObject, imageView);
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
                
                switch(gravitacioIranya)
                {
                    case Fel:
                        gravitacioIranya=gravitacioIranya.Ballra;
                        break;
                    case Le:
                        gravitacioIranya=gravitacioIranya.Jobbra;
                        break;
                    case Jobbra:
                        gravitacioIranya=gravitacioIranya.Le;
                        break;
                    case Ballra:
                        gravitacioIranya=gravitacioIranya.Fel;
                        break;
                }
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
                
                switch(gravitacioIranya)
                {
                    case Fel:
                        gravitacioIranya=gravitacioIranya.Jobbra;
                        break;
                    case Le:
                        gravitacioIranya=gravitacioIranya.Ballra;
                        break;
                    case Jobbra:
                        gravitacioIranya=gravitacioIranya.Fel;
                        break;
                    case Ballra:
                        gravitacioIranya=gravitacioIranya.Le;
                        break;
                }
            }
        });
        
        HBox hb= new HBox();
        hb.getChildren().add(buttonRotLeft);
        hb.getChildren().add(buttonRotRight);
        
        hb.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        this.add(grid,0,0);
        this.add(hb,0,1);
        rt.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                for(int i=0;i<height;i++)
                {
                    for(int j=0;j<width;j++)
                    {                
                        GameObject gameObject=gameSession.getGameObjectAt(i, j);
                        
                        if(gameObject instanceof Alkoholista 
                            || gameObject instanceof NemAlkoholista)
                           // || gameObject instanceof VasLada
                           // || gameObject instanceof Tuske
                           // || gameObject instanceof Bomba)
                        {
                            GameObject nextObject=gameSession.getGameObjectAt(gameObject.getNextI(gravitacioIranya),gameObject.getNextJ(gravitacioIranya));
                            double nextX=gameObjectImageViewMap.get(nextObject).getLayoutX();
                            double nextY=gameObjectImageViewMap.get(nextObject).getLayoutY();
                            
                            ImageView currentImageView=gameObjectImageViewMap.get(gameObject);
                            TranslateTransition tt = new TranslateTransition(Duration.millis(2000),currentImageView );
                            if(gravitacioIranya==Enums.GravitacioIranya.Ballra || gravitacioIranya==Enums.GravitacioIranya.Jobbra)
                            {
                                tt.setFromX(currentImageView.getLayoutX());
                                tt.setToX(nextX);
                            }else
                            {
                                tt.setFromY(currentImageView.getLayoutY());
                                tt.setToY(nextY);
                            }
                            
                            tt.setCycleCount(1);
                            tt.play();
                            
                            gameObject.simulateNextStep(gravitacioIranya);
                            
                            /* TranslateTransition tt2 = new TranslateTransition(Duration.millis(2000),currentImageView );
                            tt2.setFromX(currentImageView.getY());
                            tt2.setToX(nextY);
                            tt2.setCycleCount(1);
                            tt2.play();*/
                        }
                    }
                }
               // populateContent();
               for(ImageView imageNode:gravityNodes)
                {
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
                }             
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
