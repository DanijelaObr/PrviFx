package com.example.gameDuration;

import com.example.projekatDiamondCircle.DiamondCircleController;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class GameDuration extends Thread {
    Label gameTime = new Label();
    String gameTimeMessage = "Vrjeme trajanja igre: ";
    static int i = 0;

    public GameDuration(Label gameTime) {
        this.gameTime = gameTime;
    }

    @Override
    public void run() {
        while (isAlive()) {
            System.out.println("Game Duration "+ DiamondCircleController.buttonFlag);
            synchronized (DiamondCircleController.fieldMatrix) {
                try {
                    if(!DiamondCircleController.buttonFlag){
                    DiamondCircleController.fieldMatrix.wait();}
                    Platform.runLater(() -> {
                        gameTime.setText(gameTimeMessage + i++ + "s");
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
