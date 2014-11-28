package mediaplayer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

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
    
    public MediaBar(MediaPlayer play) {
        this.player = play;
       
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
        
        playButton.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent e) {
                Status status = player.getStatus();
                if (status == Status.PLAYING){
                    if (player.getCurrentTime().greaterThanOrEqualTo(player.getTotalDuration())){
                        // we've reached the end of the video, so we'll play the video again (repeat) 
                        player.seek(player.getStartTime());
                        player.play();
                        
                        //another option is to shut down the player
                        // player.stop();
                    } else{
                        player.pause();
                        playButton.setText(">");
                    }
                } else if (status == Status.HALTED || status == Status.PAUSED || status == Status.STOPPED){
                    playButton.setText("||");
                    player.play();
                    
                }
            }
        });
    }
    
    
}
