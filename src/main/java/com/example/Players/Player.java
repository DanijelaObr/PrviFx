package com.example.Players;

import com.example.figures.Figure;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Color color;
    private List<Figure> figures = new ArrayList<>();
    private boolean isStillPlaying;

    public Player(String name, Color color, List<Figure> figures) {
        this.name = name;
        this.color = color;
        this.figures = figures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Figure> getFigures() {
        return figures;
    }

    public void setFigures(List<Figure> figures) {
        this.figures = figures;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isStillPlaying() {
        return isStillPlaying;
    }

    public void setStillPlaying(boolean stillPlaying) {
        isStillPlaying = stillPlaying;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", figures=" + figures +
                '}' + '\n';
    }
}
