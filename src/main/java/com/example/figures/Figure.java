package com.example.figures;

import com.example.startData.MatrixField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.io.File;
import java.util.List;

public abstract class Figure {
    protected Color color;
    protected String image;
    protected ImageView figure;
    protected int numberOfDiamonds;
    protected int numberOfFields;
    protected List<MatrixField> currentPath;
    protected boolean canFly;
    protected boolean hasFallen;
    protected int figureId = 0;
    protected static int figureToAddId = 0;


    protected int currentField;
    protected int previousField;

    public abstract int moving(int numberOfFields);

    public Figure(Color color, String image) {
        this.color = color;
        this.image = image;
        File file = new File(image);
        Image imageFigure = new Image(file.toURI().toString());
        this.figure = new ImageView(imageFigure);
        this.currentField = 0;
        this.figureId = figureToAddId++;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getFigureId() {
        return figureId;
    }

    public void setFigureId(int figureId) {
        this.figureId = figureId;
    }

    public ImageView getFigure() {
        return figure;
    }

    public void setFigure(ImageView figure) {
        this.figure = figure;
    }

    public int getNumberOfDiamonds() {
        return numberOfDiamonds;
    }

    public void setNumberOfDiamonds(int numberOfDiamonds) {
        this.numberOfDiamonds = numberOfDiamonds;
    }

    public int getNumberOfFields() {
        return numberOfFields;
    }

    public void setNumberOfFields(int numberOfFields) {
        this.numberOfFields = numberOfFields;
    }

    public List<MatrixField> getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(List<MatrixField> currentPath) {
        this.currentPath = currentPath;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public boolean isHasFallen() {
        return hasFallen;
    }

    public void setHasFallen(boolean hasFallen) {
        this.hasFallen = hasFallen;
    }

    public int getCurrentField() {
        return currentField;
    }

    public void setCurrentField(int currentField) {
        this.currentField = currentField;
    }

    public int getPreviousField() {
        return previousField;
    }

    public void setPreviousField(int previousField) {
        this.previousField = previousField;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "color='" + color + '\'' +
                ", numberOfDiamonds=" + numberOfDiamonds +
                ", numberOfFields=" + numberOfFields +
                ", currentPath=" + currentPath +
                ", canFly=" + canFly +
                ", hasFallen=" + hasFallen +
                ", image=" + image +
                '}' + '\n';
    }
}
