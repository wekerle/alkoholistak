/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

import Listener.LevelClickEventListener;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 *
 * @author tibor.wekerle
 */
public class MinimalLevelView extends HBox{
    private int levelId;
    private int levelNumber;
    private LevelClickEventListener levelClickEvent=null;

    public void setLevelClickEventListener(LevelClickEventListener levelClickEvent) 
    {
        this.levelClickEvent = levelClickEvent;
    }
    
    public MinimalLevelView(int levelId,int levelNumber)
    {
        this.levelId=levelId;
        this.levelNumber=levelNumber;
        populateContent();
        
        this.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                MinimalLevelView.this.levelClickEvent.levelSelected(levelId);
            }
        });
    }
    
    private void populateContent()
    {
        this.getStyleClass().add("minimalLevelView");
        Text levelNumberText=new Text(Integer.toString(levelNumber));
        this.getChildren().add(levelNumberText);
    }
}
