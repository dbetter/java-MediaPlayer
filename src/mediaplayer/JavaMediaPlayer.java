/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mediaplayer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author danie_000
 */
public class JavaMediaPlayer extends Application {
    
    @Override
    public void start(Stage primaryStage) {
     
        try {
            Player player = new Player("file:///C:/TestVideo.mp4");
            Scene scene = new Scene(player, 720, 510, Color.BLACK);
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
