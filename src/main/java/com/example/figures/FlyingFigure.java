package com.example.figures;

import javafx.scene.paint.Color;

public class FlyingFigure extends Figure{

    public FlyingFigure(Color color, String image) {
        super(color, image);
        this.numberOfFields = 1;
        this.canFly = true;
    }

    @Override
    public int moving(int numberOfFields) {return numberOfFields + numberOfDiamonds;}
}
