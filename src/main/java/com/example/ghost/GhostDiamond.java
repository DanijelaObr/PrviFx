package com.example.ghost;

import com.example.projekatDiamondCircle.DiamondCircleController;
import com.example.startData.MatrixField;
import com.example.startData.StartData;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GhostDiamond extends Thread {

    int counter = 0;

    @Override
    public void run() {
        while (isAlive()) {
//            System.out.println("Ghost "+ DiamondCircleController.buttonFlag);
            synchronized (DiamondCircleController.fieldMatrix) {
                try {
                        if (!DiamondCircleController.buttonFlag) {
                            DiamondCircleController.fieldMatrix.wait();
                        }
                    if(counter > 0) {
                        for (int k = 0; k < StartData.getMatrixAvailableFields().size(); k++) {
                            for (int i = 0; i < StartData.getMatrixDimensions(); i++) {
                                for (int j = 0; j < StartData.getMatrixDimensions(); j++) {
                                    if (StartData.getMatrixAvailableFields().get(k).getFieldId() != -1 && StartData.getMatrixAvailableFields().get(k).getX() == i &&
                                            StartData.getMatrixAvailableFields().get(k).getY() == j && DiamondCircleController.fieldMatrix[i][j].isHasDiamond()) {
                                            final int row = i;
                                            final int column = j;
                                            final int id = k;
                                            Platform.runLater(() -> {
                                                DiamondCircleController.fieldMatrix[row][column].getChildren().clear();
                                                DiamondCircleController.fieldMatrix[row][column].setHasDiamond(false);
//                                            DiamondCircleController.fieldMatrix[row][column].setStyle("-fx-background-color: rgb( \" + r + \",\" + g + \",\" + b + \");\" + \"-fx-border-color: black;");
//                                            DiamondCircleController.fieldMatrix[row][column].setStyle(DiamondCircleController.gradation.get(id));
                                            });
                                    }
                                }
                            }
                        }
                    }

                    Random random = new Random();
                    int numberOfDiamonds = random.nextInt(StartData.getMatrixDimensions() - 1) + 2;
                    List<Integer> diamondFields = new ArrayList<>();
                    for (int i = 0; i < numberOfDiamonds; i++) {
                        int id = random.nextInt(StartData.getMatrixAvailableFields().size());
                        if (!diamondFields.contains(id)) {
                            diamondFields.add(id);
                        } else {
                            i--;
                        }
                    }

                    for (int k = 0; k < StartData.getMatrixAvailableFields().size(); k++) {
                        if (diamondFields.contains(k + 1))
                            for (int i = 0; i < StartData.getMatrixDimensions(); i++) {
                                for (int j = 0; j < StartData.getMatrixDimensions(); j++) {
                                    if (StartData.getMatrixAvailableFields().get(k).getFieldId() != -1) {
                                        if (StartData.getMatrixAvailableFields().get(k).getX() == i && StartData.getMatrixAvailableFields().get(k).getY() == j) {
                                            final int row = i;
                                            final int column = j;
                                            Platform.runLater(() -> {
                                                File file = new File("src/main/resources/diamondSmall.png");
                                                Image image = new Image(file.toURI().toString());
                                                ImageView diamond = new ImageView(image);
//                                                File file2 = new File("src/main/resources/specialDiamond.jpg");
//                                                Image image2 = new Image(file2.toURI().toString());
//                                                ImageView diamond2 = new ImageView(image2);
                                                MatrixField matrixField = DiamondCircleController.fieldMatrix[row][column];
                                                matrixField.getChildren().add(diamond);
//                                                matrixField.getChildren().add(diamond2);
                                                matrixField.setHasDiamond(true);
//                                                matrixField.setStyle("-fx-background-color:lightgrey");
                                                AnchorPane.setTopAnchor(diamond, 2.0);
                                                AnchorPane.setRightAnchor(diamond, 2.0);
                                            });
                                        }
                                    }
                                }
                            }
                    }
                    counter++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
