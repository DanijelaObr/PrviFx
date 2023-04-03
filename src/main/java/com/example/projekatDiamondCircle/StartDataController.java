package com.example.projekatDiamondCircle;

import com.example.startData.StartData;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

public class StartDataController {

   public static boolean flag = false;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button startAppButton;

    @FXML
    public ChoiceBox numberOfPlayers;

    @FXML
    public ChoiceBox matrixDimensions;
    public static DiamondCircleController diamondCircleController;

    public void setCard() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main-diamond-circle.fxml"));
        root = loader.load();
        DiamondCircleController mainController = loader.getController();
        mainController.displayCard();
    }

    public void startApplication(ActionEvent event) throws IOException {

        StartData.setMatrixDimensions(((String) matrixDimensions.getValue()).split("x")[0]);
        StartData.setNumberOfPlayers(((String) numberOfPlayers.getValue()));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("main-diamond-circle.fxml"));
        root = loader.load();

//        DiamondCircleController mainController = loader.getController();
        //mainController.displayName(numbOfPlayers);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setOnCloseRequest(x -> {
            Platform.exit();
            System.exit(0);
        });
        stage.show();
        diamondCircleController = loader.getController();


    }
}
