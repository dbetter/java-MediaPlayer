package mediaplayer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie_000
 */
public class MediaBar extends HBox {
    
    Slider volume = new Slider();
    Slider time = new Slider();

    Button playButton = new Button("||");
    Label volumeSlider = new Label("Volume:");
    
    MediaPlayer player;
    
    public MediaBar(MediaPlayer player) {
        this.player = player;
        
        setAlignment(Pos.CENTER);
        setPadding(new Insets(5,10,5,10));
        
        volume.setPrefWidth(70);
        volume.setMinWidth(30);
        volume.setValue(100);   // default player volume
        
        HBox.setHgrow(time, Priority.ALWAYS);
        
        playButton.setPrefWidth(30);
        
        getChildren().add(playButton);
        getChildren().add(time);
        getChildren().add(volumeSlider);
        getChildren().add(volume);
    }
    
    
}
