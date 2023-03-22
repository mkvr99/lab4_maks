package com.example.lab4;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import packege.ImageCollection;
import packege.Iterator;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public Timeline timeline = new Timeline();
    public ImageCollection imgs = new ImageCollection("img");
    public Iterator iter_main = imgs.getIterator();
    public ImageView imageView;
    public TextField textField;

    public int i = 2000;

    @FXML
    public void onHelloButtonClick(ActionEvent event) { imageView.setImage((Image) iter_main.next()); }
    @FXML
    public void onButton2(ActionEvent event) {
        imageView.setImage((Image) iter_main.preview());
    }

    public void onStart(ActionEvent event) {
        timeline.play();
    }

    public void onStop(ActionEvent event) {
        timeline.stop();
    }

    public void onPause(ActionEvent event) {
        timeline.pause();
    }


    public void onSetTime(ActionEvent event) {
        i = Integer.parseInt(textField.getText());
        timeline.setCycleCount(i);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeline.setCycleCount(Timeline.INDEFINITE); //кол-во повторов
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(i), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (iter_main.hasNext(1))
                    imageView.setImage((Image) iter_main.next());
            }
        }));
    }
}
