package com.example.Players;

import com.example.figures.Figure;
import com.example.figures.FlyingFigure;
import com.example.figures.OrdinaryFigure;
import com.example.figures.SuperFastFigure;
import com.example.utill.FileReader;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class GeneratePlayersAndFigures {
    public static List<String> redFiguresPaths = new ArrayList<>();
    public static List<String> yellowFiguresPaths = new ArrayList<>();
    public static List<String> blueFiguresPaths = new ArrayList<>();
    public static List<String> blackFiguresPaths = new ArrayList<>();
    static FileReader fileReaderRed = new FileReader();
    static FileReader fileReaderYellow = new FileReader();
    static FileReader fileReaderBlue = new FileReader();
    static FileReader fileReaderBlack = new FileReader();

    static String name;
    static List<Player> players = new ArrayList<>();

    public static void getRedFigures() {
        redFiguresPaths = fileReaderRed.readImageSources("src/main/resources/figures/figures-files/red-figures-paths.txt");
    }

    public static void getYellowFigures() {
        yellowFiguresPaths = fileReaderYellow.readImageSources("src/main/resources/figures/figures-files/yellow-figures-paths.txt");
    }

    public static void getBlueFigures() {
        blueFiguresPaths = fileReaderBlue.readImageSources("src/main/resources/figures/figures-files/blue-figures-paths.txt");
    }

    public static void getBlackFigures() {
        blackFiguresPaths = fileReaderBlack.readImageSources("src/main/resources/figures/figures-files/black-figures-paths.txt");
    }

    public static List<Player> generatePlayersAndFigures(int numberOfPlayers) throws Exception {
        Random rand = new Random();
        List<Color> colors = new ArrayList<>();
        getRedFigures();
        getBlackFigures();
        getBlueFigures();
        getYellowFigures();

        colors.add(Color.RED);
        colors.add(Color.BLUE);
        colors.add(Color.BLACK);
        colors.add(Color.YELLOW);
        Collections.shuffle(colors);
        System.out.println(colors);

        for (int i = 0; i < numberOfPlayers; i++) {
            List<Figure> figures = new ArrayList<>();
            if ((Color.RED).equals(colors.get(i))) {
                OrdinaryFigure ordinaryFigure = new OrdinaryFigure(colors.get(i), redFiguresPaths.get(0));
                SuperFastFigure superFastFigure = new SuperFastFigure(colors.get(i), redFiguresPaths.get(1));
                FlyingFigure flyingFigure = new FlyingFigure(colors.get(i), redFiguresPaths.get(2));
                figures.add(ordinaryFigure);
                figures.add(superFastFigure);
                figures.add(flyingFigure);
            }

            else if ((Color.BLUE).equals(colors.get(i))) {
                OrdinaryFigure ordinaryFigure = new OrdinaryFigure(colors.get(i), blueFiguresPaths.get(0));
                SuperFastFigure superFastFigure = new SuperFastFigure(colors.get(i), blueFiguresPaths.get(1));
                FlyingFigure flyingFigure = new FlyingFigure(colors.get(i), blueFiguresPaths.get(2));
                figures.add(ordinaryFigure);
                figures.add(superFastFigure);
                figures.add(flyingFigure);
            }

            else if ((Color.BLACK).equals(colors.get(i))) {
                OrdinaryFigure ordinaryFigure = new OrdinaryFigure(colors.get(i), blackFiguresPaths.get(0));
                SuperFastFigure superFastFigure = new SuperFastFigure(colors.get(i), blackFiguresPaths.get(1));
                FlyingFigure flyingFigure = new FlyingFigure(colors.get(i), blackFiguresPaths.get(2));
                figures.add(ordinaryFigure);
                figures.add(superFastFigure);
                figures.add(flyingFigure);
            }

            else if ((Color.YELLOW).equals(colors.get(i))) {
                OrdinaryFigure ordinaryFigure = new OrdinaryFigure(colors.get(i), yellowFiguresPaths.get(0));
                SuperFastFigure superFastFigure = new SuperFastFigure(colors.get(i), yellowFiguresPaths.get(1));
                FlyingFigure flyingFigure = new FlyingFigure(colors.get(i), yellowFiguresPaths.get(2));
                figures.add(ordinaryFigure);
                figures.add(superFastFigure);
                figures.add(flyingFigure);
            }



            List<Figure> randomFigures = new ArrayList<>();

            for (int j = 0; j < 4; j++) {
                int id = rand.nextInt(3);
                System.out.println(id);
                randomFigures.add(figures.get(id));
            }
            name = "Igrac " + i;

            Player player = new Player(name, colors.get(i), randomFigures);
            System.out.println("Igrac: " + player);
            players.add(player);
        }

        //provjera da li su imena i boje igraca razlicite
        for (int i = 0; i < numberOfPlayers; i++) {
            for (int j = i + 1; j >= i && j < numberOfPlayers; j++) {
                if (players.get(i).getName() == players.get(j).getName()) {
                    throw new Exception();
                } else System.out.println("razlicito ime");
            }
        }

        for (int i = 0; i < numberOfPlayers; i++) {
            for (int j = i + 1; j >= i && j < numberOfPlayers; j++) {
                if (players.get(i).getColor() == players.get(j).getColor()) {
                    throw new Exception();
                } else System.out.println("razlicita boja");
            }
        }
        System.out.println(players);
        return players;
    }
}
