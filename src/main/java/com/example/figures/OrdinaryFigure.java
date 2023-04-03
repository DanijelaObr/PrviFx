package com.example.figures;

import javafx.scene.paint.Color;

public class OrdinaryFigure extends Figure {

    public OrdinaryFigure(Color color, String image) {
        super(color, image);
        this.numberOfFields = 1;
        this.canFly = false;
    }

    public void setCanFly() {}

    public void getHasFallenIntoAHole(boolean hasFallen) {
        this.hasFallen = hasFallen;
    }

    @Override
    public int moving(int numberOfFields) {//nacin kretanja obicne figure
        return numberOfFields + numberOfDiamonds;
    }
}
