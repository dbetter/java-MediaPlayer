/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mediaplayer;

import java.io.File;
import java.net.MalformedURLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author danie_000
 */
public class JavaMediaPlayer extends Application {
    
    Player player;
    FileChooser fileChooser = new FileChooser();
    
    @Override
    public void start(final Stage primaryStage) {
     
        try {
            
            /* The proper hierarchy between MenuItem, Menu and MenuBar is the following:
                Each Menu, contais several MenuItems
                One MenuBar, contains several Menu's 
            */
            MenuItem open = new MenuItem("Open");
            Menu file = new Menu("File");
            MenuBar menu = new MenuBar();
                    
            file.getItems().add(open);
            menu.getMenus().add(file);
            
            open.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    player.player.pause();
                    File file = fileChooser.showOpenDialog(primaryStage);
                    if (file != null){
                        try{
                            player = new Player(file.toURI().toURL().toExternalForm());
                            Scene scene = new Scene(player, 720, 535, Color.BLACK);
                            primaryStage.setScene(scene);
                        } catch (MalformedURLException e){
                            // handle later
                        }
                                    
                    }
                }
            });
            
            player = new Player("file:///C:/TestVideo.mp4");
            player.setTop(menu);
            Scene scene = new Scene(player, 720, 535, Color.BLACK);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            
        }
        
       
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
