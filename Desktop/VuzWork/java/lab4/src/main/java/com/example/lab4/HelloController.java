package com.example.lab4;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import packege.ImageCollection;
import packege.Iterator;

import java.time.Duration;

public class HelloController {
    public Timeline timeline =new Timeline();
    public ImageCollection imgs = new ImageCollection("img");
    public Iterator iter_main = imgs.getIterator();
    public ImageView imageView;
    @FXML
    public void onHelloButtonClick(ActionEvent event) {
        timeline.setCycleCount(Timeline.INDEFINITE);
       imageView.setImage((Image) iter_main.next());
    }
    @FXML
    public void onButton2(ActionEvent event) {
        imageView.setImage((Image) iter_main.preview());
    }
}
