package com.example.startData;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class MatrixField extends AnchorPane {
    private int x;
    private int y;
    private int fieldId;
    private boolean hasDiamond = false;

    public boolean isHasDiamond() {
        return hasDiamond;
    }

    public void setHasDiamond(boolean hasDiamond) {
        this.hasDiamond = hasDiamond;
    }

    public MatrixField(int x, int y, int fieldId, Node... nodes) {
        super(nodes);
        this.x = x;
        this.y = y;
        this.fieldId = fieldId;
    }

    public MatrixField() {

    }

    public MatrixField(int x, int y, int fieldId) {
        this.x = x;
        this.y = y;
        this.fieldId = fieldId;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int id) {
        this.fieldId = id;
    }

    @Override
    public String toString() {
        return "Field{" +
                "xFieldCoordinate=" + x +
                ", yFieldCoordinate=" + y +
                ", idOfField=" + fieldId +
                '}';
    }
}
