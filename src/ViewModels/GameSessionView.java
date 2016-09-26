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
import Models.NextStepSimulateModel;
import Models.Tuske;
import Models.VasLada;
import java.util.HashMap;
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
    private int fromAngel=0,toAngel = 0,height=0,width;
    private GameSession gameSession=null;
    Enums.GravitacioIranya gravitacioIranya=Enums.GravitacioIranya.Le;
    private HashMap<GameObject,ImageView> gameObjectImageViewMap=new HashMap<GameObject,ImageView>();
    
    public GameSessionView(GameSession gameSession)
    {
        this.gameSession=gameSession;
        populateContent();
    }
    
    private void populateContent()
    {
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
                }
                grid.add(imageView,j,i);
                gameObjectImageViewMap.put(gameObject, imageView);
            }
        }
        Image imageRotLeft=new Image("/img/rotLeft.png");
        Button buttonRotLeft=new Button();
        buttonRotLeft.setGraphic(new ImageView(imageRotLeft));
        
        Image imageRotRight=new Image("/img/rotRight.png");
        Button buttonRotRight=new Button();
        buttonRotRight.setGraphic(new ImageView(imageRotRight));
        
        //ez a gomb csak teszt
        Button buttonTeszt=new Button();
        buttonTeszt.setText("teszt");
        
        buttonTeszt.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event) {
                grid.getChildren().clear();  
                GameSessionView.this.getChildren().clear();
                populateContent();
            }
            
        });
        
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
                        gravitacioIranya=gravitacioIranya.Fel;
                        break;
                    case Ballra:
                        gravitacioIranya=gravitacioIranya.Le;
                        break;
                } 
                
                buttonRotLeft.setDisable(true);
                buttonRotRight.setDisable(true);
            }
        });
        
        buttonRotLeft.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event) {
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
                        gravitacioIranya=gravitacioIranya.Le;
                        break;
                    case Ballra:
                        gravitacioIranya=gravitacioIranya.Fel;
                        break;
                }
                buttonRotLeft.setDisable(true);
                buttonRotRight.setDisable(true);
            }
        });
        
        HBox hb= new HBox();
        hb.getChildren().add(buttonRotLeft);
        hb.getChildren().add(buttonRotRight);
        hb.getChildren().add(buttonTeszt);
        
        hb.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        this.add(grid,0,0);
        this.add(hb,0,1);
        rt.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                while(gameSession.hasObjectWichCanFall(gravitacioIranya))
                {
                    for(int i=0;i<height;i++)
                    {
                        for(int j=0;j<width;j++)
                        {                
                            GameObject gameObject=gameSession.getGameObjectAt(i, j);
                            if(gameObject.canFall())
                            {                        
                                ImageView currentImageView=gameObjectImageViewMap.get(gameObject);
                                TranslateTransition tt = new TranslateTransition(Duration.millis(1000),currentImageView );

                                int numberOfStepsI=gameObject.getNumberOfStepsI(gravitacioIranya,i,j);
                                int numberOfStepsJ=gameObject.getNumberOfStepsJ(gravitacioIranya,i,j);

                                if(numberOfStepsJ !=0 && (gravitacioIranya==Enums.GravitacioIranya.Ballra || gravitacioIranya==Enums.GravitacioIranya.Jobbra))
                                {
                                    gameObject.setToX(gameObject.getFromX()+numberOfStepsJ*50);
                                    tt.setFromX(gameObject.getFromX());
                                    tt.setToX(gameObject.getToX());
                                    gameObject.setFromX(gameObject.getToX());
                                }else if(numberOfStepsI !=0 && (gravitacioIranya==Enums.GravitacioIranya.Fel || gravitacioIranya==Enums.GravitacioIranya.Le))
                                {
                                    gameObject.setToY(gameObject.getFromY()+numberOfStepsI*50);
                                    tt.setFromY(gameObject.getFromY());
                                    tt.setToY(gameObject.getToY());
                                    gameObject.setFromY(gameObject.getToY());
                                }

                                    tt.setCycleCount(1);
                                    tt.play();

                                gameSession.addNextStepSimulateModel(new NextStepSimulateModel(i, j, numberOfStepsI, numberOfStepsJ));
                            }
                        }
                    }

                    gameSession.simulateNextStep();
                    gameSession.clearNextStepSimulateModel();
                }
                
                buttonRotLeft.setDisable(false);
                buttonRotRight.setDisable(false);
            }
        });

    }
}
