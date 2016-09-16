/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alkoholistak;

import Listener.LevelClickEventListener;
import Models.AplicationModel;
import Models.LevelModel;
import ViewModels.LevelView;
import ViewModels.MinimalLevelView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author tibor.wekerle
 */
public class Alkoholistak extends Application implements LevelClickEventListener
{   
    private BorderPane borderPane = new BorderPane();
    private AplicationModel aplicationModel=new AplicationModel();
    private Converter converter = new Converter();
    private Scene scene=new Scene(borderPane);
    private byte[] aplicationModelSerialized;
    private Stage stage=null;
    
    @Override
    public void start(Stage primaryStage) 
    {
        DataCollector dataCollector=new DataCollector();
        aplicationModel.setLevels(dataCollector.getLevels());
        
        MenuBar menuBar=createMenu();       
        borderPane.setTop(menuBar);                 
        borderPane.setCenter(getContent());
        stage=primaryStage;
    
        scene.getStylesheets().add("Styling/styles.css");
                                                     
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        
        primaryStage.setTitle("Alkoholistak");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        stage.setOnCloseRequest(confirmCloseEventHandler);
                
        Parameters params = getParameters();
        List<String> parameters=params.getRaw();
        
        if(parameters.size()>0)
        {
            this.aplicationModel=fileToAplicationModel(parameters.get(0));
        }
    }
    
    private EventHandler<WindowEvent> confirmCloseEventHandler = event -> 
    {
        boolean hasModification=false;
        try
        {
           ByteArrayOutputStream bos=new ByteArrayOutputStream();
           ObjectOutputStream memeoryOutStream = new ObjectOutputStream(bos);
           memeoryOutStream.writeObject(aplicationModel);
            
           byte[] data=bos.toByteArray();
           memeoryOutStream.close();
           bos.close();
           
           if(data.length!=aplicationModelSerialized.length)
           {
               hasModification=true;
           }else
           {
               for(int i=0;i<data.length;i++)
               {
                   if(data[i]!=aplicationModelSerialized[i])
                   {
                       hasModification=true;
                       break;
                   }
               }
           }
               

        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        
        if(hasModification)
        {
            Alert closeConfirmation = new Alert(
                Alert.AlertType.CONFIRMATION,                
                        "Press Exit to close the application, or press Cancel to say on and go to save it."
            );
            Button exitButton = (Button) closeConfirmation.getDialogPane().lookupButton(
                    ButtonType.OK
            );
            exitButton.setText("Exit");
            closeConfirmation.setHeaderText(" You have some unsaved changes that will be lost if you decide to exit.\n Are you sure you want to exit?\n");
            closeConfirmation.initModality(Modality.APPLICATION_MODAL);
            closeConfirmation.initOwner(stage);

            Optional<ButtonType> closeResponse = closeConfirmation.showAndWait();
            if (!ButtonType.OK.equals(closeResponse.get())) 
            {
                event.consume();
            }
        }
        
    };

    
    /**
     * @param args the command line arguments
     */
         
    public static void main(String[] args)throws Exception 
    {
        launch(args);
    }
    
    
    private MenuBar createMenu()
    { 
        MenuBar menuBar = new MenuBar();
 
        // --- Menu File
        Menu menuFile = new Menu("Menu");
        
        MenuItem homeMenuItem = new MenuItem("Home");
        MenuItem loadMenuItem = new MenuItem("Load");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(actionEvent ->
                stage.fireEvent(
                        new WindowEvent(
                                stage,
                                WindowEvent.WINDOW_CLOSE_REQUEST
                        )
                ));

        menuFile.getItems().addAll(homeMenuItem,loadMenuItem, saveMenuItem,
        new SeparatorMenuItem(), exitMenuItem);
        
        homeMenuItem.setOnAction(actionEvent -> clickHome());
        saveMenuItem.setOnAction(actionEvent -> clickSave());
        loadMenuItem.setOnAction(actionEvent -> clickLoad());
                      
        menuBar.getMenus().addAll(menuFile);
                  
        return menuBar;

    }
    
    private void clickHome()
    {              
        setAplicationModelSerialized();       
        start(stage);      
    }
    
    private void renderLevel(LevelModel level)
    {
        LevelView levelView=new LevelView(level);
        borderPane.setCenter(levelView);      
    }
    
    private void setAplicationModelSerialized()
    {
        try
        {   
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            ObjectOutputStream memeoryOutStream = new ObjectOutputStream(bos);
            memeoryOutStream.writeObject(aplicationModel);
            aplicationModelSerialized=bos.toByteArray();
            
            memeoryOutStream.close();
            bos.close();
        }catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
     private void clickSave()
     {       
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save IEEE Conference");

        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("ser", "*.ser")
        );

        File file = fileChooser.showSaveDialog(stage);
        if (file != null) 
        {
            try 
            {
                String path=file.getPath();

                FileOutputStream fileOut = new FileOutputStream(path);
                                
                ObjectOutputStream fileOutStream = new ObjectOutputStream(fileOut);
                              
                fileOutStream.writeObject(aplicationModel);
                fileOutStream.close();
                
                fileOut.close();              
                
            } catch (IOException ex) 
            {
                System.out.println(ex.getMessage());
            }
        }      
    }
     
    private void clickLoad()
    {       
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load IEEE Conference");

        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("ser", "*.ser")
        );
        File file = fileChooser.showOpenDialog(stage);
        
        if(file!=null)
        {
            this.aplicationModel=fileToAplicationModel(file.getPath()); 
        } 
        setAplicationModelSerialized();
        start(stage);
    }
    
    private AplicationModel fileToAplicationModel(String path)
    {
        try
        {
           FileInputStream fileIn = new FileInputStream(path);
           ObjectInputStream in = new ObjectInputStream(fileIn);
           aplicationModel = (AplicationModel) in.readObject();

           in.close();
           fileIn.close();
           return aplicationModel;
        }catch(IOException i)
        {
           i.printStackTrace();
           return null;
        }catch(ClassNotFoundException c)
        {
           System.out.println("Employee class not found");
           c.printStackTrace();
           return null;
        }
    }
        
    private GridPane getContent() 
    {
        GridPane grid = new GridPane();   
        
        int i=1;
        for(LevelModel level :aplicationModel.getLevels())
        {
            MinimalLevelView minimalLevel= new MinimalLevelView(level.getLevelId(), level.getLevelNumber());
            minimalLevel.setLevelClickEventListener(this);
            
            grid.add(minimalLevel,i+1,i+1);
            i++;
        }
        return grid;
    }

    @Override
    public void levelSelected(int levelId) 
    {
        renderLevel(aplicationModel.getLevelById(levelId));
    }    
}
