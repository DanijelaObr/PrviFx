package com.example.projekatDiamondCircle;


import com.example.Players.GeneratePlayersAndFigures;
import com.example.Players.Player;
import com.example.cards.Card;
import com.example.cards.CardDeck;
import com.example.figures.Figure;
import com.example.gameDuration.GameDuration;
import com.example.ghost.GhostDiamond;
import com.example.playingGame.PlayingGame;
import com.example.startData.MatrixField;
import com.example.startData.StartData;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class DiamondCircleController implements Initializable {
   public static CardDeck cardDeck = new CardDeck();
    public static boolean buttonFlag = false;
    public static int counter = 0;
    public static int numberOfMoves = 0;
    public static boolean newCardFlag = false;

    @FXML
    private Label numberOfGames;
    public Label player1;
    public Label player2;
    public Label player3;
    public Label player4;
    public Label gameTime;
    @FXML
    public ImageView cardView = new ImageView();
    @FXML
    private GridPane mainMatrix;
    public static MatrixField[][] fieldMatrix = new MatrixField[][]{};
    private Pane[][] paneArray;
    private List<Pane> paneList;
    public static List<String> gradation = new ArrayList<>();
    public static List<Player> listOfPlayers = new ArrayList<>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paneList = new ArrayList<>();
        paneArray = new Pane[10][10];
        createMainMatrix(StartData.getMatrixDimensions(), StartData.getNumberOfPlayers());
        try {
           listOfPlayers = GeneratePlayersAndFigures.generatePlayersAndFigures(Integer.parseInt(StartData.getNumberOfPlayers()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleStartBtnClick(int numberOfColumns) {
        System.out.println("PRESSED");
        String whiteStyle = "-fx-background-color: white;" + "-fx-border-color: gray;";
        fieldMatrix = new MatrixField[numberOfColumns][numberOfColumns];
        StartData.setAllowedMatrixFields(numberOfColumns);
//        System.out.println(StartData.getMatrixAvailableFields());
        int r = 255, g = 215, b = 0;
        for (int br = 0; br < StartData.getMatrixAvailableFields().size(); br++) {
            for (int i = 0; i < numberOfColumns; i++) {
                for (int j = 0; j < numberOfColumns; j++) {

                    String greyStyle = "-fx-background-color: rgb( " + r + "," + g + "," + b + ");" + "-fx-border-color: black;";
                    MatrixField pane = new MatrixField();

                    pane.setPrefWidth(10000.0 / numberOfColumns);
                    pane.setPrefHeight(10000.0 / numberOfColumns);

                    if (StartData.getMatrixAvailableFields().get(br).getFieldId() != -1) {
                        if (StartData.getMatrixAvailableFields().get(br).getX() == i && StartData.getMatrixAvailableFields().get(br).getY() == j) {
                            pane.setStyle(greyStyle);
                            gradation.add(greyStyle);
                        }
                    } else {
                        pane.setStyle(whiteStyle);
                    }
                    fieldMatrix[i][j] = pane;
                    mainMatrix.add(pane, j, i);
                }
            }
            r -= 2;
            g -= 5;
        }
    }

    public void numberOfGames(String broj) {
        numberOfGames.setText("Trenutni broj odigranih igara: " + broj);
    }

    public void createMainMatrix(int dimensions, String players) {
        int matrix = dimensions;
        int numOfPlayers = Integer.parseInt(players);

        Label labels[] = {player1, player2, player3, player4};
        Color colors[] = {Color.RED, Color.BLUE, Color.GOLD, Color.GREEN};

        //Drawing matrix depending on input
        handleStartBtnClick(matrix);
//        displayCard();

        //Setting the default color for non-active players
        for (int i = 0; i < 4; i++) {
            labels[i].setTextFill(Color.LIGHTGREY);
        }

        //Setting color for active players
        for (int i = 0; i < numOfPlayers; i++) {
            labels[i].setTextFill(colors[i]);
        }
    }

    public Card displayCard() {
        Card cardForDisplay = cardDeck.getCardDeck().get(0);
        File img = new File(cardForDisplay.getCardImage());
        Image image = new Image(img.toURI().toString());
        cardView.setImage(image);
        cardDeck.getCardDeck().remove(0);
        cardDeck.getCardDeck().add(cardForDisplay);
        return cardForDisplay;
    }

    public MatrixField getField(int availableFieldId) {
        MatrixField field = null;

        for (int i = 0; i < StartData.getMatrixDimensions(); i++) {
            for (int j = 0; j < StartData.getMatrixDimensions(); j++) {
                if (StartData.getMatrixAvailableFields().get(availableFieldId).getFieldId() != -1 &&
                        StartData.getMatrixAvailableFields().get(availableFieldId).getX() == i &&
                        StartData.getMatrixAvailableFields().get(availableFieldId).getY() == j) {
                    field = fieldMatrix[i][j];
                }
            }
        }
        return field;
    }

    public void setFigureOnField(MatrixField field, Figure figure) {
        Platform.runLater(() -> {
            if (field.isHasDiamond()) {
                field.getChildren().clear();
                field.setHasDiamond(false);
            }
            ImageView figureImage = figure.getFigure();
            field.getChildren().add(figureImage);
            AnchorPane.setBottomAnchor(figureImage, 2.0);
            AnchorPane.setLeftAnchor(figureImage, 2.0);
        });
    }
    public void setGame(ActionEvent actionEvent) throws InterruptedException {
        buttonFlag = !buttonFlag;
        counter++;
        GhostDiamond ghostDiamond = new GhostDiamond();
        System.out.println("main " + buttonFlag);
        GameDuration gameDuration = new GameDuration(gameTime);
        PlayingGame playingGame = new PlayingGame();

        if(counter == 1) {
            System.out.println(counter);
            ghostDiamond.start();
            gameDuration.start();
            playingGame.start();
        }
        if (buttonFlag) {
        synchronized (fieldMatrix) {
            fieldMatrix.notifyAll();
        }
    }
//        ghostDiamond.join();
//        gameDuration.join();
    }
}