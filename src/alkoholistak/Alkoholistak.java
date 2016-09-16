/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alkoholistak;

import Helpers.StringHelper;
import Models.AplicationModel;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author tibor.wekerle
 */
public class Alkoholistak extends Application {
    
    private BorderPane borderPane = new BorderPane();
    private AplicationModel aplicationModel=new AplicationModel();
    private Scene scene=new Scene(borderPane);
    private byte[] aplicationModelSerialized;
    private Stage stage=null;
    
    @Override
    public void start(Stage primaryStage) 
    {
        
        MenuBar menuBar=createMenu();       
        borderPane.setTop(menuBar);                 
        borderPane.setCenter(addAnchorPane(addGridPane()));
        stage=primaryStage;
    
        scene.getStylesheets().add("Styling/styles.css");
                                                     
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        
        primaryStage.setTitle("IEEE Conference Manager");
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
        
        MenuItem newMenuItem = new MenuItem("Home");
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

        menuFile.getItems().addAll(newMenuItem,loadMenuItem, saveMenuItem,
        new SeparatorMenuItem(), exitMenuItem);
        
        newMenuItem.setOnAction(actionEvent -> clickNew());
        saveMenuItem.setOnAction(actionEvent -> clickSave());
        loadMenuItem.setOnAction(actionEvent -> clickLoad());
                      
        menuBar.getMenus().addAll(menuFile);
                  
        return menuBar;

    }
    
    private void clickNew()
    {
        int numberOfDays=2;
        int deafultBreakDuration=5;
        
        ButtonType buttonTypeNext = new ButtonType("Next", ButtonBar.ButtonData.NEXT_FORWARD);
        ButtonType buttonCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        Optional<ButtonType> result;
        Dialog dialog = new Dialog<>();

        dialog.setHeaderText("Insert deafult break duration:");
        dialog.getDialogPane().setPrefSize(200, 150);
        
        dialog.getDialogPane().getButtonTypes().add(buttonTypeNext);
        dialog.getDialogPane().getButtonTypes().add(buttonCancel);

        result = dialog.showAndWait();

        
        setAplicationModelSerialized();       
        start(stage);      
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
        
    private GridPane addGridPane() 
    {
        GridPane grid = new GridPane();   
        grid.getStyleClass().add("grid");

        Text title = new Text("Să începem jocul");
        title.setFont(StringHelper.font20Bold);
        grid.add(title, 1, 0); 
                
        Text chartSubtitle = new Text("În acest joc trebuie să faceți să ajungă băutura la toți din gască. Trebuie să rotiți în stânga și în dreapta structura.\n"
                + "Pentru acesta trebuie să dați cu mouse-ul click pe care dintre săgeți. Puteți face save, și ziua următoare să continuți de unde ați rămas.");
        grid.add(chartSubtitle, 1, 1, 2, 1);
              
        return grid;
    }
 
    private AnchorPane addAnchorPane(GridPane grid) 
    {
        AnchorPane anchorpane = new AnchorPane();
        anchorpane.getStyleClass().add("pane");
        
        anchorpane.getChildren().add(grid);
        AnchorPane.setTopAnchor(grid, 10.0);

        return anchorpane;
    }
    
}
