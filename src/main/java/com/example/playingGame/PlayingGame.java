package com.example.playingGame;

import com.example.Players.Player;
import com.example.cards.Card;
import com.example.figures.Figure;
import com.example.projekatDiamondCircle.DiamondCircleController;
import com.example.startData.MatrixField;
import com.example.startData.StartData;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


import java.util.List;

import static com.example.projekatDiamondCircle.StartDataController.diamondCircleController;

public class PlayingGame extends Thread {
    public List<Player> players = DiamondCircleController.listOfPlayers;
    private Player currentPlayer;
    public int fieldCounter = 0;
    public int cardFieldCounter = 0;

    public void setNewCard() {
        Platform.runLater(() -> {
            diamondCircleController.displayCard();
            cardFieldCounter = 0;
        });
    }

    @Override
    public void run() {
        while (isAlive()) {
            Card currentCard = diamondCircleController.displayCard();
            Figure currentFigure =
            int numberOfMoves =
                synchronized (DiamondCircleController.fieldMatrix) {
                    try {
                        if (!DiamondCircleController.buttonFlag) {
                            DiamondCircleController.fieldMatrix.wait();
                        }

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

    public Player getPlayer() {
        Player player = players.get(0);
        players.remove(0);
        players.add(player);
        return player;
    }
}


