package com.example.figures;

import javafx.scene.paint.Color;

public class SuperFastFigure extends Figure{
    public SuperFastFigure(Color color, String image) {
        super(color, image);
        this.numberOfFields = 2;
        this.canFly = false;
    }

    @Override
    public int moving(int numberOfFields) {return numberOfFields * 2 + numberOfDiamonds;}
}
